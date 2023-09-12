package uchuca.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import uchuca.persistence.entity.TbChat;

public interface TbChatCrudRepository extends CrudRepository<TbChat, Integer>{

}
