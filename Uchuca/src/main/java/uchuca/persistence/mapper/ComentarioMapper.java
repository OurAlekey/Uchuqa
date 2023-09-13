package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uchuca.domain.Chat;
import uchuca.domain.Comentario;
import uchuca.persistence.entity.TbChat;
import uchuca.persistence.entity.TbComentario;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ComentarioMapper {

    @Mappings({
            @Mapping(source = "idComentario", target = "id"),
            @Mapping(source = "comDescripcion", target = "descripcion"),
            @Mapping(source = "comUsuaId", target = "usuaId"),
            @Mapping(source = "idProyecto", target = "idProyecto"),
            @Mapping(source = "idComentarioFk", target = "idComentarioFk")
    })
    Comentario toComentario (TbComentario tbComentario);

    List<Comentario>toComentarios(List<TbComentario>tbComentarios);

    @InheritInverseConfiguration
    TbComentario toTbComentario (Comentario comentario);


}
