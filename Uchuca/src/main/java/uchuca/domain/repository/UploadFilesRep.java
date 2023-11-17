package uchuca.domain.repository;

import org.springframework.web.multipart.MultipartFile;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import uchuca.domain.Usuario;

public interface UploadFilesRep {

   Usuario cargarPortada (MultipartFile file, Long idUser) throws Exception;
   Usuario cargarPerfil (MultipartFile file, Long idUser) throws Exception;

}
