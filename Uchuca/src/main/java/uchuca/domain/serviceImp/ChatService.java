package uchuca.domain.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import uchuca.domain.Chat;
import uchuca.domain.repository.ChatRepository;


import java.util.List;
import java.util.Optional;

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
        return repository.save(chat);
    }
}
