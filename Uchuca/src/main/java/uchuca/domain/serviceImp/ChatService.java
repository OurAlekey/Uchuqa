package uchuca.domain.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import uchuca.domain.Chat;
import uchuca.domain.repository.ChatRepository;


import java.util.List;
import java.util.Optional;
@Service
public class ChatService {

    @Autowired
    private ChatRepository repository;

    public Optional<Chat> getId(Integer id){
        return repository.getId(id);
    }

    public List<Chat> getAll(){
        return repository.getAll();
    }

    public Chat save(Chat chat){
        Optional<Chat> existingChat = repository.findByIdUsuers(chat.getIdUsuario(), chat.getIdUsuario2());

        if (existingChat.isPresent()) {
            // Si ya existe un registro con los mismos idUsuario e idUsuario2, retornar ese registro.
            return existingChat.get();
        } else {
            // Si no existe, guardar el nuevo registro.
            return repository.save(chat);
        }

    }
}
