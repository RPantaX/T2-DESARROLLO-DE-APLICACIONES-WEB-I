package pe.edu.cibertec.DAAI_T2_PantaJefferson.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.model.bd.Medico;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.repository.MedicoRepository;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.service.MedicoService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository medicoRepository;

    @Override
    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico getMedicoById(Integer id) {
        return medicoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveMedico(Medico medico) {
        medicoRepository.save(medico);
    }

    @Override
    public void deleteMedico(Integer id) {
        medicoRepository.deleteById(id);
    }
}
