package pe.edu.upc.aaw.lawdingo_g4.dtos;

public class ProceedingSummaryDTO {
    private int id_proceeding;
    private String name;
    private String name_client;
    private String name_lawyer;
    private String name_court;
    private int num_doc;

    public int getId_proceeding() {
        return id_proceeding;
    }

    public void setId_proceeding(int id_proceeding) {
        this.id_proceeding = id_proceeding;
    }

    public String getName_client() {
        return name_client;
    }

    public void setName_client(String name_client) {
        this.name_client = name_client;
    }

    public String getName_lawyer() {
        return name_lawyer;
    }

    public void setName_lawyer(String name_lawyer) {
        this.name_lawyer = name_lawyer;
    }

    public String getName_court() {
        return name_court;
    }

    public void setName_court(String name_court) {
        this.name_court = name_court;
    }

    public int getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(int num_doc) {
        this.num_doc = num_doc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
