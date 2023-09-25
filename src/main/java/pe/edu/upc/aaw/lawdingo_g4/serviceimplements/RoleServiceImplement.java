package pe.edu.upc.aaw.lawdingo_g4.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.lawdingo_g4.entities.Role;
import pe.edu.upc.aaw.lawdingo_g4.repositories.IRoleRepository;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.IRoleService;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
    private IRoleRepository rR;

    @Override
    public void insert(Role role) {
        rR.save(role);
    }

    @Override
    public List<Role> list() {
        // TODO Auto-generated method stub
        return rR.findAll();
    }

    @Override
    public Role listId(int id) {
        return rR.findById(id).orElse(new Role());
    }
}
