package uchuca.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uchuca.domain.Chat;
import uchuca.domain.Mensaje;
import uchuca.domain.repository.ChatRepository;
import uchuca.domain.repository.MensajeRepository;
import uchuca.persistence.crud.TbChatCrudRepository;
import uchuca.persistence.crud.TbMensajeCrudRepository;
import uchuca.persistence.entity.TbChat;
import uchuca.persistence.entity.TbMensaje;
import uchuca.persistence.mapper.ChatMapper;
import uchuca.persistence.mapper.MensajeMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class TbMensajeRepository implements MensajeRepository {

    @Autowired
    private TbMensajeCrudRepository repository;

    @Autowired
    private MensajeMapper mapper;

    @Override
    public Optional<Mensaje> getId(Integer id){
        return repository.findById(id).map(tbChat -> mapper.toMensaje(tbChat));
    }

    @Override
    public List<Mensaje> getAll(){
        List<TbMensaje> toMensajes = (List<TbMensaje>) repository.findAll();
        return mapper.toMensajes(toMensajes);
    }
    @Override
    public Mensaje save(Mensaje mensaje){
        TbMensaje tbChat = mapper.toTbMensaje(mensaje);
        return mapper.toMensaje(repository.save(tbChat));
    }

    @Override
    public List<Mensaje> getByIdChat(Integer idChat) {
        List<TbMensaje> toMensajes = (List<TbMensaje>) repository.findByIdChat(idChat);
        return mapper.toMensajes(toMensajes);
    }
}