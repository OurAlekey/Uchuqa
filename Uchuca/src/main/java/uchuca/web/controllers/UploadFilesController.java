package uchuca.web.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uchuca.domain.Usuario;
import uchuca.domain.repository.UploadFilesRep;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.Resource;
@RestController
@RequestMapping("/img")

public class UploadFilesController {

    @Autowired
    UploadFilesRep uploadFilesRep;
    @PostMapping("/cargar/portada/{idUser}")
    @ApiOperation(value = "Guarda la imagen de portada con el id del usaurio", authorizations= {@Authorization(value = "JWT")})
    private ResponseEntity<Usuario> uploadPortada(@RequestParam("img")MultipartFile file, @PathVariable("idUser")Long idUser) throws Exception {
        return  new ResponseEntity<>(uploadFilesRep.cargarPortada(file,idUser), HttpStatus.OK);

    }

    @PostMapping("/cargar/perfil/{idUser}")
    @ApiOperation(value = "Guarda la imagen del perfil con el id del usaurio", authorizations= {@Authorization(value = "JWT")})
    private ResponseEntity<Usuario> uploadPerfil(@RequestParam("img")MultipartFile file, @PathVariable("idUser")Long idUser) throws Exception {
        return  new ResponseEntity<>(uploadFilesRep.cargarPerfil(file,idUser), HttpStatus.OK);

    }

//    @GetMapping("/{imageName}")
//    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
//        Path imagePath = Paths.get("src/main/picture/", imageName);
//
//        // Verifica si el archivo existe antes de intentar leerlo
//        if (Files.exists(imagePath)) {
//            byte[] imageBytes = Files.readAllBytes(imagePath);
//            return ResponseEntity.ok().body(imageBytes);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }



    @GetMapping(value = "/buscar/{filename}")
    @ApiOperation(value = "Busca la imagen con el nombre del archivo", authorizations= {@Authorization(value = "JWT")})

    public ResponseEntity<Resource> goImage(@PathVariable ("filename") String filename) {

        String fullPath = "src/main/picture/" + filename;

        Path imagePath = Paths.get(fullPath);
        Resource resource = new FileSystemResource(imagePath.toFile());


        if (resource.exists()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                    .body(resource);
        } else {
            // Manejar el caso donde la imagen no existe
            return ResponseEntity.notFound().build();
        }
    }


}
