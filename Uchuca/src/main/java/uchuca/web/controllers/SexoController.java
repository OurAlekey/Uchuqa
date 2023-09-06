package uchuca.web.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.Departamento;
import uchuca.domain.Sexo;
import uchuca.domain.serviceImp.DepartamentoService;
import uchuca.domain.serviceImp.SexoService;
import uchuca.exeptions.BussnessNotFountException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sexo")
public class SexoController {

    @Autowired
    private SexoService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca el sexo por id", authorizations= {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "sexo encontrado"),
            @ApiResponse(code = 404, message = "sexo no encontrado")
    })
    public Optional<Sexo> getId(@PathVariable("id") Integer id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("NO EXISTE EL SEXO CON EL ID: " + id );

        }else{
            return service.getId(id);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Muestra todos los sexo ", authorizations= {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "sexos encontrados")
    public List<Sexo> getAll(){
        if (service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS"  );
        }else {
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guarda el sexo en la base de datos", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "El sexo fue creado")
    public Sexo save(@RequestBody Sexo sexo){
        return service.save(sexo);
    }

}
