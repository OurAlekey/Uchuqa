package uchuca.domain.serviceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uchuca.domain.Imagenes;
import uchuca.domain.repository.ImagenesRepository;

import java.util.List;
import java.util.Optional;



@Service
public class ImagenesService {

    @Autowired
    private ImagenesRepository repository;

    public Optional<Imagenes> getId(Integer id){
        return repository.getId(id);
    }

    public List<Imagenes> getAll(){
        return repository.getAll();
    }

    public Imagenes save(Imagenes imagenes){
        return repository.save(imagenes);
    }
}
