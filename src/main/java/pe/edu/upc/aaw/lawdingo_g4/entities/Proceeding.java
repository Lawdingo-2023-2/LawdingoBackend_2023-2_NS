package pe.edu.upc.aaw.lawdingo_g4.entities;

import javax.persistence.*;

@Entity
@Table(name = "Proceeding")
public class Proceeding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProceeding;

    @Column(name = "name",length = 20,nullable = false)
    private String name;

    @Column(name = "state", nullable = false)
    private char state;

    @ManyToOne
    @JoinColumn(name = "idCourt")
    private Court court;
    @ManyToOne
    @JoinColumn(name = "idClient", referencedColumnName = "idUser")
    private Users client;
    @ManyToOne
    @JoinColumn(name = "idLawyer", referencedColumnName = "idUser")
    private Users lawyer;

    public Proceeding() {
    }


    public Proceeding(int idProceeding, char state, Court court, Users client, Users lawyer) {
        this.idProceeding = idProceeding;
        this.name = name;
        this.state = state;
        this.court = court;
        this.client = client;
        this.lawyer = lawyer;
    }

    public int getIdProceeding() {
        return idProceeding;
    }

    public void setIdProceeding(int idProceeding) {
        this.idProceeding = idProceeding;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }

    public Users getClient() {
        return client;
    }

    public void setClient(Users client) {
        this.client = client;
    }

    public Users getLawyer() {
        return lawyer;
    }

    public void setLawyer(Users lawyer) {
        this.lawyer = lawyer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
