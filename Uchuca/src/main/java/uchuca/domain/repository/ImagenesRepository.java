package uchuca.domain.repository;

import uchuca.domain.Imagenes;

import java.util.List;
import java.util.Optional;

public interface ImagenesRepository {
    Optional<Imagenes> getId(Integer idImagen);
    List<Imagenes> getAll();

    Imagenes save(Imagenes imagenes);
}
