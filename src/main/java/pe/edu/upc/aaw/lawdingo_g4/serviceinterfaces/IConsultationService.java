package pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces;

import net.bytebuddy.asm.Advice;
import pe.edu.upc.aaw.lawdingo_g4.entities.Consultation;

import java.time.LocalDate;
import java.util.List;

public interface IConsultationService {
    public void insert(Consultation consultation);
    List<Consultation> list();
    public void delete(int idConsultation);
    List<Consultation>buscarFecha(LocalDate fecha);
    Long contarConsultas();
}
