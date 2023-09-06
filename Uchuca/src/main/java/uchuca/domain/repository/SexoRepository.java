package uchuca.domain.repository;

import uchuca.domain.Sexo;
import java.util.List;
import java.util.Optional;

public interface SexoRepository {

    Optional<Sexo> getId(Integer id);
    List<Sexo> getAll();
    Sexo save(Sexo sexo);
}
