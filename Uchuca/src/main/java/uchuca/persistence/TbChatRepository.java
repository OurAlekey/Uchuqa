package uchuca.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uchuca.domain.Chat;
import uchuca.persistence.entity.TbChat;
import uchuca.domain.repository.ChatRepository;
import uchuca.persistence.crud.TbChatCrudRepository;

import uchuca.persistence.mapper.ChatMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class TbChatRepository implements  ChatRepository{

    @Autowired
    private  TbChatCrudRepository repository;

    @Autowired
    private ChatMapper mapper;

    @Override
    public Optional<Chat> getId(Integer id){
        return repository.findById(id).map(tbChat -> mapper.toChat(tbChat));
    }

    @Override
    public List<Chat> getAll(){
        List<TbChat> tbChats = (List<TbChat>) repository.findAll();
        return mapper.toChats(tbChats);
    }
    @Override
    public Chat save(Chat chat){
        TbChat tbChat = mapper.toTbChat(chat);
        return mapper.toChat(repository.save(tbChat));
    }
}