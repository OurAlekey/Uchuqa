package uchuca.domain.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uchuca.domain.Usuario;
import uchuca.domain.repository.UploadFilesRep;
import uchuca.exeptions.EmailExistsException;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
public class UploadFilesServices implements UploadFilesRep {

    @Autowired
    UsuarioService usuerService;
    @Override
    public Usuario cargarPortada(MultipartFile file,Long idUser) throws Exception {
        try {

            Optional<Usuario> usuario = usuerService.getId( idUser);
            String  newFileName =  cargarImg(file,usuario.get().getNombre()+"Portada");
                usuario.get().setPortada(newFileName);
            return  usuerService.save(usuario.get());
        }catch (Exception e){
            throw new EmailExistsException("Ocurrio un error");
        }
    }

    @Override
    public Usuario cargarPerfil(MultipartFile file, Long idUser) throws Exception {
        try {

            Optional<Usuario> usuario = usuerService.getId( idUser);
            String  newFileName =  cargarImg(file,usuario.get().getNombre()+"Perfil");
            usuario.get().setPerfil(newFileName);

            return  usuerService.save(usuario.get());
        }catch (Exception e){
            throw new EmailExistsException("El correo electronico ya existe");
        }
    }


    private  String cargarImg(MultipartFile file, String nombreArchivo) throws Exception{
        String fileNme = nombreArchivo;
        byte[] bytes = file.getBytes();
        String fileOriginalName = file.getOriginalFilename();
        long fileSize = file.getSize();
        long maxFileSize = 5*1024*1024;
        if(fileSize > maxFileSize){
            throw new EmailExistsException("El tamaño no puede exceder los 5MB");

        }
        if(!fileOriginalName.endsWith(".jpg") &&
                !fileOriginalName.endsWith(".png")&&
                !fileOriginalName.endsWith(".jpeg")){
            throw new EmailExistsException("Solo se acpetan formatos jpg, png y jpeg");

        }
        String fileExtencion = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
        String newFileName = fileNme + fileExtencion;
        File folder = new File("src/main/picture");
        if(!folder.exists()){
            folder.mkdirs();
        }
        Path path = Paths.get("src/main/picture/" + newFileName);
        Files.write(path,bytes);

        return newFileName;
    }






}
