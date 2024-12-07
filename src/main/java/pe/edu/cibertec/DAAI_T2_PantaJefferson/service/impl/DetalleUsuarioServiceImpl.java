package pe.edu.cibertec.DAAI_T2_PantaJefferson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.model.bd.Rol;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.model.bd.Usuario;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.model.security.UsuarioSecurity;
import pe.edu.cibertec.DAAI_T2_PantaJefferson.service.UsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class DetalleUsuarioServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findByNomusuario(username);
        return authenticationUser(usuario, obtenerListaRolesUsuario(usuario.getRoles()));
    }

    private List<GrantedAuthority> obtenerListaRolesUsuario(Set<Rol> listRoles) {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        for(Rol rol: listRoles) {
            grantedAuthorityList.add(new SimpleGrantedAuthority(rol.getNomrol()));
        }
        return grantedAuthorityList;
    }

    private UserDetails authenticationUser(Usuario usuario, List<GrantedAuthority> authorityList) {
        UsuarioSecurity usuarioSecurity = new UsuarioSecurity(
                usuario.getEmail(), usuario.getPassword(),
                usuario.getActivo(), true,
                true, true, authorityList
        );
        usuarioSecurity.setUsername(usuario.getNomusuario());
        return usuarioSecurity;
    }
}
