package pe.edu.upc.aaw.lawdingo_g4.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.lawdingo_g4.entities.District;
import pe.edu.upc.aaw.lawdingo_g4.repositories.IDistrictRepository;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.IDistrictService;

import java.util.List;

@Service
public class DistrictServiceImplement implements IDistrictService {
    @Autowired
    private IDistrictRepository dR;

    @Override
    public void insert(District district) {
        dR.save(district);

    }

    @Override
    public List<District> list() {
        return dR.findAll();
    }

    @Override
    public void delete(int idDistrict) {
        dR.deleteById(idDistrict);
    }

    @Override
    public District listId(int idDistrict) {
        return dR.findById(idDistrict).orElse(new District());
    }

    @Override
    public List<String[]> quantityProceedingByDistrict() {
        return dR.quantityProceedingByDistrict();
    }
}
