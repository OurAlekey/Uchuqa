package uchuca.domain.repository;

import uchuca.domain.TipoUsuario;

import java.util.List;
import java.util.Optional;

public interface TipoUsuarioRepository {
    Optional<TipoUsuario> getId(Integer id);
    List<TipoUsuario> getAll();

    TipoUsuario save(TipoUsuario tipoUsuario);
}
