package uchuca.persistence.mapper;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uchuca.domain.Imagenes;
import uchuca.persistence.entity.TbImagenes;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImagenesMapper {

    @Mappings({
            @Mapping(source = "idImagen", target = "id"),
            @Mapping(source = "imaDescripcion", target = "descripcion"),
            @Mapping(source = "idProyecto", target = "idProyecto")
    })
    Imagenes toImagen (TbImagenes tbImagenes);
    List<Imagenes> toImagenes (List<TbImagenes> tbImagenes);
    @InheritInverseConfiguration
    TbImagenes toTbImagenes (Imagenes imagenes);
}
