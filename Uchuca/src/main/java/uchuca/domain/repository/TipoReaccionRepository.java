package uchuca.domain.repository;

import uchuca.domain.TipoReaccion;

import java.util.List;
import java.util.Optional;

public interface TipoReaccionRepository {
    Optional<TipoReaccion> getId(Integer id);
    List<TipoReaccion> getAll();
    TipoReaccion save(TipoReaccion tipoReaccion);
}
