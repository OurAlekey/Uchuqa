package uchuca.domain.repository;

import uchuca.domain.Etiqueta;

import java.util.List;
import java.util.Optional;

public interface EtiquetaRepository {
    Optional<Etiqueta> getId(Integer idEtiqueta);
    List<Etiqueta> getAll();
    Etiqueta save(Etiqueta etiqueta);
}
