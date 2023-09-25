package pe.edu.upc.aaw.lawdingo_g4.dtos;


import pe.edu.upc.aaw.lawdingo_g4.entities.Consultation;

import java.time.LocalDate;

public class CategoryDTO {
    private int idCategory;
    private String name;

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
