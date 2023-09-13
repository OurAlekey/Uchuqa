package uchuca.domain.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uchuca.domain.Chat;
import uchuca.domain.Comentario;
import uchuca.domain.repository.ChatRepository;
import uchuca.domain.repository.ComentarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository repository;

    public Optional<Comentario> getId(Integer id){
        return repository.getId(id);
    }

    public List<Comentario> getAll(){
        return repository.getAll();
    }

    public Comentario save(Comentario comentario){
        return repository.save(comentario);
    }
}
