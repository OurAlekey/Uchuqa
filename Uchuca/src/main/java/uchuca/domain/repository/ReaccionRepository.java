package uchuca.domain.repository;

import uchuca.domain.Reaccion;

import java.util.List;
import java.util.Optional;

public interface ReaccionRepository {

    Optional<Reaccion> getById(Integer id);
    List<Reaccion> getAll();
    Reaccion save(Reaccion reaccion);
}
