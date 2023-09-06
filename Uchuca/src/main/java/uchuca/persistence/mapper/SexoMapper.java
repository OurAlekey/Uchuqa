package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uchuca.domain.Sexo;
import uchuca.persistence.entity.TbSexo;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SexoMapper {


    @Mappings({
            @Mapping(source = "idSexo",target = "id"),
            @Mapping(source = "sexDescripcion",target = "descripcion"),


    })
    Sexo toSexo (TbSexo tbSexo);
    List<Sexo> toSexos (List<TbSexo> tbSexo);
    @InheritInverseConfiguration
    TbSexo toTbSexo (Sexo sexo);
}
