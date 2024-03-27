package uchuca.domain.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

        if(repository.getUserByEmail(usuario.getCorreo()) != null & usuario.getId() == 0){
            throw new EmailExistsException("El correo electronico ya existe");
        }else{
            Usuario user = usuario;
            if(!(usuario.getContrasena().length() >=60)){
                user.setContrasena(bCryptPasswordEncoder.encode(usuario.getContrasena()));
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

    public Page<Usuario> findByNombrePage(String nombre, Pageable pageable){
        return  repository.getByNombrePageable(nombre, pageable);
}


}
