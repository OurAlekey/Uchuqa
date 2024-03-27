package uchuca.domain.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uchuca.domain.Municipio;
import uchuca.domain.repository.MunicipioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipioService {
    @Autowired
    private MunicipioRepository repository;


    public Optional<Municipio> getId(Integer id){
        return  repository.getId(id);
    }

    public List<Municipio> getAll(){
        return  repository.getAll();
    }

    public  Municipio save(Municipio municipio){
        return  repository.save(municipio);
    }
}
