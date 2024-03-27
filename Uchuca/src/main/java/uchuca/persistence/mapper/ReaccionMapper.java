package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uchuca.domain.Reaccion;
import uchuca.persistence.entity.TbReaccion;

import java.util.List;

@Mapper(componentModel ="spring")
public interface ReaccionMapper {
    @Mappings({
            @Mapping(source = "idContadorReacciones", target = "id"),
            @Mapping(source = "reacTotal", target = "totalReaccion"),
            @Mapping(source = "idReaccion", target = "idReaccion"),
            @Mapping(source = "idPoryecto", target = "idProyecto")
    })
    Reaccion toReaccion (TbReaccion tbReaccion);
    List<Reaccion> toReacciones(List<TbReaccion> tbReacciones);

    @InheritInverseConfiguration
    TbReaccion toTbReaccion(Reaccion reaccion);
}
