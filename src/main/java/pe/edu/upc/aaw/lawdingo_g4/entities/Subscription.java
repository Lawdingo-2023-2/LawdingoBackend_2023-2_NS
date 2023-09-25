package pe.edu.upc.aaw.lawdingo_g4.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubscription;

    @Column(name = "name",nullable = false , length = 20)
    private  String name;

    @Column(name= "amount",nullable = false)
    private Double amount;
    @Column(name="sub_start_date",nullable = true)
    private LocalDate sub_start_date;

    @ManyToOne
    @JoinColumn(name ="id_user")
    private Users users;








    public Subscription() {}

    public Subscription(int idSubscription, String name, Double amount, LocalDate sub_start_date, Users users) {
        this.idSubscription = idSubscription;
        this.name = name;
        this.amount = amount;
        this.sub_start_date = sub_start_date;
        this.users = users;
    }




    public int getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(int idSubscription) {
        this.idSubscription = idSubscription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public LocalDate getSub_start_date() {
        return sub_start_date;
    }

    public void setSub_start_date(LocalDate sub_start_date) {
        this.sub_start_date = sub_start_date;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
