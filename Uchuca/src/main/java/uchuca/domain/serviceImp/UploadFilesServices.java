package uchuca.domain.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uchuca.domain.Imagenes;
import uchuca.domain.Mensaje;
import uchuca.domain.Usuario;
import uchuca.domain.repository.UploadFilesRep;
import uchuca.exeptions.EmailExistsException;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UploadFilesServices implements UploadFilesRep {

    @Autowired
    UsuarioService usuerService;

    @Autowired
    ImagenesService imagenesService;
    @Override
    public Imagenes cargarPortada(MultipartFile file,Long idUser) throws Exception {
        try {
            Imagenes imagenes = new Imagenes();
            String fileName = UUID.randomUUID().toString();
            String  newFileName =  cargarImg(file,fileName+"Portada");
            imagenes.setDescripcion(newFileName);
            imagenes.setIdUserPortada(idUser);
            return  imagenesService.save(imagenes);
        }catch (Exception e){
            throw new EmailExistsException("Ocurrio un error");
        }
    }

    @Override
    public Imagenes cargarPerfil(MultipartFile file, Long idUser) throws Exception {
        try {

            Imagenes imagenes = new Imagenes();
            String fileName = UUID.randomUUID().toString();
            String  newFileName =  cargarImg(file,fileName+"Portada");
            imagenes.setDescripcion(newFileName);
            imagenes.setIdUserPortada(idUser);
            return  imagenesService.save(imagenes);
        }catch (Exception e){
            throw new EmailExistsException("Error al guardar");
        }
    }

    @Override
    public List<Imagenes> saveAll(List<MultipartFile> files, Long idProyecto) throws Exception {
        try {
            List<Imagenes> imagenes = new ArrayList<>();

            for (MultipartFile file : files) {
                String fileName = UUID.randomUUID().toString();
                String newFileName = cargarImg(file, fileName);
                Imagenes imagen = new Imagenes();
                imagen.setDescripcion(newFileName);
                imagen.setIdProyecto(Math.toIntExact(idProyecto));
                Imagenes imagenReturn = imagenesService.save(imagen);
                imagenes.add(imagenReturn);
            }

            return imagenes;
        }catch (Exception e){
            throw new EmailExistsException("Error al guardar");
        }
    }


    private  String cargarImg(MultipartFile file, String nombreArchivo) throws Exception{
        String fileNme = nombreArchivo;
        byte[] bytes = file.getBytes();
        String fileOriginalName = file.getOriginalFilename();
        long fileSize = file.getSize();
        long maxFileSize = 5 * 1024 * 1024;
        if (fileSize > maxFileSize) {
            throw new EmailExistsException("El tamaño no puede exceder los 5MB");
        }
        if (!fileOriginalName.endsWith(".jpg") &&
                !fileOriginalName.endsWith(".png") &&
                !fileOriginalName.endsWith(".jpeg")) {
            throw new EmailExistsException("Solo se aceptan formatos jpg, png y jpeg");
        }
        String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
        String newFileName = fileNme + fileExtension;

        // Ruta del directorio en el sistema de archivos local C:
        String localDirectoryPath = "C:/picture";

        // Asegúrate de que el directorio exista; si no, créalo
        File folder = new File(localDirectoryPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Crea la ruta completa para el nuevo archivo
        Path path = Paths.get(localDirectoryPath, newFileName);

        // Escribe los bytes en el archivo
        Files.write(path, bytes);

        return newFileName;
    }






}
