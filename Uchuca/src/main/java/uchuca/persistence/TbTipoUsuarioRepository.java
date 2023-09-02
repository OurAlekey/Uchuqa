package uchuca.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uchuca.domain.TipoUsuario;
import uchuca.domain.repository.TipoUsuarioRepository;
import uchuca.persistence.crud.TbTipoUsuarioCrudRepository;
import uchuca.persistence.entity.TbTipoUsuario;
import uchuca.persistence.mapper.TipoUsuarioMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class TbTipoUsuarioRepository implements TipoUsuarioRepository {

    @Autowired
    private TbTipoUsuarioCrudRepository repository;

    @Autowired
    private TipoUsuarioMapper mapper;

    @Override
    public Optional<TipoUsuario> getId(Integer id) {
        return  repository.findById(id).map(tbTipoUsuario -> mapper.toTipoUsuario(tbTipoUsuario) );
    }

    @Override
    public List<TipoUsuario> getAll() {
        List<TbTipoUsuario> tbTipoUsuarios = (List<TbTipoUsuario>) repository.findAll();
        return mapper.toTipoUsuarios(tbTipoUsuarios);
    }

    @Override
    public TipoUsuario save(TipoUsuario tipoUsuario) {
        TbTipoUsuario tbTipoUsuario = mapper.toTbTipoUsuario(tipoUsuario);
        return mapper.toTipoUsuario(repository.save(tbTipoUsuario));
    }


}
