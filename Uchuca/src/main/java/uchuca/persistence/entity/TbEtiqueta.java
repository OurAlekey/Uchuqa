package uchuca.persistence.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "tb_etiqueta")
@Data

public class TbEtiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etiqueta", nullable = false)
    private Integer idEtiqueta;

    @Column(name = "eti_descripcion",nullable = false)
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

    public void setImaDescripcion(String etiDescripcion){
        this.etiDescripcion = etiDescripcion;
    }
}
