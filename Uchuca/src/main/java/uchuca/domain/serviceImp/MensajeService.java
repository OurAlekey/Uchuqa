package uchuca.domain.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import uchuca.domain.Mensaje;
import uchuca.domain.repository.MensajeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository repository;


    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public Optional<Mensaje> getId(Integer id){
        return repository.getId(id);
    }

    public List<Mensaje> getAll(){
        return repository.getAll();
    }

    public Mensaje save(Mensaje mensaje){
        return repository.save(mensaje);
    }

    public  void sendMessage(String to,Mensaje mensaje){
        repository.save(mensaje);;

        simpMessagingTemplate.convertAndSend("/topic/messages/" + to, mensaje);
    }

    public List<Mensaje> getListMessage(Integer idChat){
     return repository.getByIdChat(idChat);
    }


}
