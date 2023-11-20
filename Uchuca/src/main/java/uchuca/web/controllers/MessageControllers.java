package uchuca.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.Mensaje;
import uchuca.domain.serviceImp.MensajeService;

import java.util.List;
@RestController

public class MessageControllers {


    @Autowired
    private MensajeService service;


    @MessageMapping("/chat/{to}")
    public void sendMessagePersonal(@DestinationVariable String to, Mensaje message) {
     System.out.println("dentro del chat");
        service.sendMessage(to,message);
    }

    @GetMapping("/listmessage/{idChat}")
    public List<Mensaje> getListMensaje(@PathVariable("idChat") Integer idChat){
        return service.getListMessage(idChat);
    }
}
