package uchuca.domain.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uchuca.domain.Proyecto;
import uchuca.domain.repository.ProyectoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository repository;

    public Optional<Proyecto> getId(Integer id){
        return repository.getId(id);
    }

    public List<Proyecto> getAll(){
        return repository.getAll();
    }

    public Proyecto save(Proyecto proyecto){
        return  repository.save(proyecto);
    }
}
