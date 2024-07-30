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

   Imagenes cargarPortada (MultipartFile file, Integer idUser) throws Exception;
   Imagenes cargarPerfil (MultipartFile file, Integer idUser) throws Exception;

   List<Imagenes> saveAll(List<MultipartFile> files, Integer idUser) throws Exception;

}
