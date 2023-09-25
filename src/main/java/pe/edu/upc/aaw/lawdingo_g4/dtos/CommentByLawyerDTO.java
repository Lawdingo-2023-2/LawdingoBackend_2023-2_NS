package pe.edu.upc.aaw.lawdingo_g4.dtos;

public class CommentByLawyerDTO {
    private String name_of_client;

    private String description;
    private int score;

    public String getName_of_client() {
        return name_of_client;
    }

    public void setName_of_client(String name_of_client) {
        this.name_of_client = name_of_client;
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
