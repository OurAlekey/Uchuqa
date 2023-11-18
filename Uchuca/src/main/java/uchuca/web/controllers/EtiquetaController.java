package uchuca.web.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.Etiqueta;
import uchuca.domain.Usuario;
import uchuca.domain.serviceImp.EtiquetaService;
import uchuca.domain.serviceImp.UsuarioService;
import uchuca.exeptions.BussnessNotFountException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etiqueta")
public class EtiquetaController {

    @Autowired
    private EtiquetaService service;
    @GetMapping("/{id}")


    @ApiResponses({
            @ApiResponse(code = 200, message = "etiqueta encontrado"),
            @ApiResponse(code = 404, message = "etiqueta no encontrado")
    })
    public Optional<Etiqueta> getId(@PathVariable("id") Integer id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("LA ETIQUETA  CON EL ID: " + id );

        }else{
            System.out.println("envia nuevamente");
            return service.getId(id);
        }
    }


    @GetMapping("/all")
    @ApiOperation(value = "Muestra todos las etiquetas, authorizations ", authorizations= {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "etiquetas encontrados")
    public List<Etiqueta> getAll(){
        if (service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS"  );
        }else {
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guarda todas las etiquetas", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "El etiquetas fue creado")
    public Etiqueta save(@RequestBody Etiqueta etiqueta){
        System.out.println("po");
        return

                service.save(etiqueta);
    }
}
