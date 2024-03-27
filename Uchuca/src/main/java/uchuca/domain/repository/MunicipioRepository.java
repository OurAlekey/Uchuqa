package uchuca.domain.repository;

import uchuca.domain.Municipio;

import java.util.List;
import java.util.Optional;

public interface MunicipioRepository {

    Optional<Municipio> getId(Integer id);
    List<Municipio> getAll();
    Municipio save(Municipio municipio);
}
