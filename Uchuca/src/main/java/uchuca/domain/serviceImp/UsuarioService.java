package uchuca.domain.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uchuca.domain.Usuario;
import uchuca.domain.repository.UserRepository;
import uchuca.exeptions.EmailExistsException;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public Optional<Usuario> getId(Long id){


            return repository.getId(id);



    }


    public Usuario save(Usuario usuario){

        if(repository.getUserByEmail(usuario.getCorreo()) != null){
            throw new EmailExistsException("El correo electronico ya existe");
        }else{
            Usuario user = usuario;
            if(!(usuario.getConstrasena().length() >=60)){
                user.setConstrasena(bCryptPasswordEncoder.encode(usuario.getConstrasena()));
            }
            return repository.save(user);
        }

    }

    public  Usuario getUserByEmail(String usuario){
        return repository.getUserByEmail(usuario);
    }
    public List<Usuario> getAll(){
        return repository.getAll();
    }




}
