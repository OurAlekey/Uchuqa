package uchuca.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uchuca.domain.Contacto;
import uchuca.domain.repository.ContactoRepository;
import uchuca.persistence.crud.TbContactoCrudRepository;
import uchuca.persistence.entity.TbContacto;
import uchuca.persistence.mapper.ContactoMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class TbContactoRepository implements ContactoRepository {
    @Autowired
    private TbContactoCrudRepository repository;

    @Autowired
    private ContactoMapper mapper;



    @Override
    public Optional<Contacto> getId(Integer id) {
        return repository.findById(id).map(tbContacto -> mapper.toContacto(tbContacto));
    }

    @Override
    public List<Contacto> getAll() {
        List<TbContacto> tbContactos = (List<TbContacto>) repository.findAll();
        return mapper.toContactos(tbContactos);
    }

    @Override
    public Contacto save(Contacto contacto) {
        TbContacto tbContacto = mapper.toTbContacto(contacto);
        return mapper.toContacto(repository.save(tbContacto));
    }
}
