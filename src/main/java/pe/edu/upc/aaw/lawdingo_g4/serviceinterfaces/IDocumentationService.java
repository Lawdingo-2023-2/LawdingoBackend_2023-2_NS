package pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces;

import pe.edu.upc.aaw.lawdingo_g4.entities.Documentation;

import java.util.List;

public interface IDocumentationService {
    public void insert(Documentation documentation);
    public List<Documentation> list();
    public void delete(int idDistrict);
    public Documentation listId(int idDocumentation);
}
