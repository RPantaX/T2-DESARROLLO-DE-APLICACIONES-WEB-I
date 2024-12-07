package pe.edu.cibertec.DAAI_T2_PantaJefferson.service;

import pe.edu.cibertec.DAAI_T2_PantaJefferson.model.bd.Especialidad;

import java.util.List;

public interface EspecialidadService {
    List<Especialidad> getAllEspecialidades();
    Especialidad getEspecialidadById(Integer id);
    void saveEspecialidad(Especialidad especialidad);
    void deleteEspecialidad(Integer id);
}
