package pe.edu.cibertec.DAAI_T2_PantaJefferson.service;

import pe.edu.cibertec.DAAI_T2_PantaJefferson.model.bd.Usuario;

public interface UsuarioService {
    Usuario findByNomusuario(String nomusuario);
    Usuario create(Usuario usuario);
    void actualizarPassword(String password, String username);
}
