package uchuca.domain;

import lombok.Data;

@Data
public class Imagenes {

    private Integer id;
    private String descripcion;
    private Integer idProyecto;

    private Proyecto proyecto;
    private Integer idUserPerfil;
    private Integer idUserPortada;

    public Proyecto getProyecto() {
        return proyecto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
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
}
