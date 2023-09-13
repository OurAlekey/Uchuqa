package uchuca.domain;

import lombok.Data;

@Data
public class AsignacionEtiquetas {

    private Integer id;
    private Integer idEtiqueta;
    private Integer idProyecto;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getIdEtiqueta(){
        return idEtiqueta;

    }
    public void setIdEtiqueta(Integer idEtiqueta){
        this.idEtiqueta = idEtiqueta;
    }

    public Integer getIdProyecto(){
        return idProyecto;
    }
    public void setIdProyecto(Integer idProyecto){
        this.idProyecto = idProyecto;
    }
}
