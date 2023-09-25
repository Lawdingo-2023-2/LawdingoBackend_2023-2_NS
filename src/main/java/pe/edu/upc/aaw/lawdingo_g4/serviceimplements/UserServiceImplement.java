package pe.edu.upc.aaw.lawdingo_g4.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.lawdingo_g4.entities.Users;
import pe.edu.upc.aaw.lawdingo_g4.repositories.IUsersRepository;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {

    @Autowired
    private IUsersRepository uR;
    @Override
    public Integer insert(Users users) {
        int rpta = uR.buscarUsername(users.getUsername());
        if (rpta == 0) {
            uR.save(users);
        }
        return rpta;
    }

    @Override
    public List<Users> list() {
        //TODO Auto-generated method stub
        return uR.findAll();
    }


    @Override
    public List<Users> getUsersWhoseNameStartsWith(String startsWith) {
        return  uR.findByStartingLetter(startsWith);
    }


    @Override
    public void  delete(int idUser) {
        uR.deleteById(idUser);
    }


}
