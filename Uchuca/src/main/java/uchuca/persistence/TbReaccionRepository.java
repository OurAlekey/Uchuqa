package uchuca.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uchuca.domain.Reaccion;
import uchuca.domain.repository.ReaccionRepository;
import uchuca.persistence.crud.TbReaccionCrudRepository;
import uchuca.persistence.entity.TbReaccion;
import uchuca.persistence.mapper.ReaccionMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class TbReaccionRepository implements ReaccionRepository {

    @Autowired
    private ReaccionMapper mapper;

    @Autowired
    private TbReaccionCrudRepository repository;

    @Override
    public Optional<Reaccion> getById(Integer id) {

        return repository.findById(id).map(tbReaccion -> mapper.toReaccion(tbReaccion));
    }

    @Override
    public List<Reaccion> getAll() {
        List<TbReaccion> tbReaccionses = (List<TbReaccion>) repository.findAll();
        return  mapper.toReacciones(tbReaccionses);
    }

    @Override
    public Reaccion save(Reaccion reaccion) {
        TbReaccion tbReaccion = mapper.toTbReaccion(reaccion);
        return mapper.toReaccion(repository.save(tbReaccion));
    }
}
