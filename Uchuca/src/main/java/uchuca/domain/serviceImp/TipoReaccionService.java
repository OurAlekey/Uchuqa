package uchuca.domain.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uchuca.domain.TipoReaccion;
import uchuca.domain.repository.TipoReaccionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TipoReaccionService {
    @Autowired
    private TipoReaccionRepository repository;


    public Optional<TipoReaccion> getId(Integer id){
        return  repository.getId(id);
    }

    public List<TipoReaccion> getAll(){
        return  repository.getAll();
    }

    public  TipoReaccion save(TipoReaccion tipoReaccion){
        return  repository.save(tipoReaccion);
    }
}
