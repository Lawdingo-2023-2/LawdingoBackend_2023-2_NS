package pe.edu.upc.aaw.lawdingo_g4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.lawdingo_g4.dtos.ConsultationDTO;
import pe.edu.upc.aaw.lawdingo_g4.entities.Consultation;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.IConsultationService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {
    @Autowired
    private IConsultationService cS;
    @PostMapping
    public void insert(@RequestBody ConsultationDTO dto){
        ModelMapper m = new ModelMapper();
        Consultation a=m.map(dto, Consultation.class);
        cS.insert(a);
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public List<ConsultationDTO> list() {
        return cS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ConsultationDTO.class);

        }).collect(Collectors.toList());
    }
    @PutMapping()
    public void goUpdate(@RequestBody ConsultationDTO dto){
        ModelMapper m=new ModelMapper();
        Consultation u=m.map(dto,Consultation.class);
        cS.insert(u);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        cS.delete(id);
    }

    @PostMapping("/buscar")
    public List<ConsultationDTO> buscar(@RequestBody LocalDate fecha) {
        return cS.buscarFecha(fecha).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConsultationDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/contar")
    public Long contarConsultas() {
        return cS.contarConsultas();
    }

}
