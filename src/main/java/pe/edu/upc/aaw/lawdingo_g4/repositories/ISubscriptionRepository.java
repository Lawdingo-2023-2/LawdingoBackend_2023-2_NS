package pe.edu.upc.aaw.lawdingo_g4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.lawdingo_g4.entities.Subscription;


import java.util.List;

@Repository
public interface ISubscriptionRepository extends JpaRepository<Subscription,Integer> {
    List<Subscription> findByName(String name);

    @Query(value = "select s.name as NombreSuscripcion, count(*) as Cantidadusuarios\n" +
            "from Subscription s inner join Users u\n" +
            "on s.id_user=u.id_user\n" +
            "group by s.name",nativeQuery = true)
    List<String[]>quantitySubscriptionByUsers();


}
