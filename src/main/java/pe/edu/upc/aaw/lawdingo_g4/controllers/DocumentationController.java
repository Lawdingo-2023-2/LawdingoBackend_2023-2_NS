package pe.edu.upc.aaw.lawdingo_g4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.lawdingo_g4.dtos.DocumentationDTO;
import pe.edu.upc.aaw.lawdingo_g4.entities.Documentation;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.IDocumentationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/documentations")
public class DocumentationController {
    @Autowired
    private IDocumentationService dS;
    @PostMapping
    public void registrar(@RequestBody DocumentationDTO dto){
        ModelMapper m = new ModelMapper();
        Documentation d=m.map(dto,Documentation.class);
        dS.insert(d);
    }
    @PutMapping
    public void modificar(@RequestBody DocumentationDTO dto) {
        ModelMapper m = new ModelMapper();
        Documentation d = m.map(dto, Documentation.class);
        dS.insert(d);
    }
    @GetMapping
    public List<DocumentationDTO> listar(){
        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DocumentationDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        dS.delete(id);
    }
    @GetMapping("/{id}")
    public DocumentationDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        DocumentationDTO dto=m.map(dS.listId(id), DocumentationDTO.class);
        return dto;
    }
}
