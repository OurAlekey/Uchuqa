package uchuca.domain.repository;

import org.springframework.web.multipart.MultipartFile;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import uchuca.domain.Imagenes;
import uchuca.domain.Mensaje;
import uchuca.domain.Usuario;

public interface UploadFilesRep {

   Usuario cargarPortada (MultipartFile file, Long idUser) throws Exception;
   Usuario cargarPerfil (MultipartFile file, Long idUser) throws Exception;

   List<Imagenes> saveAll(List<MultipartFile> files, Long idUser) throws Exception;

}
