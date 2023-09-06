package uchuca.domain.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uchuca.domain.TipoContacto;
import uchuca.domain.repository.TipoContactoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TipoContactoService {
    @Autowired
    private TipoContactoRepository repository;


    public Optional<TipoContacto> getId(Integer id){
        return  repository.getId(id);
    }

    public List<TipoContacto> getAll(){
        return  repository.getAll();
    }

    public  TipoContacto save(TipoContacto tipoContacto){
        return  repository.save(tipoContacto);
    }
}
