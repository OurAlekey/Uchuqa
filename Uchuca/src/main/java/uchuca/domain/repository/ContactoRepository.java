package uchuca.domain.repository;

import uchuca.domain.Contacto;
import java.util.List;
import java.util.Optional;

public interface ContactoRepository {
    Optional<Contacto> getId(Integer id);
    List<Contacto> getAll();
    Contacto save(Contacto contacto);
}
