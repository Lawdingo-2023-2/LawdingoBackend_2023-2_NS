package pe.edu.upc.aaw.lawdingo_g4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.lawdingo_g4.entities.Role;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer> {

}
