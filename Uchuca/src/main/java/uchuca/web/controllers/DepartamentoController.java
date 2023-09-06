package uchuca.web.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.Contacto;
import uchuca.domain.Departamento;
import uchuca.domain.serviceImp.ContactoService;
import uchuca.domain.serviceImp.DepartamentoService;
import uchuca.exeptions.BussnessNotFountException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
    @Autowired
    private DepartamentoService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca el departamento por id", authorizations= {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "departamento encontrado"),
            @ApiResponse(code = 404, message = "departamento no encontrado")
    })
    public Optional<Departamento> getId(@PathVariable("id") Integer id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("NO EXISTE EL DEPARTAMENTO CON EL ID: " + id );

        }else{
            return service.getId(id);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Muestra todos los departamento ", authorizations= {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "departamentoS encontrados")
    public List<Departamento> getAll(){
        if (service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS"  );
        }else {
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guarda el departamento", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "El departamento fue creado")
    public Departamento save(@RequestBody Departamento departamento){
        return service.save(departamento);
    }

}
