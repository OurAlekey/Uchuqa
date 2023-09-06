package uchuca.domain.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uchuca.domain.Departamento;
import uchuca.domain.repository.DepartamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository repository;


    public Optional<Departamento> getId(Integer id){
        return  repository.getId(id);
    }

    public List<Departamento> getAll(){
        return  repository.getAll();
    }

    public  Departamento save(Departamento departamento){
        return  repository.save(departamento);
    }
}
