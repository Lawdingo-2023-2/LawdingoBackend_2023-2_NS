package pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces;

import pe.edu.upc.aaw.lawdingo_g4.entities.District;

import java.util.List;

public interface IDistrictService {
    public void insert(District district);
    public List<District> list();
    public void delete(int idDistrict);
    public District listId(int idDistrict);
    public List<String[]> quantityProceedingByDistrict();
}
