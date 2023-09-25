package pe.edu.upc.aaw.lawdingo_g4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.lawdingo_g4.dtos.CertificationDTO;
import pe.edu.upc.aaw.lawdingo_g4.dtos.DocumentationDTO;
import pe.edu.upc.aaw.lawdingo_g4.dtos.NotificationDTO;
import pe.edu.upc.aaw.lawdingo_g4.entities.Certification;
import pe.edu.upc.aaw.lawdingo_g4.entities.Notification;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.INotificationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private INotificationService jS;

    @PostMapping
    public void registar(@RequestBody NotificationDTO dto){
        ModelMapper m = new ModelMapper();
        Notification n = m.map(dto, Notification.class);
        jS.insert(n);
    }

    @GetMapping
    public List<NotificationDTO>listar(){
        return jS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificationDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        jS.delete(id);
    }



    @PutMapping
    public void modificar(@RequestBody NotificationDTO dto){
        ModelMapper m = new ModelMapper();
        Notification n = m.map(dto, Notification.class);
        jS.insert(n);
    }

    @GetMapping("/{id}")
    public NotificationDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        NotificationDTO dto=m.map(jS.listId(id), NotificationDTO.class);
        return dto;
    }
}
