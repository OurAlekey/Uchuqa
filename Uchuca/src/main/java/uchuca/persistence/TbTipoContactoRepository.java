package uchuca.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uchuca.domain.TipoContacto;
import uchuca.domain.repository.TipoContactoRepository;
import uchuca.persistence.crud.TbTipoContactoCrudRepository;
import uchuca.persistence.entity.TbTipoContacto;
import uchuca.persistence.mapper.TipoContactoMapper;

import java.util.List;
import java.util.Optional;
@Repository
public class TbTipoContactoRepository implements TipoContactoRepository {

    @Autowired
    private TbTipoContactoCrudRepository repository;

    @Autowired
    private TipoContactoMapper mapper;


    @Override
    public Optional<TipoContacto> getId(Integer id) {
        return repository.findById(id).map(tbTipoContacto -> mapper.toTipoContacto(tbTipoContacto));
    }

    @Override
    public List<TipoContacto> getAll() {
        List<TbTipoContacto> tbTipoContactos = (List<TbTipoContacto>) repository.findAll();
        return mapper.toTipoContactos(tbTipoContactos);
    }

    @Override
    public TipoContacto save(TipoContacto tipoContacto) {
        TbTipoContacto tbTipoContacto = mapper.toTbTipoContacto(tipoContacto);
        return mapper.toTipoContacto(repository.save(tbTipoContacto));
    }
}
