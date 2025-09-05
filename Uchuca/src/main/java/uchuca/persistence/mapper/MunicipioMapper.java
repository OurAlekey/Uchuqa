package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uchuca.domain.Municipio;
import uchuca.persistence.entity.TbMunicipio;

import java.util.List;

@Mapper(componentModel ="spring"
        ,uses = {
        DepartamentoMapper.class
})
public interface MunicipioMapper {

    @Mappings({
            @Mapping(source = "idMunicipio",target = "id"),
            @Mapping(source = "munDescripcion",target = "descripcion"),
            @Mapping(source = "idDepartamento",target = "idDepartamento"),
            @Mapping(source = "departamento",target = "departamento"),

    })
    Municipio toMunicipio(TbMunicipio tbMunicipio);
    List<Municipio> toMunicipios(List<TbMunicipio> tbMunicipios);

    @InheritInverseConfiguration
    TbMunicipio toTbMunicipio(Municipio municipio);
}
