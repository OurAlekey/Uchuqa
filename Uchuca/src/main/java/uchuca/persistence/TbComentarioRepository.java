package uchuca.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uchuca.domain.Comentario;
import uchuca.domain.repository.ComentarioRepository;
import uchuca.persistence.crud.TbComentarioCrudRepository;
import uchuca.persistence.entity.TbComentario;
import uchuca.persistence.mapper.ComentarioMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class TbComentarioRepository implements ComentarioRepository {

    @Autowired
    private TbComentarioCrudRepository repository;

    @Autowired
    private ComentarioMapper mapper;

    @Override
    public Optional<Comentario> getId(Integer id){
        return repository.findById(id).map(tbComentario -> mapper.toComentario(tbComentario));
    }

    @Override
    public List<Comentario> getAll(){
        List<TbComentario> tbComentario = (List<TbComentario>) repository.findAll();
        return mapper.toComentarios(tbComentario);
    }
    @Override
    public Comentario save(Comentario comentario){
        TbComentario tbComentario = mapper.toTbComentario(comentario);
        return mapper.toComentario(repository.save(tbComentario));
    }
}