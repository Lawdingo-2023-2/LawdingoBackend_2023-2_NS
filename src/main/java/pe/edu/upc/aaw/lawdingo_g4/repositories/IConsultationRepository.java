package pe.edu.upc.aaw.lawdingo_g4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.lawdingo_g4.entities.Consultation;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface IConsultationRepository extends JpaRepository<Consultation,Integer> {
    @Query("from Consultation v where v.date=:fecha")
    List<Consultation> findBypublicationDateConsultation(@Param("fecha") LocalDate fecha);
    @Query("SELECT COUNT(c) FROM Consultation c")
    Long cantidad();

}
