package uchuca.web.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.Municipio;
import uchuca.domain.Reaccion;
import uchuca.domain.serviceImp.MunicipioService;
import uchuca.domain.serviceImp.ReaccionService;
import uchuca.exeptions.BussnessNotFountException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {
    @Autowired
    private MunicipioService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca el municipio  por id", authorizations= {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "municipio encontrada"),
            @ApiResponse(code = 404, message = "municipio no encontrada")
    })
    public Optional<Municipio> getId(@PathVariable("id") Integer id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("NO EXISTE EL MUNICIPIO CON EL ID: " + id );
        }else{
            return service.getId(id);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Muestra todos los municipios ", authorizations= {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "municipios encontrados")
    public List<Municipio> getAll(){
        if (service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS"  );
        }else {
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guarda el municipio", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "El municpio fue creado con exito")
    public Municipio save(@RequestBody Municipio municipio){
        return service.save(municipio);
    }

}
