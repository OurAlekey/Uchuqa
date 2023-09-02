package uchuca.domain.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uchuca.domain.Usuario;

import java.util.ArrayList;

@Service
public class Uchuqa implements UserDetailsService {
    @Autowired
    UsuarioService usuarioServiceImp;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario =  usuarioServiceImp.getUserByEmail(username);
        return new User(usuario.getCorreo(), usuario.getConstrasena(),new ArrayList<>());
    }
}
