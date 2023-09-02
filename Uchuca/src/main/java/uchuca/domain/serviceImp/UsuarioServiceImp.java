package uchuca.domain.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uchuca.domain.dto.Usuario;
import uchuca.domain.service.UserService;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioServiceImp  {
    @Autowired
    private UserService repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public Optional<Usuario> getId(Long id){
        return repository.getId(id);

    }



    public Usuario save(Usuario usuario){

        Usuario user = usuario;
        if(!(usuario.getConstrasena().length() >=60)){
            user.setConstrasena(bCryptPasswordEncoder.encode(usuario.getConstrasena()));
        }
        return repository.save(user);
    }

    public  Usuario getUserByEmail(String usuario){
        return repository.getUserByEmail(usuario);
    }
    public List<Usuario> getAll(){
        return repository.getAll();
    }




}
