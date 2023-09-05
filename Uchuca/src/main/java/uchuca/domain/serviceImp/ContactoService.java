package uchuca.domain.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uchuca.domain.Contacto;
import uchuca.domain.repository.ContactoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoService {
    @Autowired
    private ContactoRepository repository;


    public Optional<Contacto> getId(Integer id){
        return  repository.getId(id);
    }

    public List<Contacto> getAll(){
        return  repository.getAll();
    }

    public Contacto save(Contacto contacto){
        return repository.save(contacto);
    }

}
