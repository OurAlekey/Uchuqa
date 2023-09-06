package uchuca.domain.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uchuca.domain.Sexo;
import uchuca.domain.repository.SexoRepository;

import java.util.List;
import java.util.Optional;
@Service
public class SexoService {
    @Autowired
    private SexoRepository repository;

    public Optional<Sexo> getId(Integer id){
        return repository.getId(id);
    }

    public List<Sexo> getAll(){
        return  repository.getAll();
    }

    public Sexo save(Sexo sexo){
        return  repository.save(sexo);
    }
}
