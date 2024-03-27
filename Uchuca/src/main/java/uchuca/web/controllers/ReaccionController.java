package uchuca.web.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.Departamento;
import uchuca.domain.Reaccion;
import uchuca.domain.serviceImp.DepartamentoService;
import uchuca.domain.serviceImp.ReaccionService;
import uchuca.exeptions.BussnessNotFountException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reaccion")
public class ReaccionController {
    @Autowired
    private ReaccionService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca el contador de la reaccion  por id", authorizations= {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "reaccion encontrada"),
            @ApiResponse(code = 404, message = "reaccion no encontrada")
    })
    public Optional<Reaccion> getId(@PathVariable("id") Integer id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("NO EXISTE LA REACCION CON EL ID: " + id );
        }else{
            return service.getId(id);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Muestra todos las reacciones ", authorizations= {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "Reacciones encontrados")
    public List<Reaccion> getAll(){
        if (service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS"  );
        }else {
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guarda la reaccion", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "La reaccion fue creada con exito")
    public Reaccion save(@RequestBody Reaccion reaccion){
        return service.save(reaccion);
    }

}
