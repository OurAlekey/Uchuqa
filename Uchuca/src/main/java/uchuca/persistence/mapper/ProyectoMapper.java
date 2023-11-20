package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uchuca.domain.Proyecto;
import uchuca.persistence.entity.TbProyecto;

import java.util.List;

@Mapper(componentModel ="spring",uses = {
        ImagenesMapper.class
})
public interface ProyectoMapper {

    @Mappings({
            @Mapping(source = "idProyecto", target = "id"),
            @Mapping(source = "prNombre", target = "nombre"),
            @Mapping(source = "prDescripcion", target = "descripcion"),
            @Mapping(source = "idUsuario", target = "idUsuario"),
            @Mapping(source = "imagenes", target = "imagenes")

    })
    Proyecto toProyecto (TbProyecto tbProyectos);
    List<Proyecto> toProyectos (List<TbProyecto> tbProyectos);

    @InheritInverseConfiguration
    TbProyecto toTbProyecto (Proyecto proyecto);
}
