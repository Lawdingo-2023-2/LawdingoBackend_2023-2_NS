package pe.edu.upc.aaw.lawdingo_g4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.aaw.lawdingo_g4.entities.Proceeding;

import java.util.List;

public interface IProceedingRepository extends JpaRepository<Proceeding, Integer> {
    @Query(value = "select p.id_proceeding, p.name, c.name as client, l.name as lawyer, u.name as court, count(d.id_documentation) as numdoc \n" +
            " from proceeding p \n" +
            " inner join documentation d\n" +
            " on p.id_proceeding=d.id_proceeding\n" +
            " inner join users c \n" +
            " on p.id_client=c.id_user\n" +
            " inner join users l \n" +
            " on p.id_lawyer=l.id_user\n" +
            " inner join court u\n" +
            " on p.id_court=u.id_court\n" +
            " group by p.id_proceeding, c.name, l.name, u.name",nativeQuery = true)
    public List<String[]> proceedingSummary();
}
