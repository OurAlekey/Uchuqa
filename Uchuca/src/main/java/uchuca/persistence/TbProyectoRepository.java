package uchuca.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uchuca.domain.Proyecto;
import uchuca.domain.repository.ProyectoRepository;
import uchuca.persistence.crud.TbProyectoCrudRepository;
import uchuca.persistence.entity.TbProyecto;
import uchuca.persistence.mapper.ProyectoMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class TbProyectoRepository implements ProyectoRepository {

    @Autowired
    private TbProyectoCrudRepository repository;

    @Autowired
    private ProyectoMapper mapper;

    @Override
    public Optional<Proyecto> getId(Integer id){
        return repository.findById(id).map(tbProyecto -> mapper.toProyecto(tbProyecto));
    }

    @Override
    public List<Proyecto> getAll(){
        List<TbProyecto> tbProyectos = (List<TbProyecto>) repository.findAll();
        return mapper.toProyectos(tbProyectos);
    }

    @Override
    public Proyecto save (Proyecto proyecto){
        TbProyecto tbProyecto = mapper.toTbProyecto(proyecto);
        return mapper.toProyecto(repository.save(tbProyecto));
    }



}
