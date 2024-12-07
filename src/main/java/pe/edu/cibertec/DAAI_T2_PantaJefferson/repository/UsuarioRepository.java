package pe.edu.cibertec.DAAI_T2_PantaJefferson.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.model.bd.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNomusuario(String nomusuario);

    @Transactional
    @Modifying
    @Query(value = "Update Usuario Set password=:password Where nomusuario=:nomusuario", nativeQuery = true)
    void actualizarPassword(@Param("password") String password, @Param("nomusuario") String nomusuario);
}
