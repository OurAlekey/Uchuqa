package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uchuca.domain.TipoUsuario;
import uchuca.persistence.entity.TbTipoUsuario;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoUsuarioMapper {
    @Mappings({
            @Mapping(source = "idTipoUsuario",target = "id"),
            @Mapping(source = "tusDescripcion",target = "descripcion"),})
    TipoUsuario toTipoUsuario(TbTipoUsuario tbTipoUsuario);
    List<TipoUsuario> toTipoUsuarios(List<TbTipoUsuario> tbTipoUsuarios);
    @InheritInverseConfiguration
    TbTipoUsuario toTbTipoUsuario(TipoUsuario tipoUsuario);

}
