package pe.edu.upc.aaw.lawdingo_g4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.lawdingo_g4.dtos.DistrictDTO;
import pe.edu.upc.aaw.lawdingo_g4.dtos.ProceedingByDistrictDTO;
import pe.edu.upc.aaw.lawdingo_g4.entities.District;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.IDistrictService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/districts")
public class DistrictController {
    @Autowired
    private IDistrictService dS;
    @PostMapping
    public void registrar(@RequestBody DistrictDTO dto){
        ModelMapper m = new ModelMapper();
        District d=m.map(dto,District.class);
        dS.insert(d);
    }
    @PutMapping
    public void modificar(@RequestBody DistrictDTO dto) {
        ModelMapper m = new ModelMapper();
        District d = m.map(dto, District.class);
        dS.insert(d);
    }

    @GetMapping
    public List<DistrictDTO> listar(){
        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DistrictDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        dS.delete(id);
    }
    @GetMapping("/{id}")
    public DistrictDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m = new ModelMapper();
        DistrictDTO dto=m.map(dS.listId(id), DistrictDTO.class);
        return dto;
    }


    @GetMapping("/cantidadprocedimientospordistrito")
    public List<ProceedingByDistrictDTO> cantidadProcedimientosPorDistrito(){
        List<String[]> lista = dS.quantityProceedingByDistrict();
        List<ProceedingByDistrictDTO> listaDTO = new ArrayList<>();
        for(String[] data : lista){
            ProceedingByDistrictDTO dto = new ProceedingByDistrictDTO();
            dto.setNameDistrict(data[0]);
            dto.setQuantityProceeding(Integer.parseInt(data[1]));
        }
        return listaDTO;
    }

}
