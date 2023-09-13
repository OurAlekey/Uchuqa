package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uchuca.domain.Etiqueta;
import uchuca.persistence.entity.TbEtiqueta;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtiquetaMapper {

    @Mappings({
            @Mapping(source = "idEtiqueta", target = "id"),
            @Mapping(source = "etiDescripcion", target = "descripcion")
    })
    Etiqueta toEtiqueta (TbEtiqueta tbEtiqueta);
    List<Etiqueta> toEtiquetas (List<TbEtiqueta> tbEtiquetas);
    @InheritInverseConfiguration
    TbEtiqueta toTbEtiqueta (Etiqueta etiqueta);
}
