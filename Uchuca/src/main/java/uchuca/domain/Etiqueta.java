package uchuca.domain;

import lombok.Data;

@Data

public class Etiqueta {
    private Integer idEtiqueta;
    private String etiDescripcion;

    public Integer getIdEtiqueta(){
        return idEtiqueta;
    }

    public void setIdEtiqueta(Integer idEtiqueta){
        this.idEtiqueta = idEtiqueta;
    }

    public String getEtiDescripcion(){
        return etiDescripcion;
    }

    public void setEtiDescripcion(){
        this.idEtiqueta = idEtiqueta;
    }
}
