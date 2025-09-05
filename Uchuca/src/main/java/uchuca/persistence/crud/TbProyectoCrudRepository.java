package uchuca.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import uchuca.persistence.entity.TbProyecto;

import java.util.List;

public interface TbProyectoCrudRepository extends CrudRepository<TbProyecto, Integer>{

List<TbProyecto> findByPrNombreContainingIgnoreCase(String nombre);
List<TbProyecto> findByIdUsuario(Integer id);

}
