package uchuca.web.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.Etiqueta;
import uchuca.domain.Imagenes;
import uchuca.domain.serviceImp.EtiquetaService;
import uchuca.domain.serviceImp.ImagenesService;
import uchuca.exeptions.BussnessNotFountException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imagen")
public class ImagenController {
    @Autowired
    private ImagenesService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca la imagen por id", authorizations= {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "imagen encontrado"),
            @ApiResponse(code = 404, message = "imagen no encontrado")
    })
    public Optional<Imagenes> getId(@PathVariable("id") Integer id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("LA ETIQUETA  CON EL ID: " + id );

        }else{
            System.out.println("envia nuevamente");
            return service.getId(id);
        }
    }


    @GetMapping("/all")
    @ApiOperation(value = "Muestra todos las imagenes, authorizations ", authorizations= {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "imagenes encontrados")
    public List<Imagenes> getAll(){
        if (service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS"  );
        }else {
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guarda todas las imagenes", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "La imagen fue creado")
    public Imagenes save(@RequestBody Imagenes imagenes){
        System.out.println("po");
        return

                service.save(imagenes);
    }


    @GetMapping("/idproyecto/{id}")
    @ApiOperation(value = "Muestra todos las imagenes, authorizations ", authorizations= {@Authorization(value = "JWT")})
    @ApiResponse(code  = 200, message = "imagenes encontrados")
    public List<Imagenes> getByIdProyecto(@PathVariable("id") Integer id){

            return service.getByIdProyecto(id);

    }
}
