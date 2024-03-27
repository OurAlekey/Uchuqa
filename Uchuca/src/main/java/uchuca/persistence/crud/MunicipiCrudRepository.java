package uchuca.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import uchuca.persistence.entity.TbMunicipio;

public interface MunicipiCrudRepository extends CrudRepository<TbMunicipio, Integer> {
}
