package uchuca.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uchuca.domain.AsignacionEtiquetas;


import uchuca.persistence.crud.TbAsignacionEtiquetasCrudRepository;
import uchuca.persistence.crud.TbChatCrudRepository;
import uchuca.persistence.entity.TbAsignacionEtiquetas;
import uchuca.domain.repository.AsignacionEtiquetasRepository;

import uchuca.persistence.mapper.AsignacionEtiquetasMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class TbAsignacionEtiquetaRepository implements AsignacionEtiquetasRepository{
    @Autowired
    private TbAsignacionEtiquetasCrudRepository repository;

    @Autowired
    private AsignacionEtiquetasMapper mapper;


    @Override
    public Optional<AsignacionEtiquetas> getId(Integer id){
        return repository.findById(id).map(tbAsignacionEtiquetas -> mapper.toAsignacion(tbAsignacionEtiquetas));

    }
    @Override
    public List<AsignacionEtiquetas> getAll(){
        List<TbAsignacionEtiquetas> tbAsignacionEtiquetas = (List<TbAsignacionEtiquetas>) repository.findAll();
        return mapper.toAsignaciones(tbAsignacionEtiquetas);
    }

    @Override
    public AsignacionEtiquetas save (AsignacionEtiquetas asignacionEtiquetas){
        TbAsignacionEtiquetas tbAsignacionEtiquetas = mapper.toTbAsignacioneEtiquetas(asignacionEtiquetas);
        return mapper.toAsignacion(repository.save(tbAsignacionEtiquetas));
    }


}


