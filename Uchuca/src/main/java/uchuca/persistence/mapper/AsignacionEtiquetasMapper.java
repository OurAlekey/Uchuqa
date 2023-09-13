package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import uchuca.domain.AsignacionEtiquetas;
import uchuca.persistence.entity.TbAsignacionEtiquetas;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AsignacionEtiquetasMapper {

    @Mappings({
            @Mapping(source = "idAsignacionEtiqueta", target = "id"),
            @Mapping(source = "idEtiqueta", target = "idEtiqueta"),
            @Mapping(source = "idProyecto", target = "idProyecto")

    })

    AsignacionEtiquetas toAsignacion (TbAsignacionEtiquetas tbAsignacionEtiquetas);

    List<AsignacionEtiquetas>toAsignaciones(List<TbAsignacionEtiquetas>tbAsignacionEtiquetas);

    @InheritInverseConfiguration
    TbAsignacionEtiquetas toTbAsignacioneEtiquetas (AsignacionEtiquetas asignacionEtiquetas);
}
