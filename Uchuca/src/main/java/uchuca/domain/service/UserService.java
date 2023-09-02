package uchuca.domain.service;


import uchuca.domain.dto.Usuario;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public Usuario getUserByEmail (String email);
    public Optional<Usuario> getId(long id);
    public List<Usuario> getAll();
    public Usuario save(Usuario usuario);
}
