package pe.edu.upc.aaw.lawdingo_g4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.lawdingo_g4.dtos.CertificationDTO;
import pe.edu.upc.aaw.lawdingo_g4.dtos.NotificationDTO;
import pe.edu.upc.aaw.lawdingo_g4.entities.Category;
import pe.edu.upc.aaw.lawdingo_g4.entities.Certification;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.ICertificationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/certification")
public class CertificationController {

    @Autowired
    private ICertificationService jS;

    @PostMapping
    public void registar(@RequestBody CertificationDTO dto){
        ModelMapper m = new ModelMapper();
        Certification n = m.map(dto, Certification.class);
        jS.insert(n);
    }

    @GetMapping
    public List<CertificationDTO> listar(){
        return jS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, CertificationDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        jS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody CertificationDTO dto){
        ModelMapper m = new ModelMapper();
        Certification n = m.map(dto, Certification.class);
        jS.insert(n);
    }

    @GetMapping("/{id}")
    public CertificationDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        CertificationDTO dto=m.map(jS.listId(id), CertificationDTO.class);
        return dto;
    }
}
