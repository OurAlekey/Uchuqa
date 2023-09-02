package uchuca.domain.repository;


import uchuca.domain.Usuario;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    public Usuario getUserByEmail (String email);
    public Optional<Usuario> getId(long id);
    public List<Usuario> getAll();
    public Usuario save(Usuario usuario);
}
