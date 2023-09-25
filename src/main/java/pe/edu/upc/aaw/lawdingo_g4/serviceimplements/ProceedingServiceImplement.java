package pe.edu.upc.aaw.lawdingo_g4.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.lawdingo_g4.entities.Proceeding;
import pe.edu.upc.aaw.lawdingo_g4.repositories.IProceedingRepository;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.IProceedingService;

import java.util.List;

@Service
public class ProceedingServiceImplement implements IProceedingService {

    @Autowired
    private IProceedingRepository pR;

    @Override
    public void insert(Proceeding proceeding) {
        pR.save(proceeding);
    }

    @Override
    public List<Proceeding> list() {
        return pR.findAll();
    }

    @Override
    public void delete(int idProceeding) {
        pR.deleteById(idProceeding);
    }

    @Override
    public List<String[]> proceedingSummary() {
        return pR.proceedingSummary();
    }

}
