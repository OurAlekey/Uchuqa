package uchuca.domain.repository;

import uchuca.domain.Mensaje;

import java.util.List;
import java.util.Optional;

public interface MensajeRepository {
    Optional<Mensaje> getId(Integer idMensaje);
    List<Mensaje> getAll();

    Mensaje save(Mensaje mensaje);

    List<Mensaje> getByIdChat(Integer idChat);
}
