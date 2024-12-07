package pe.edu.cibertec.DAAI_T2_PantaJefferson.service;

import pe.edu.cibertec.DAAI_T2_PantaJefferson.model.bd.Medico;

import java.util.List;

public interface MedicoService {
    List<Medico> getAllMedicos();
    Medico getMedicoById(Integer id);
    void saveMedico(Medico medico);
    void deleteMedico(Integer id);
}
