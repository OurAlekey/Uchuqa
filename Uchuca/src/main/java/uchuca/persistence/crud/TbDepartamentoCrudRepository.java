package uchuca.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import uchuca.persistence.entity.TbDepartamento;

public interface TbDepartamentoCrudRepository extends CrudRepository<TbDepartamento,Integer> {
}
