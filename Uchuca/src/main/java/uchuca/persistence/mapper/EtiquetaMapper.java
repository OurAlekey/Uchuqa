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
            @Mapping(source = "idEtiqueta", target = "idEtiqueta"),
            @Mapping(source = "etiDescripcion", target = "etiDescripcion")
    })
    Etiqueta toEtiqueta (TbEtiqueta tbEtiqueta);
    List<Etiqueta> toEtiqueta (List<TbEtiqueta> tbetiqueta);
    @InheritInverseConfiguration
    TbEtiqueta toTbEtiqueta (Etiqueta etiqueta);
}
