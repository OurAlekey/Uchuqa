package uchuca.web.controllers;


import uchuca.exeptions.BussnessNotFountException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.Usuario;
import uchuca.domain.serviceImp.UsuarioService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsuarioService service;
    @GetMapping("/{id}")
    @ApiOperation(value = "Busca el usurio por id", authorizations= {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "usuario encontrado"),
            @ApiResponse(code = 404, message = "usuario no encontrado")
    })
    public Optional<Usuario>getId(@PathVariable("id") long id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("NO EXISTE EL USUARIO CON EL ID: " + id );
        }else{
            System.out.println("envia nuevamente");
            return service.getId(id);
        }
    }

    @GetMapping("/email/{email}")
    @ApiOperation(value = "Busca el usurio por correo", authorizations= {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse  (code = 200, message = "usuario encontrado"),
            @ApiResponse(code = 404, message = "usuario no encontrado")
    })
    public Usuario getByEmail(@PathVariable("email") String email){
        if(service.getUserByEmail(email).equals(null)){
            System.out.println("error");
            throw new BussnessNotFountException("NO EXISTE EL USUARIO CON EL ID: " + email );
        }else{
            System.out.println("retorno");
            return service.getUserByEmail(email);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Muestra todos los usuarios, authorizations ", authorizations= {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "usurios encontrados")
    public List<Usuario> getAll(){
        if (service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS"  );
        }else {
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guarda todos los usuarios", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "El usuario fue creado")
    public Usuario save(@RequestBody Usuario userDto){
        System.out.println("po");
        return

                service.save(userDto);
    }
}
