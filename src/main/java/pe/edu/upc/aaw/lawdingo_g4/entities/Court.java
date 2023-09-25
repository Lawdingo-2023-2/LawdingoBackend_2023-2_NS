package pe.edu.upc.aaw.lawdingo_g4.entities;

import javax.persistence.*;

@Entity
@Table(name = "Court")
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCourt;
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name="idDistrict")
    private District district;

    public Court(){

    }

    public Court(int idCourt, String name, District district) {
        this.idCourt = idCourt;
        this.name = name;
        this.district = district;
    }

    public int getIdCourt() {
        return idCourt;
    }

    public void setIdCourt(int idCourt) {
        this.idCourt = idCourt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
