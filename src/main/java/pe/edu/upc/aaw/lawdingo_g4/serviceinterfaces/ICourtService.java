package pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces;

import pe.edu.upc.aaw.lawdingo_g4.entities.Court;

import java.util.List;

public interface ICourtService {
    public void insert(Court court);
    public List<Court> list();
    public void delete(int idCourt);
    public Court listId(int idCourt);
    List<Court> findByName(String name);
}
