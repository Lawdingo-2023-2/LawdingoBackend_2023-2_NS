package pe.edu.upc.aaw.lawdingo_g4.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.lawdingo_g4.entities.Subscription;
import pe.edu.upc.aaw.lawdingo_g4.repositories.ISubscriptionRepository;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.ISubscriptionService;

import java.util.List;

@Service
public class SubscriptionServiceImplement implements ISubscriptionService {

    @Autowired
    private ISubscriptionRepository uS;


    @Override
    public void create(Subscription subscription) {
        uS.save(subscription);
    }

    @Override
    public void  delete(int idSubscription) {
        uS.deleteById(idSubscription);
    }

    @Override
    public List<Subscription> list() {
        return uS.findAll();
    }

    @Override
    public List<String[]> querieSubscription() {
        return uS.quantitySubscriptionByUsers();
    }

}
