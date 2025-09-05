package uchuca.web.controllers;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.Proyecto;
import uchuca.domain.serviceImp.ProyectoService;
import uchuca.exeptions.BussnessNotFountException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca el Proyecto por su ID", authorizations = {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Proyecto Encontrado"),
            @ApiResponse(code = 404, message = "Proyecto no Encontrado")
    })

    public Optional<Proyecto> getId(@PathVariable("id")Integer id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("EL PROYECTO CON EL ID: " + id);
        } else{
            System.out.println("Envielo nuevamente");
            return service.getId(id);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Muestra todos los proyectos", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "Proyecto encontrado")
    public List<Proyecto> getAll(){
        if(service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS");
        } else{
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guarda todos los proyectos", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "El proyecto fue creado con exito!")
    public Proyecto save(@RequestBody Proyecto proyecto){
        return service.save(proyecto);
    }


    @GetMapping("/nombre")
    public List<Proyecto> getByNombre(@RequestParam(required = false) String nombre){
        System.out.println(nombre  + "nopmbre");
        if (service.getByNombre(nombre).isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS");
        }else{
           return service.getByNombre(nombre);
        }
    }

    @GetMapping("/id-usuario/{id}")
    public List<Proyecto> getByUsuarioId(@PathVariable("id") Integer id){

        if (service.getByUsuarioId(id).isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS");
        }else{
            return service.getByUsuarioId(id);
        }
    }


}
