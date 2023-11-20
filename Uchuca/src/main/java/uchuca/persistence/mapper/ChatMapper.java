package uchuca.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import uchuca.domain.Chat;
import uchuca.persistence.entity.TbChat;

import java.util.List;

@Mapper(componentModel = "spring",uses = {
        UserMapper.class
})
public interface ChatMapper {

    @Mappings({
            @Mapping(source = "idChat", target = "id"),
            @Mapping(source = "idProyecto", target = "idProyecto"),
            @Mapping(source = "idUsuario", target = "idUsuario"),
            @Mapping(source = "idUsuario2", target = "idUsuario2"),
            @Mapping(source = "tbUser", target = "usuario"),
            @Mapping(source = "tbUser2", target = "usuario2")
    })

    Chat toChat (TbChat tbChat);

    List<Chat>toChats(List<TbChat>tbChats);

    @InheritInverseConfiguration
    TbChat toTbChat (Chat chat);


}
