package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uchuca.domain.Mensaje;
import uchuca.persistence.entity.TbMensaje;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MensajeMapper {

    @Mappings({
            @Mapping(source = "idMensaje", target = "id"),
            @Mapping(source = "idChat", target = "idChat"),
            @Mapping(source = "menMensjae", target = "mensaje"),
            @Mapping(source = "idUsuario", target = "idUsuario"),
            @Mapping(source = "menFechaInsercion", target = "fechaInsercion")
    })
    Mensaje toMensaje (TbMensaje tbMensaje);

    List<Mensaje> toMensajes (List<TbMensaje> tbMensajes);

    @InheritInverseConfiguration
    TbMensaje toTbMensaje (Mensaje mensaje);

}
