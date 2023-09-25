package pe.edu.upc.aaw.lawdingo_g4.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComment;

    @ManyToOne
    @JoinColumn(name = "idClient", referencedColumnName = "idUser")
    private Users client;

    @ManyToOne
    @JoinColumn(name = "idLawyer", referencedColumnName = "idUser")
    private Users lawyer;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Min(0)
    @Max(10)
    @Column(name = "score", nullable = false)
    private int score;

    public Comment() {
    }

    public Comment(int idComment, Users client, Users lawyer, String description, int score) {
        this.idComment = idComment;
        this.client = client;
        this.lawyer = lawyer;
        this.description = description;
        this.score = score;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
