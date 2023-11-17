package uchuca.web.controllers;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.Chat;
import uchuca.domain.serviceImp.ChatService;
import uchuca.exeptions.BussnessNotFountException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chat")

public class ChatController {


    @Autowired
    private ChatService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar el chat por ID", authorizations = {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Chat encontrado"),
            @ApiResponse(code = 404, message = "No se encontro el chat")
    })

    public Optional<Chat> getId(@PathVariable("id") Integer id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("EL CHAT CON EL ID: " + id);
        } else {
            System.out.println("envie nuevamente");
            return service.getId(id);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Muestra todos los chats", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "Chat encontrado")
    public List<Chat> getAll(){
        if(service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS");
        } else{
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guardar todos los chats", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "El chat fue creado con exito")
    public Chat save(@RequestBody Chat chat){
        System.out.println("po");
        return

                service.save(chat);
    }


}
