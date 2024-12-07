package pe.edu.cibertec.DAAI_T2_PantaJefferson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.model.bd.Rol;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.model.bd.Usuario;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.repository.UsuarioRepository;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.service.UsuarioService;

import java.util.HashSet;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    @Lazy
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Usuario findByNomusuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }

    @Override
    public Usuario create(Usuario usuario) {
        usuario.setActivo(true);
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        Set<Rol> roles = new HashSet<>();
        Rol rol = new Rol();
        rol.setIdrol(1);
        roles.add(rol);
        usuario.setRoles(roles);
        return usuarioRepository.save(usuario);
    }

    @Override
    public void actualizarPassword(String password, String username) {
        usuarioRepository.actualizarPassword(bCryptPasswordEncoder.encode(password), username);
    }
}
