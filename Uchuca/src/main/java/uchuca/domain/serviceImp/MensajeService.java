package uchuca.domain.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uchuca.domain.Chat;
import uchuca.domain.Mensaje;
import uchuca.domain.repository.ChatRepository;
import uchuca.domain.repository.MensajeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository repository;

    public Optional<Mensaje> getId(Integer id){
        return repository.getId(id);
    }

    public List<Mensaje> getAll(){
        return repository.getAll();
    }

    public Mensaje save(Mensaje mensaje){
        return repository.save(mensaje);
    }
}
