package uchuca.persistence.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name= "imagenes")
@Data

public class TbImagenes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen", nullable = false)
    private Integer idImagen;

    @Column(name = "ima_descripcion", nullable = false)
    private String imaDescripcion;

    @Column(name = "id_proyecto", nullable = true)
    private Integer idProyecto;

    @Column(name = "id_user_perfil", nullable = true)
    private long idUserPerfil;

    @Column(name = "id_user_portada", nullable = true)
    private long idUserPortada;

    public Integer getIdImagen(){
        return idImagen;
    }

    public void setIdImagen(Integer idImagen){
        this.idImagen = idImagen;
    }

    public String getImaDescripcion(){
        return imaDescripcion;
    }

    public void setImaDescripcion(String imaDescripcion){
        this.imaDescripcion = imaDescripcion;
    }

    public Integer getIdProyecto(){
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto){
        this.idProyecto = idProyecto;
    }

    public long getIdUserPerfil() {
        return idUserPerfil;
    }

    public void setIdUserPerfil(long idUserPerfil) {
        this.idUserPerfil = idUserPerfil;
    }

    public long getIdUserPortada() {
        return idUserPortada;
    }

    public void setIdUserPortada(long idUserPortada) {
        this.idUserPortada = idUserPortada;
    }
}
