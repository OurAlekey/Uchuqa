package uchuca.domain.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uchuca.domain.Usuario;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    public Usuario getUserByEmail (String email);
    public Optional<Usuario> getId(long id);
    public List<Usuario> getAll();
    public Usuario save(Usuario usuario);

    Page<Usuario> getByNombrePageable(String nombre , Pageable pageable);
}
