package pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces;

import pe.edu.upc.aaw.lawdingo_g4.entities.Users;

import java.util.List;

public interface IUserService {
    public Integer insert(Users users);

    List<Users> list();

    public List <Users> getUsersWhoseNameStartsWith(String startsWith);

    public void  delete (int idUser);

}
