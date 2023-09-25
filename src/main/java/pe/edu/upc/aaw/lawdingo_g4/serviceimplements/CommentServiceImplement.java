package pe.edu.upc.aaw.lawdingo_g4.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.lawdingo_g4.entities.Comment;
import pe.edu.upc.aaw.lawdingo_g4.repositories.ICommentRepository;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.ICommentService;

import java.util.List;

@Service
public class CommentServiceImplement implements ICommentService {
    @Autowired
    private ICommentRepository pR;

    @Override
    public void insert(Comment comment) {
        pR.save(comment);
    }

    @Override
    public List<Comment> list() {
        return pR.findAll();
    }

    @Override
    public void delete(int idCourt) {
        pR.deleteById(idCourt);
    }

    @Override
    public List<String[]> listCommentByLawyer(int idLaw) {
        return pR.listCommentByLawyer(idLaw);
    }
}
