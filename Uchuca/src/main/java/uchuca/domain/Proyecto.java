package uchuca.domain;

import lombok.Data;

@Data
public class Proyecto {
    private Integer idProyecto;
    private Integer idUsuario;
    private String prNombre;
    private String prDescripcion;

    public Integer getId(){
        return idProyecto;
    }
    public void setId(Integer idProyecto){
        this.idProyecto = idProyecto;
    }

    public String getNombre(){
        return prNombre;
    }
    public void setNombre(String prNombre){
        this.prNombre = prNombre;
    }


    public String getDescripcion(){
        return prDescripcion;
    }
    public void setDescripcion(String prDescripcion){
        this.prDescripcion = prDescripcion;
    }

    public Integer getIdUsuario(){
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario){
        this.idUsuario = idUsuario;
    }
}
