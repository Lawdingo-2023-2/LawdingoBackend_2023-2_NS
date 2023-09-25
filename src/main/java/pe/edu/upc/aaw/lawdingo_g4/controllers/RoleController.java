package pe.edu.upc.aaw.lawdingo_g4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.lawdingo_g4.dtos.RoleDTO;
import pe.edu.upc.aaw.lawdingo_g4.entities.Role;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.IRoleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@SessionAttributes
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IRoleService rService;

    @PostMapping
    public void insert(@RequestBody RoleDTO dto){
        ModelMapper m = new ModelMapper();
        Role e = m.map(dto,Role.class);
        rService.insert(e);
    }

    @GetMapping
    public List<RoleDTO>list(){
        return rService.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RoleDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public RoleDTO listId(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        RoleDTO dto = m.map(rService.listId(id), RoleDTO.class);
        return dto;
    }
    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void goUpdate(@RequestBody RoleDTO dto){
        ModelMapper m = new ModelMapper();
        Role e = m.map(dto,Role.class);
        rService.insert(e);
    }



}
