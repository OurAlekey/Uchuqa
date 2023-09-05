package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uchuca.domain.Contacto;
import uchuca.persistence.entity.TbContacto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactoMapper {
    @Mappings({
            @Mapping(source = "idContacto",target = "id"),
            @Mapping(source = "conDescripcion",target = "descripcion"),
            @Mapping(source = "usuarioId",target = "usuarioId"),
            @Mapping(source = "idTipoContacto",target = "idTipoContacto"),
    })
    Contacto toContacto(TbContacto tbContacto);
    List<Contacto> toContactos(List<TbContacto> tbContactos);

    @InheritInverseConfiguration
    TbContacto toTbContacto(Contacto contacto);
}
