package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import uchuca.domain.Chat;
import uchuca.persistence.entity.TbChat;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    @Mappings({
            @Mapping(source = "idChat", target = "id"),
            @Mapping(source = "chatDescripcion", target = "descripcion"),
            @Mapping(source = "chatFecha", target = "fecha"),
            @Mapping(source = "idProyecto", target = "idProyecto"),
            @Mapping(source = "idUsuario", target = "idUsuario")
    })

    Chat toChat (TbChat tbChat);

    List<Chat>toChats(List<TbChat>tbChats);

    @InheritInverseConfiguration
    TbChat toTbChat (Chat chat);


}
