package uchuca.web.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uchuca.domain.AsignacionEtiquetas;
import uchuca.domain.serviceImp.AsignacionEtiquetasService;
import uchuca.exeptions.BussnessNotFountException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/asignacionetiquetas")
public class AsignacionEtiquetasController {

    @Autowired
    private AsignacionEtiquetasService service;

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar la asignacion por el ID", authorizations = {@Authorization(value = "JWT")})
    @ApiResponses({
            @ApiResponse(code = 200, message = "Asignacion encontrada"),
            @ApiResponse(code = 404, message = "No se encontro la asignacion")
    })

    public Optional<AsignacionEtiquetas> getId(@PathVariable("id") Integer id){
        if(service.getId(id).isEmpty()){
            throw new BussnessNotFountException("LA ASIGNACION CON EL ID : " + id);
        } else {
            System.out.println("envie nuevamente");
            return service.getId(id);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Muestra todas las asignaciones", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "Asignacion encontrada")
    public List<AsignacionEtiquetas> getAll(){
        if(service.getAll().isEmpty()){
            throw new BussnessNotFountException("NO EXISTEN REGISTROS");
        } else{
            return service.getAll();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "Guardar todas las asignaciones", authorizations = {@Authorization(value = "JWT")})
    @ApiResponse(code = 200, message = "La asignacion fue creada con exito")
    public AsignacionEtiquetas save(@RequestBody AsignacionEtiquetas asignacionEtiquetas){
        System.out.println("po");
        return

                service.save(asignacionEtiquetas);
    }







}
