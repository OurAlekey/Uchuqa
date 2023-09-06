package uchuca.domain.repository;

import uchuca.domain.Departamento;

import java.util.List;
import java.util.Optional;

public interface DepartamentoRepository {
    Optional<Departamento> getId(Integer id);
    List<Departamento> getAll();

    Departamento save(Departamento departamento);
}
