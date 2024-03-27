package uchuca.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uchuca.domain.Municipio;
import uchuca.domain.repository.MunicipioRepository;
import uchuca.persistence.crud.MunicipiCrudRepository;
import uchuca.persistence.entity.TbMunicipio;
import uchuca.persistence.mapper.MunicipioMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class TbMunicipioRepository implements MunicipioRepository {

    @Autowired
    private MunicipioMapper mapper;

    @Autowired
    private MunicipiCrudRepository repository;

    @Override
    public Optional<Municipio> getId(Integer id) {

        return repository.findById(id).map(tbMunicipio -> mapper.toMunicipio(tbMunicipio));
    }

    @Override
    public List<Municipio> getAll() {
        List<TbMunicipio> tbMunicipios = (List<TbMunicipio>) repository.findAll();
        return  mapper.toMunicipios(tbMunicipios);
    }

    @Override
    public Municipio save(Municipio municipio) {
        TbMunicipio tbMunicipio = mapper.toTbMunicipio(municipio);
        return mapper.toMunicipio(repository.save(tbMunicipio));
    }
}
