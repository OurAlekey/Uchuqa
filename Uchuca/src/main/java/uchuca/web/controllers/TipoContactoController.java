package uchuca.web.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.Contacto;
import uchuca.domain.TipoContacto;

import uchuca.domain.serviceImp.TipoContactoService;
import uchuca.exeptions.BussnessNotFountException;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/tipocontacto")
public class TipoContactoController {
    @Autowired
    private TipoContactoService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca el tipo acontacto por id", authorizations= {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "tipo contacto encontrado"),
            @ApiResponse(code = 404, message = "tipo contacto no encontrado")
    })
    public Optional<TipoContacto> getId(@PathVariable("id") Integer id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("NO EXISTE EL TIPO CONTACTO CON EL ID: " + id );

        }else{
            return service.getId(id);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Muestra todos los tipos contactos ", authorizations= {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "contactos encontrados")
    public List<TipoContacto> getAll(){
        if (service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS"  );
        }else {
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guarda el tipo contacto", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "Tipo contacto fue creado")
    public TipoContacto save(@RequestBody TipoContacto tipoContacto){
        return service.save(tipoContacto);
    }
}
