package uchuca.domain;

import lombok.Data;

@Data
public class Imagenes {

    private Integer id;
    private String descripcion;
    private Integer idProyecto;

    private Proyecto proyecto;
    private  long idUserPerfil;
    private long idUserPortada;

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
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
