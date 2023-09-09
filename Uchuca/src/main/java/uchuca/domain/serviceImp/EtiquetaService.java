package uchuca.domain.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uchuca.domain.Etiqueta;
import uchuca.domain.repository.EtiquetaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EtiquetaService {

    @Autowired
    private EtiquetaRepository repository;

    public Optional<Etiqueta> getId(Integer id){
        return repository.getId(id);
    }

    public List<Etiqueta> getAll(){
        return repository.getAll();
    }

    public Etiqueta save(Etiqueta etiqueta){
        return repository.save(etiqueta);
    }
}
