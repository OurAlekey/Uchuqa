package uchuca.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uchuca.domain.Imagenes;
import uchuca.domain.repository.ImagenesRepository;
import uchuca.persistence.crud.TbImagenesCrudRepository;
import uchuca.persistence.entity.TbImagenes;
import uchuca.persistence.mapper.ImagenesMapper;

import java.util.List;
import java.util.Optional;


@Repository
public class TbImagenesRepository implements ImagenesRepository {
    @Autowired
    private TbImagenesCrudRepository repository;

    @Autowired
    private ImagenesMapper mapper;

    @Override
    public Optional<Imagenes> getId(Integer id){
        return repository.findById(id).map(tbImagenes -> mapper.toImagen(tbImagenes));
    }

    @Override
    public List<Imagenes> getAll(){
        List<TbImagenes> tbImagenes = (List<TbImagenes>) repository.findAll();
        return mapper.toImagenes(tbImagenes);
    }

    @Override
    public Imagenes save(Imagenes imagenes){
        TbImagenes tbImagenes = mapper.toTbImagenes(imagenes);
        return  mapper.toImagen(repository.save(tbImagenes));
    }


}
