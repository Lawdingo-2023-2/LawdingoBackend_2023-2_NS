package pe.edu.upc.aaw.lawdingo_g4.dtos;

import pe.edu.upc.aaw.lawdingo_g4.entities.Proceeding;

public class DocumentationDTO {
    private int idDocumentation;
    private String name;
    private Proceeding proceeding;

    public int getIdDocumentation() {
        return idDocumentation;
    }

    public void setIdDocumentation(int idDocumentation) {
        this.idDocumentation = idDocumentation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Proceeding getProceeding() {
        return proceeding;
    }

    public void setProceeding(Proceeding proceeding) {
        this.proceeding = proceeding;
    }
}
