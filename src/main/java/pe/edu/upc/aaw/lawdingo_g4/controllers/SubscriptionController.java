package pe.edu.upc.aaw.lawdingo_g4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.lawdingo_g4.dtos.SubscriptionDTO;
import pe.edu.upc.aaw.lawdingo_g4.dtos.UserDTO;
import pe.edu.upc.aaw.lawdingo_g4.dtos.UsersBySubscriptionDTO;
import pe.edu.upc.aaw.lawdingo_g4.entities.Subscription;
import pe.edu.upc.aaw.lawdingo_g4.entities.Users;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.ISubscriptionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {


    @Autowired
    private ISubscriptionService uS;

    @PostMapping
    public void create(@RequestBody SubscriptionDTO dto){
        ModelMapper m = new ModelMapper();
        Subscription c =m.map(dto,Subscription.class);
        uS.create(c);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    public List<SubscriptionDTO> list() {
        return uS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, SubscriptionDTO.class);

        }).collect(Collectors.toList());
    }


    @GetMapping("/cantidausuarioporsuscripcion")
    public List<UsersBySubscriptionDTO>cantidausuarioporsuscripcion (){
        List<String[]> lista = uS.querieSubscription();
        List<UsersBySubscriptionDTO> listDTO = new ArrayList<>();
        for(String[] data : lista){
            UsersBySubscriptionDTO dto = new UsersBySubscriptionDTO();
            dto.setNameSubscription(data[0]);
            dto.setCountUsers(Integer.parseInt(data[1]));
            listDTO.add(dto);

        }
        return listDTO;
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        uS.delete(id);
    }
    @PutMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public void goUpdate(@RequestBody SubscriptionDTO dto){
        ModelMapper m=new ModelMapper();
        Subscription u=m.map(dto,Subscription.class);
        uS.create(u);
    }




}
