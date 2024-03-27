package uchuca.web.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.Reaccion;
import uchuca.domain.TipoReaccion;
import uchuca.domain.serviceImp.ReaccionService;
import uchuca.domain.serviceImp.TipoReaccionService;
import uchuca.exeptions.BussnessNotFountException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tiporeaccion")
public class TipoReaccionController {
    @Autowired
    private TipoReaccionService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca el contador de la reaccion  por id", authorizations= {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Tipo de reaccion encontrada"),
            @ApiResponse(code = 404, message = "Tipo de reaccion no encontrada")
    })
    public Optional<TipoReaccion> getId(@PathVariable("id") Integer id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("NO EXISTE EL TIPO DE REACCION CON EL ID: " + id );
        }else{
            return service.getId(id);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Muestra todos los tipos de reaccion ", authorizations= {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "Tipos de reaccion no  encontrados")
    public List<TipoReaccion> getAll(){
        if (service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS"  );
        }else {
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guarda el tipo de  reaccion", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "El tipo de  reaccion fue creada con exito")
    public TipoReaccion save(@RequestBody TipoReaccion tipoReaccion){
        return service.save(tipoReaccion);
    }

}
