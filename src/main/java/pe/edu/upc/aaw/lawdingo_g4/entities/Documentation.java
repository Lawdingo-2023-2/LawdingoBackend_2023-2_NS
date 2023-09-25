package pe.edu.upc.aaw.lawdingo_g4.entities;

import javax.persistence.*;

@Entity
@Table(name = "Documentation")
public class Documentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocumentation;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name="idProceeding")
    private Proceeding proceeding;

    public Documentation(){}
    public Documentation(int idDocumentation, String name, Proceeding proceeding) {
        this.idDocumentation = idDocumentation;
        this.name = name;
        this.proceeding = proceeding;
    }

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
