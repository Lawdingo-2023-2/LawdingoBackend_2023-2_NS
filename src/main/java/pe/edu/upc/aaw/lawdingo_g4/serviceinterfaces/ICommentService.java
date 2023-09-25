package pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces;

import pe.edu.upc.aaw.lawdingo_g4.entities.Comment;

import java.util.List;

public interface ICommentService {
    public void insert(Comment comment);
    public List<Comment> list();
    public void delete(int idCourt);
    public List<String[]> listCommentByLawyer(int idLaw);
}
