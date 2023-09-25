package pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces;

import pe.edu.upc.aaw.lawdingo_g4.entities.Certification;

import java.util.List;
import java.util.Optional;

public interface ICertificationService {

    public void insert(Certification certification);
    public List<Certification> list();
    public void delete(int idCertification);
    public Certification listId(int idCertification);

}
