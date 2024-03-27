package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uchuca.domain.TipoReaccion;
import uchuca.domain.TipoUsuario;
import uchuca.persistence.entity.TbTipoReaccion;
import uchuca.persistence.entity.TbTipoUsuario;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoReaccionMapper {
    @Mappings({
            @Mapping(source = "idReaccion",target = "id"),
            @Mapping(source = "tipDescripcion",target = "descripcion"),})
    TipoReaccion toTipoReaccion(TbTipoReaccion tbTipoReaccion);
    List<TipoReaccion> toTipoReacciones(List<TbTipoReaccion> tbTipoReacciones);
    @InheritInverseConfiguration
    TbTipoReaccion toTbTipoReaccion(TipoReaccion tipoReaccion);

}
