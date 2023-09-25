package pe.edu.upc.aaw.lawdingo_g4.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.lawdingo_g4.entities.Notification;
import pe.edu.upc.aaw.lawdingo_g4.repositories.INotificationRepository;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.INotificationService;

import java.util.List;

@Service
public class NotificationServiceImplement implements INotificationService {

    @Autowired
    private INotificationRepository jR;

    @Override
    public void insert(Notification notification) {
        jR.save(notification);
    }

    @Override
    public List<Notification> list() {
        return jR.findAll();
    }

    @Override
    public void delete(int idNotification) {
        jR.deleteById(idNotification);
    }

    @Override
    public Notification listId(int idNotification) {
        return jR.findById(idNotification).orElse(new Notification());
    }


}
