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
    private Integer idUserPerfil;

    @Column(name = "id_user_portada", nullable = true)
    private Integer idUserPortada;

    @ManyToOne
    @JoinColumn(name = "id_proyecto",insertable = false,updatable = false)
    private TbProyecto tbProyecto;

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public String getImaDescripcion() {
        return imaDescripcion;
    }

    public void setImaDescripcion(String imaDescripcion) {
        this.imaDescripcion = imaDescripcion;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getIdUserPerfil() {
        return idUserPerfil;
    }

    public void setIdUserPerfil(Integer idUserPerfil) {
        this.idUserPerfil = idUserPerfil;
    }

    public Integer getIdUserPortada() {
        return idUserPortada;
    }

    public void setIdUserPortada(Integer idUserPortada) {
        this.idUserPortada = idUserPortada;
    }

    public TbProyecto getTbProyecto() {
        return tbProyecto;
    }

    public void setTbProyecto(TbProyecto tbProyecto) {
        this.tbProyecto = tbProyecto;
    }
}
