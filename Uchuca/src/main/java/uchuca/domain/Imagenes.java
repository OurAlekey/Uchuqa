package uchuca.domain;

import lombok.Data;

@Data
public class Imagenes {

    private Integer id;
    private String descripcion;
    private Integer idProyecto;

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


}
