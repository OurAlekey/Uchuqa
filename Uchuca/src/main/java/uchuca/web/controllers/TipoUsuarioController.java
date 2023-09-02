package uchuca.web.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.TipoUsuario;
import uchuca.domain.Usuario;
import uchuca.domain.serviceImp.TipoUsuarioService;
import uchuca.domain.serviceImp.UsuarioService;
import uchuca.exeptions.BussnessNotFountException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipousurio")
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioService service;
    @GetMapping("/{id}")
    @ApiOperation(value = "Busca el usurio por id", authorizations= {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "usuario encontrado"),
            @ApiResponse(code = 404, message = "usuario no encontrado")
    })
    public Optional<TipoUsuario> getId(@PathVariable("id") Integer id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("NO EXISTE EL USUARIO CON EL ID: " + id );
        }else{
            return service.getId(id);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Muestra todos los usuarios, authorizations ", authorizations= {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "usurios encontrados")
    public List<TipoUsuario> getAll(){
        if (service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS"  );
        }else {
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guarda todos los usuarios", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "El usuario fue creado")
    public TipoUsuario save(@RequestBody TipoUsuario tipoUsuario){
        System.out.println("po");
        return service.save(tipoUsuario);
    }

}
