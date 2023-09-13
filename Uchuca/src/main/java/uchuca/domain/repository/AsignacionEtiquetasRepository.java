package uchuca.domain.repository;

import uchuca.domain.AsignacionEtiquetas;
import java.util.List;
import java.util.Optional;
public interface AsignacionEtiquetasRepository {

    Optional<AsignacionEtiquetas> getId(Integer idAsignacion);

    List<AsignacionEtiquetas> getAll();

    AsignacionEtiquetas save (AsignacionEtiquetas asignacionEtiquetas);
}
