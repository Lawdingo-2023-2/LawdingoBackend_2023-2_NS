package pe.edu.upc.aaw.lawdingo_g4.dtos;

public class ConsultationByCategoryDTO {
    private String nameCategory;
    private int countConsultation;

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getCountConsultation() {
        return countConsultation;
    }

    public void setCountConsultation(int countConsultation) {
        this.countConsultation = countConsultation;
    }
}
