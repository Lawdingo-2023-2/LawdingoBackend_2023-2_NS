package pe.edu.upc.aaw.lawdingo_g4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.aaw.lawdingo_g4.entities.Users;

import java.util.List;

@Repository
public interface IUsersRepository extends JpaRepository<Users,Integer> {

    // Consulta personalizada utilizando @Query
    @Query(value = "SELECT * FROM Users WHERE name LIKE :startsWith%", nativeQuery = true)
    List<Users> findByStartingLetter(@Param("startsWith") String startsWith);

    List<Users>findByName(String name);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);


    public Users findByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from Users u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);




}
