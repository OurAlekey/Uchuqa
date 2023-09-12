package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uchuca.domain.Proyecto;
import uchuca.persistence.entity.TbProyecto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProyectoMapper {

    @Mappings({
            @Mapping(source = "idProyecto", target = "idProyecto"),
            @Mapping(source = "prDescripcion", target = "prDescripcion"),
            @Mapping(source = "prNombre", target = "prNombre"),
            @Mapping(source = "idUsuario", target = "idUsuario")

    })
    Proyecto toProyecto (TbProyecto tbProyectos);
    List<Proyecto> toProyectos (List<TbProyecto> tbProyectos);

    @InheritInverseConfiguration
    TbProyecto toTbProyecto (Proyecto proyecto);
}
