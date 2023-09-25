package pe.edu.upc.aaw.lawdingo_g4.dtos;


import pe.edu.upc.aaw.lawdingo_g4.entities.Users;

import java.time.LocalDate;

public class SubscriptionDTO {

    private int idSubscription;
    private  String name;
    private Double amount;

    //AGREGADO
    private LocalDate sub_start_date;
    private Users users;

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
