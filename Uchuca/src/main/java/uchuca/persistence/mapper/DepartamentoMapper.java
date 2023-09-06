package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uchuca.domain.Departamento;
import uchuca.persistence.entity.TbDepartamento;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartamentoMapper {
    @Mappings({
            @Mapping(source = "idDepartamento",target = "id"),
            @Mapping(source = "depDescripcion",target = "descripcion"),})
    Departamento toDepartamento(TbDepartamento tbDepartamento);
    List<Departamento> toDepartamentos(List<TbDepartamento> departamentos);
    @InheritInverseConfiguration
    TbDepartamento toTbDepartamento(Departamento departamento);
}
