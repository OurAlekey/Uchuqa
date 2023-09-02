package uchuca.domain.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uchuca.domain.TipoUsuario;
import uchuca.domain.repository.TipoUsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioService {
    @Autowired
    private TipoUsuarioRepository repository;

    public Optional<TipoUsuario> getId(Integer id){
        return repository.getId(id);
    }

    public List<TipoUsuario> getAll(){
        return  repository.getAll();
    }

    public TipoUsuario save(TipoUsuario tipoUsuario){
        return  repository.save(tipoUsuario);
    }
}
