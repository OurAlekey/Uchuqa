package uchuca.persistence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import uchuca.domain.Usuario;
import uchuca.domain.repository.UserRepository;
import uchuca.persistence.crud.TbUserCrudRepository;
import uchuca.persistence.entity.TbUser;
import uchuca.persistence.mapper.UserMapper;

import java.util.List;
import java.util.Optional;


@Repository
public class TbUserRepository implements UserRepository {

    @Autowired
    private TbUserCrudRepository repository;

    @Autowired
    private UserMapper mapper;

    @Override
    public Usuario getUserByEmail(String email) {
        TbUser tbUser = repository.findByUsuEmail(email);
        return mapper.toUsuario(tbUser);
    }

    @Override
    public Optional<Usuario> getId(long id) {
        return repository.findById(id).map(tbUser -> mapper.toUsuario(tbUser));
    }

    @Override
    public List<Usuario> getAll() {
        List<TbUser> tbUsers = (List<TbUser>) repository.findAll();
        return mapper.toUsuarios(tbUsers);
    }

    @Override
    public Usuario save(Usuario usuario) {
        TbUser tbUser = mapper.toTbUser(usuario);
        return mapper.toUsuario(repository.save(tbUser));
    }

    @Override
    public Page<Usuario> getByNombrePageable(String nombre, Pageable pageable) {
        Page<TbUser> tbUserPage = repository.findByNamePageable(nombre,pageable);
        List<Usuario> usuarios = mapper.toUsuarios(tbUserPage.getContent());
        Page<Usuario> usuarioPage = new PageImpl<>(usuarios,pageable,tbUserPage.getTotalPages());

        System.out.println(nombre);
        return usuarioPage;
    }
}
