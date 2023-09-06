package uchuca.domain.repository;
import uchuca.domain.TipoContacto;

import java.util.List;
import java.util.Optional;

public interface TipoContactoRepository {
    Optional<TipoContacto> getId(Integer id);
    List<TipoContacto> getAll();
    TipoContacto save(TipoContacto tipoContacto);
}
