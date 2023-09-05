package uchuca.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import uchuca.persistence.entity.TbContacto;

public interface TbContactoCrudRepository extends CrudRepository<TbContacto,Integer> {
}
