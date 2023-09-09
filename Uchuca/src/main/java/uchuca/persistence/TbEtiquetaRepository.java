package uchuca.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uchuca.domain.Etiqueta;
import uchuca.domain.repository.EtiquetaRepository;
import uchuca.persistence.crud.TbEtiquetaCrudRepository;
import uchuca.persistence.entity.TbEtiqueta;
import uchuca.persistence.mapper.EtiquetaMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class TbEtiquetaRepository implements EtiquetaRepository {
    @Autowired
    private TbEtiquetaCrudRepository repository;

    @Autowired
    private EtiquetaMapper mapper;

    @Override
    public Optional<Etiqueta> getId(Integer id){
        return repository.findById(id).map(tbEtiqueta -> mapper.toEtiqueta(tbEtiqueta));
    }

    @Override
    public List<Etiqueta> getAll(){
        List<TbEtiqueta> tbEtiquetas = (List<TbEtiqueta>) repository.findAll();
        return mapper.toEtiqueta(tbEtiquetas);
    }

    @Override
    public Etiqueta save(Etiqueta etiqueta){
        TbEtiqueta tbEtiqueta = mapper.toTbEtiqueta(etiqueta);
        return mapper.toEtiqueta(repository.save(tbEtiqueta));
    }
}
