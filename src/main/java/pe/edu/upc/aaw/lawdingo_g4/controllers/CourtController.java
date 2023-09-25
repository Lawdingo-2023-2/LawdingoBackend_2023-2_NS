package pe.edu.upc.aaw.lawdingo_g4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.lawdingo_g4.dtos.CourtDTO;
import pe.edu.upc.aaw.lawdingo_g4.entities.Court;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.ICourtService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courts")
public class CourtController {
    @Autowired
    private ICourtService cS;
    @PostMapping
    public void registrar(@RequestBody CourtDTO dto){
        ModelMapper m = new ModelMapper();
        Court c=m.map(dto,Court.class);
        cS.insert(c);
    }
    @PutMapping
    public void modificar(@RequestBody CourtDTO dto) {
        ModelMapper m = new ModelMapper();
        Court c = m.map(dto, Court.class);
        cS.insert(c);
    }
    @GetMapping
    public List<CourtDTO>listar(){
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CourtDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        cS.delete(id);
    }
    @GetMapping("/{id}")
    public CourtDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        CourtDTO dto=m.map(cS.listId(id), CourtDTO.class);
        return dto;
    }

    @PostMapping("/buscar")
    public List<CourtDTO> buscar(@RequestBody String nombre){
        return cS.findByName(nombre).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CourtDTO.class);
        }).collect(Collectors.toList());
    }
}
