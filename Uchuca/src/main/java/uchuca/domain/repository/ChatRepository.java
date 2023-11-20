package uchuca.domain.repository;

import uchuca.domain.Chat;

import java.util.List;
import java.util.Optional;

public interface ChatRepository {

Optional<Chat> getId(Integer idChat);

List<Chat> getAll();

Chat save(Chat chat);

    Optional<Chat> findByIdUsuers(Integer idUsuario, Integer idUsuario2);

}
