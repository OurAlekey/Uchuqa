package uchuca.persistence.crud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uchuca.persistence.entity.TbChat;

public interface TbChatCrudRepository extends CrudRepository<TbChat, Integer>{

    @Query(value = "SELECT  *  FROM bd_uchuqa.tb_chat  " +
            "WHERE " +
            "   (user_id = :idUsuario1 AND user_id2 = :idUsuario2 AND proyecto_id IS NULL) " +
            "OR " +
            "   (user_id = :idUsuario2 AND user_id2 = :idUsuario1 AND proyecto_id IS NULL)  LIMIT 1" ,
            countQuery  = "SELECT  *  FROM bd_uchuqa.tb_chat c " +
                    "WHERE " +
                    "   (user_id = :idUsuario1 AND user_id2 = :idUsuario2 AND proyecto_id IS NULL) " +
                    "OR " +
                    "   (user_id = :idUsuario2 AND user_id2 = :idUsuario1 AND proyecto_id IS NULL) LIMIT 1" ,
            nativeQuery = true)
    TbChat findByIdUsuers(@Param("idUsuario1") Integer idUsuario1, @Param("idUsuario2") Integer idUsuario2);

}
