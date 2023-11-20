package uchuca.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import uchuca.persistence.entity.TbMensaje;

import java.util.List;

public interface TbMensajeCrudRepository extends CrudRepository<TbMensaje, Integer> {

    List<TbMensaje> findByIdChat(Integer idChat);
}

