package pe.edu.upc.aaw.lawdingo_g4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.lawdingo_g4.entities.Court;

import java.util.List;

@Repository
public interface ICourtRepository extends JpaRepository<Court,Integer> {
    List<Court>findByName(String name);
}
