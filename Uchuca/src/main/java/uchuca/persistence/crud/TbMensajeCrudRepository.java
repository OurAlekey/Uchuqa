package uchuca.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import uchuca.persistence.entity.TbMensaje;

public interface TbMensajeCrudRepository extends CrudRepository<TbMensaje, Integer> {
}
