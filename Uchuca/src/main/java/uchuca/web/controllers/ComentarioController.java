package uchuca.web.controllers;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.Chat;
import uchuca.domain.Comentario;
import uchuca.domain.serviceImp.ChatService;
import uchuca.domain.serviceImp.ComentarioService;
import uchuca.exeptions.BussnessNotFountException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentario")

public class ComentarioController {


    @Autowired
    private ComentarioService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar el comentario por ID", authorizations = {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Comentario encontrado"),
            @ApiResponse(code = 404, message = "No se encontro el comentario")
    })

    public Optional<Comentario> getId(@PathVariable("id") Integer id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("EL COMENTARIO CON EL ID: " + id);
        } else {
            System.out.println("envie nuevamente");
            return service.getId(id);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Muestra todos los comentarios", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "comentario encontrado")
    public List<Comentario> getAll(){
        if(service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS");
        } else{
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guardar todos los comentarios", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "El comentario fue creado con exito")
    public Comentario save(@RequestBody Comentario comentario){
        System.out.println("po");
        return

                service.save(comentario);
    }
}
