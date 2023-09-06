package uchuca.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uchuca.domain.Departamento;
import uchuca.domain.repository.DepartamentoRepository;
import uchuca.persistence.crud.TbDepartamentoCrudRepository;
import uchuca.persistence.entity.TbDepartamento;
import uchuca.persistence.mapper.DepartamentoMapper;

import java.util.List;
import java.util.Optional;
@Repository
public class TbDepartamentoRepository implements DepartamentoRepository {

    @Autowired
    private TbDepartamentoCrudRepository repository;

    @Autowired
    private DepartamentoMapper mapper;
    @Override
    public Optional<Departamento> getId(Integer id) {
        return repository.findById(id).map(tbDepartamento -> mapper.toDepartamento(tbDepartamento));
    }

    @Override
    public List<Departamento> getAll() {
        List<TbDepartamento> tbTipoContactos = (List<TbDepartamento>) repository.findAll();
        return mapper.toDepartamentos(tbTipoContactos);
    }

    @Override
    public Departamento save(Departamento departamento) {
        TbDepartamento tbDepartamento = mapper.toTbDepartamento(departamento);
        return mapper.toDepartamento(repository.save(tbDepartamento));
    }
}
