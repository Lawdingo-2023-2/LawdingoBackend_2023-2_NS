package pe.edu.upc.aaw.lawdingo_g4.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.lawdingo_g4.entities.Documentation;
import pe.edu.upc.aaw.lawdingo_g4.repositories.IDocumentationRepository;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.IDocumentationService;

import java.util.List;

@Service
public class DocumentationServiceImplement implements IDocumentationService {
    @Autowired
    private IDocumentationRepository dR;

    @Override
    public void insert(Documentation documentation) {
        dR.save(documentation);

    }

    @Override
    public List<Documentation> list() {
        return dR.findAll();
    }

    @Override
    public void delete(int idDocumentation) {
        dR.deleteById(idDocumentation);
    }

    @Override
    public Documentation listId(int idDocumentation) {
        return dR.findById(idDocumentation).orElse(new Documentation());
    }
}
