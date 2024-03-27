package uchuca.domain.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uchuca.domain.Departamento;
import uchuca.domain.Reaccion;
import uchuca.domain.repository.DepartamentoRepository;
import uchuca.domain.repository.ReaccionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReaccionService {
    @Autowired
    private ReaccionRepository repository;


    public Optional<Reaccion> getId(Integer id){
        return  repository.getById(id);
    }

    public List<Reaccion> getAll(){
        return  repository.getAll();
    }

    public  Reaccion save(Reaccion reaccion){
        return  repository.save(reaccion);
    }
}
