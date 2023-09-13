package uchuca.domain.repository;

import uchuca.domain.Comentario;
import java.util.List;
import java.util.Optional;

public interface ComentarioRepository {

Optional<Comentario> getId(Integer idChat);

List<Comentario> getAll();

    Comentario save(Comentario comentario);


}
