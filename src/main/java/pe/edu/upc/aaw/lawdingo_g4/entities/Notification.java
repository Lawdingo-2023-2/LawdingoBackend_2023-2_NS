package pe.edu.upc.aaw.lawdingo_g4.entities;

import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@Table(name = "Notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotification;
    @ManyToOne
    @JoinColumn(name = "idSender", referencedColumnName = "idUser")
    private Users sender;
    @ManyToOne
    @JoinColumn(name = "idReceiver", referencedColumnName = "idUser")
    private Users receiver;
    @Column(name = "message", length = 50, nullable = false)
    private String message;

    public Notification() {
    }

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public Users getSender() {
        return sender;
    }

    public void setSender(Users sender) {
        this.sender = sender;
    }

    public Users getReceiver() {
        return receiver;
    }

    public void setReceiver(Users receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
