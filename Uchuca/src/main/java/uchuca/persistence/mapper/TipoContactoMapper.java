package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uchuca.domain.TipoContacto;
import uchuca.domain.TipoUsuario;
import uchuca.persistence.entity.TbTipoContacto;
import uchuca.persistence.entity.TbTipoUsuario;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoContactoMapper {
    @Mappings({
            @Mapping(source = "idTipoContacto",target = "id"),
            @Mapping(source = "tcoDescripcion",target = "descripcion"),})
    TipoContacto toTipoContacto(TbTipoContacto tbTipoContacto);
    List<TipoContacto> toTipoContactos(List<TbTipoContacto> tbTipoContactos);
    @InheritInverseConfiguration
    TbTipoContacto toTbTipoContacto(TipoContacto tipoContacto);

}
