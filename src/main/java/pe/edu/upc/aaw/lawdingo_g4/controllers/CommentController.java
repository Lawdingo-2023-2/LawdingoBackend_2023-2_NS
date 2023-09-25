package pe.edu.upc.aaw.lawdingo_g4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.lawdingo_g4.dtos.CommentByLawyerDTO;
import pe.edu.upc.aaw.lawdingo_g4.dtos.CommentDTO;
import pe.edu.upc.aaw.lawdingo_g4.entities.Comment;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.ICommentService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private ICommentService cS;
    @PostMapping
    public void registrar(@RequestBody CommentDTO dto){
        ModelMapper m = new ModelMapper();
        Comment c = m.map(dto, Comment.class);
        cS.insert(c);
    }
    @PutMapping
    public void modificar(@RequestBody CommentDTO dto) {
        ModelMapper m = new ModelMapper();
        Comment c = m.map(dto, Comment.class);
        cS.insert(c);
    }
    @GetMapping
    public List<CommentDTO> listar(){
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CommentDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        cS.delete(id);
    }
    @GetMapping("/listCommentByLawyer")
    public List<CommentByLawyerDTO> listarPorIdAbogado(@RequestParam Integer idLaw){
        List<String[]> lista = cS.listCommentByLawyer(idLaw);
        List<CommentByLawyerDTO> listaDTO = new ArrayList<>();
        for (String[] data:lista){
            CommentByLawyerDTO dto = new CommentByLawyerDTO();
            dto.setName_of_client(data[0]);
            dto.setDescription(data[1]);
            dto.setScore(Integer.parseInt(data[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
