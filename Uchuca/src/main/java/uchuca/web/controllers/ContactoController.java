package uchuca.web.controllers;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.Contacto;
import uchuca.domain.Usuario;
import uchuca.domain.serviceImp.ContactoService;
import uchuca.exeptions.BussnessNotFountException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacto")

public class ContactoController {

    @Autowired
    private ContactoService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca el contacto por id", authorizations= {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "contacto encontrado"),
            @ApiResponse(code = 404, message = "contacto no encontrado")
    })
    public Optional<Contacto> getId(@PathVariable("id") Integer id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("NO EXISTE EL CONTACTO CON EL ID: " + id );

        }else{
            return service.getId(id);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Muestra todos los contactos ", authorizations= {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "contactos encontrados")
    public List<Contacto> getAll(){
        if (service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS"  );
        }else {
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guarda el contacto", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "El contacto fue creado")
    public Contacto save(@RequestBody Contacto contacto){
        return service.save(contacto);
    }

}
