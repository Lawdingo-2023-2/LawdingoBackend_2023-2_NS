package pe.edu.upc.aaw.lawdingo_g4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.lawdingo_g4.dtos.ProceedingDTO;
import pe.edu.upc.aaw.lawdingo_g4.dtos.ProceedingSummaryDTO;
import pe.edu.upc.aaw.lawdingo_g4.entities.Proceeding;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.IProceedingService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/proceedings")
public class ProceedingController {
    @Autowired
    private IProceedingService pS;
    @PostMapping
    public void registrar(@RequestBody ProceedingDTO dto){
        ModelMapper m = new ModelMapper();
        Proceeding p = m.map(dto, Proceeding.class);
        pS.insert(p);
    }
    @PutMapping
    public void modificar(@RequestBody ProceedingDTO dto) {
        ModelMapper m = new ModelMapper();
        Proceeding p = m.map(dto, Proceeding.class);
        pS.insert(p);
    }
    @GetMapping
    public List<ProceedingDTO> listar(){
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProceedingDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        pS.delete(id);
    }
    @GetMapping("/resumenexpediente")
    public List<ProceedingSummaryDTO> resumenExpediente(){
        List<String[]> lista=pS.proceedingSummary();
        List<ProceedingSummaryDTO> listaDTO=new ArrayList<>();
        for(String[] data:lista){
            ProceedingSummaryDTO dto=new ProceedingSummaryDTO();
            dto.setId_proceeding(Integer.parseInt(data[0]));
            dto.setName(data[1]);
            dto.setName_client(data[2]);
            dto.setName_lawyer(data[3]);
            dto.setName_court(data[4]);
            dto.setNum_doc(Integer.parseInt(data[5]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
