package uchuca.domain.repository;

import uchuca.domain.Proyecto;

import java.util.List;
import java.util.Optional;

public interface ProyectoRepository {

    Optional<Proyecto> getId(Integer idProyecto);
    List<Proyecto> getAll();

    Proyecto save(Proyecto proyecto);

    List<Proyecto> getAllByTitle(String title);

    List<Proyecto> getByIdUsuario(Integer id);


}