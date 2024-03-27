package uchuca.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uchuca.domain.Reaccion;
import uchuca.domain.TipoReaccion;
import uchuca.domain.repository.ReaccionRepository;
import uchuca.domain.repository.TipoContactoRepository;
import uchuca.domain.repository.TipoReaccionRepository;
import uchuca.persistence.crud.TbReaccionCrudRepository;
import uchuca.persistence.crud.TbTipoReaccionCrudRepository;
import uchuca.persistence.entity.TbReaccion;
import uchuca.persistence.entity.TbTipoReaccion;
import uchuca.persistence.mapper.ReaccionMapper;
import uchuca.persistence.mapper.TipoReaccionMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class TbTipoReaccionRepository implements TipoReaccionRepository {

    @Autowired
    private TipoReaccionMapper mapper;

    @Autowired
    private TbTipoReaccionCrudRepository repository;

    @Override
    public Optional<TipoReaccion> getId(Integer id) {

        return repository.findById(id).map(tbReaccion -> mapper.toTipoReaccion(tbReaccion));
    }

    @Override
    public List<TipoReaccion> getAll() {
        List<TbTipoReaccion> tbReaccionses = (List<TbTipoReaccion>) repository.findAll();
        return  mapper.toTipoReacciones(tbReaccionses);
    }

    @Override
    public TipoReaccion save(TipoReaccion tipoReaccion) {
        TbTipoReaccion tbReaccion = mapper.toTbTipoReaccion(tipoReaccion);
        return mapper.toTipoReaccion(repository.save(tbReaccion));
    }
}
