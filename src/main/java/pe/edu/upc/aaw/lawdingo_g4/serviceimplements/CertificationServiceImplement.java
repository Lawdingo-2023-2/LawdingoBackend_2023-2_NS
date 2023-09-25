package pe.edu.upc.aaw.lawdingo_g4.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.lawdingo_g4.entities.Certification;
import pe.edu.upc.aaw.lawdingo_g4.repositories.ICertificationRepository;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.ICertificationService;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationServiceImplement implements ICertificationService {

    @Autowired
    private ICertificationRepository jR;

    @Override
    public void insert(Certification certification) {
        jR.save(certification);
    }

    @Override
    public List<Certification> list() {
        return jR.findAll();
    }

    @Override
    public void delete(int idCertification) {
        jR.deleteById(idCertification);
    }

    @Override
    public Certification listId(int idCertification) {
        return jR.findById(idCertification).orElse(new Certification());
    }


}
