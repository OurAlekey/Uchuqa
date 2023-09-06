package uchuca.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uchuca.domain.Sexo;
import uchuca.domain.repository.SexoRepository;
import uchuca.persistence.crud.TbSexoCrudRepository;
import uchuca.persistence.entity.TbSexo;
import uchuca.persistence.mapper.SexoMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class TbSexoRepository implements SexoRepository {
    @Autowired
    private TbSexoCrudRepository repository;
    @Autowired
    private SexoMapper mapper;

    @Override
    public Optional<Sexo> getId(Integer id) {
        return repository.findById(id).map(TbSexo -> mapper.toSexo(TbSexo));
    }

    @Override
    public List<Sexo> getAll() {
        List<TbSexo> tbSexos = (List<TbSexo>) repository.findAll();
        return mapper.toSexos(tbSexos);
    }

    @Override
    public Sexo save(Sexo sexo) {
        TbSexo tbSexo = mapper.toTbSexo(sexo);
        return mapper.toSexo(repository.save(tbSexo));
    }
}
