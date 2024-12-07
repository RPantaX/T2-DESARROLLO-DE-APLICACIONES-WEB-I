package pe.edu.cibertec.DAAI_T2_PantaJefferson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.model.bd.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
}
