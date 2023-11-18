package uchuca.persistence.crud;


import org.springframework.data.repository.CrudRepository;
import uchuca.persistence.entity.TbImagenes;

import java.util.List;

public interface TbImagenesCrudRepository extends CrudRepository<TbImagenes, Integer> {
 List<TbImagenes> findByIdProyecto(Integer idProyecto);
}
