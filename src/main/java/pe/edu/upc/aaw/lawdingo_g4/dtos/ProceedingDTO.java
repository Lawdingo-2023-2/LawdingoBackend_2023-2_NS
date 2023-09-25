package pe.edu.upc.aaw.lawdingo_g4.dtos;

import pe.edu.upc.aaw.lawdingo_g4.entities.Court;
import pe.edu.upc.aaw.lawdingo_g4.entities.Users;

public class ProceedingDTO {
    private int idProceeding;
    private String name;

    private char state;

    private Court court;

    private Users client;

    private Users lawyer;

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
