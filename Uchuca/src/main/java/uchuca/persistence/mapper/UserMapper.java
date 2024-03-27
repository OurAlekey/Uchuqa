package uchuca.persistence.mapper;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uchuca.domain.Usuario;
import uchuca.persistence.entity.TbUser;

import java.util.List;

@Mapper(componentModel ="spring",uses = {
        MunicipioMapper.class, SexoMapper.class
})
public interface UserMapper {
    @Mappings({
            @Mapping(source = "idUsuario",target = "id"),
            @Mapping(source = "usuEdad",target = "edad"),
            @Mapping(source = "usuEmail",target = "correo"),
            @Mapping(source = "usoContra",target = "contrasena"),
            @Mapping(source = "usuNombre",target = "nombre"),
            @Mapping(source = "usuApellido",target = "apellido"),
            @Mapping(source = "idMunicipio",target = "idMunicipio"),
            @Mapping(source = "idTipoUsuario",target = "idTipoUsuario"),
            @Mapping(source = "idSexo",target = "idSexo"),
            @Mapping(source = "usuDescripcion",target = "descipcion"),
            @Mapping(source = "usuDireccion",target = "direccion"),
            @Mapping(source = "tbMunicipio",target = "municipio"),
            @Mapping(source = "tbSexo",target = "sexo"),
    })
    Usuario toUsuario (TbUser tbUser);
    List<Usuario> toUsuarios (List<TbUser> tbUsers);
    @InheritInverseConfiguration
    TbUser toTbUser (Usuario usuario);

}
