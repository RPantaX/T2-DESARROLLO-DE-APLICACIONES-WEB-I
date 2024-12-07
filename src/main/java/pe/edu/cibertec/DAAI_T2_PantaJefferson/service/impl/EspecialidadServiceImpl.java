package pe.edu.cibertec.DAAI_T2_PantaJefferson.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.model.bd.Especialidad;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.repository.EspecialidadRepository;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.service.EspecialidadService;

import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public List<Especialidad> getAllEspecialidades() {
        return especialidadRepository.findAll();
    }

    @Override
    public Especialidad getEspecialidadById(Integer id) {
        return especialidadRepository.findById(id).orElse(null);
    }

    @Override
    public void saveEspecialidad(Especialidad especialidad) {
        especialidadRepository.save(especialidad);
    }

    @Override
    public void deleteEspecialidad(Integer id) {
        especialidadRepository.deleteById(id);
    }
}
