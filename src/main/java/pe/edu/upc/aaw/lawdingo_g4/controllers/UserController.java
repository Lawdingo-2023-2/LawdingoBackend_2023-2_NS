package pe.edu.upc.aaw.lawdingo_g4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pe.edu.upc.aaw.lawdingo_g4.dtos.CategoryDTO;
import pe.edu.upc.aaw.lawdingo_g4.dtos.CourtDTO;
import pe.edu.upc.aaw.lawdingo_g4.dtos.UserDTO;
import pe.edu.upc.aaw.lawdingo_g4.entities.Category;
import pe.edu.upc.aaw.lawdingo_g4.entities.Users;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.IUserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private String pass;
    @Autowired
    private IUserService uS;


    @PostMapping("/save")
    public void saveUser(@RequestBody UserDTO dto){
        ModelMapper m = new ModelMapper();
        Users u =m.map(dto,Users.class);
        uS.insert(u);
    }

    //PROBAR

    @GetMapping("/startsWith/{letter}")
    public List<Users> getUsersWhoseNameStartsWith(@PathVariable String letter) {
        return uS.getUsersWhoseNameStartsWith(letter);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        uS.delete(id);
    }

    @GetMapping
    public List<UserDTO> list(){
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }
    @PutMapping()
    //@PreAuthorize("hasAuthority('ADMIN')")
    public void goUpdate(@RequestBody UserDTO dto){
        ModelMapper m=new ModelMapper();
        Users u=m.map(dto,Users.class);
        uS.insert(u);
    }
}



