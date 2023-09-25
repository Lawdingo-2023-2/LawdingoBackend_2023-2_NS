package pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces;

import pe.edu.upc.aaw.lawdingo_g4.entities.Category;

import java.util.List;

public interface ICategoryService {
    public void insert(Category category);
    List<Category>list();
    public List<String[]> querieCategory();


}
