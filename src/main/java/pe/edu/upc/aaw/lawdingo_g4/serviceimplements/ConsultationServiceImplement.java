package pe.edu.upc.aaw.lawdingo_g4.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.lawdingo_g4.entities.Consultation;
import pe.edu.upc.aaw.lawdingo_g4.repositories.IConsultationRepository;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.IConsultationService;

import java.time.LocalDate;
import java.util.List;
@Service
public class ConsultationServiceImplement implements IConsultationService {
    @Autowired
    private IConsultationRepository cR;

    @Override
    public void insert(Consultation consultation) {
        cR.save(consultation);
    }
    @Override
    public void delete(int idConsultation) {
        cR.deleteById(idConsultation);
    }

    @Override
    public List<Consultation> list() {
        return cR.findAll();
    }

    @Override
    public List<Consultation> buscarFecha(LocalDate fecha) {
        return cR.findBypublicationDateConsultation(fecha);    }

    @Override
    public Long contarConsultas() {
        return cR.cantidad();
    }
}
