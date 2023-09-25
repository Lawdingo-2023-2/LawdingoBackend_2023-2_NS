package pe.edu.upc.aaw.lawdingo_g4.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.lawdingo_g4.entities.Court;
import pe.edu.upc.aaw.lawdingo_g4.repositories.ICourtRepository;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.ICourtService;

import java.util.List;

@Service
public class CourtServiceImplement implements ICourtService {
    @Autowired
    private ICourtRepository cR;

    @Override
    public void insert(Court court) {
        cR.save(court);
    }

    @Override
    public List<Court> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int idCourt) {
        cR.deleteById(idCourt);
    }

    @Override
    public Court listId(int idCourt) {
        return cR.findById(idCourt).orElse(new Court());
    }

    @Override
    public List<Court> findByName(String name) {
        return cR.findByName(name);
    }


}
