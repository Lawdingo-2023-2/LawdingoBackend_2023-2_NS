package pe.edu.upc.aaw.lawdingo_g4.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.lawdingo_g4.entities.Category;
import pe.edu.upc.aaw.lawdingo_g4.repositories.ICategoryRepository;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.ICategoryService;

import java.util.List;

@Service
public class CategoryServiceImplement implements ICategoryService {
    @Autowired
    private ICategoryRepository tR;
    @Override
    public void insert(Category book) {
        tR.save(book);
    }

    @Override
    public List<Category> list() {
        return tR.findAll();
    }
    @Override
    public List<String[]> querieCategory() {
        return tR.quantityConsultationByCategory();
    }

}
