package pe.edu.upc.aaw.lawdingo_g4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.lawdingo_g4.entities.District;

import java.util.List;

@Repository
public interface IDistrictRepository extends JpaRepository<District, Integer> {

    @Query(value = "select d.name, count(r.id_proceeding) as total_procedimientos\n" +
            "\n"+"" +
            "from District d\n" +
            "\n"+"" +
            "left join Court o on d.id_district = o.id_district\n" +
            "\n"+"" +
            "left join Proceeding r on o.id_court = r.id_court\n" +
            "\n"+"" +
            "group by d.id_district, d.name;", nativeQuery = true)
    public List<String[]> quantityProceedingByDistrict();
}
