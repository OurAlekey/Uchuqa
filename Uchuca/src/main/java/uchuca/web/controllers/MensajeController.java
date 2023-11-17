package uchuca.web.controllers;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.Chat;
import uchuca.domain.Mensaje;
import uchuca.domain.serviceImp.ChatService;
import uchuca.domain.serviceImp.MensajeService;
import uchuca.exeptions.BussnessNotFountException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mensaje")

public class MensajeController {


    @Autowired
    private MensajeService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar el mensaje por ID", authorizations = {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "mensaje encontrado"),
            @ApiResponse(code = 404, message = "No se encontro el mensaje")
    })

    public Optional<Mensaje> getId(@PathVariable("id") Integer id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("EL MENSAJE CON EL ID: " + id);
        } else {
            return service.getId(id);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Muestra todos los mensajes", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "mensajes encontrado")
    public List<Mensaje> getAll(){
        if(service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS");
        } else{
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guardar todos los chats", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "El chat fue creado con exito")
    public Mensaje save(@RequestBody Mensaje mensaje){
        return

                service.save(mensaje);
    }

    @MessageMapping("/mensaje/{idChat}")
    @SendTo("/topic/{idChat}")
    public Mensaje envio(@DestinationVariable("idChat")String id, Mensaje mensaje) {
    return   service.save(mensaje);
    }
}
