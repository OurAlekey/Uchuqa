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

    @Column(name = "id_proyecto", nullable = false)
    private Integer idProyecto;

    @ManyToOne
    @JoinColumn(name = "id_proyecto",insertable = false,updatable = false)
    private TbProyecto tbProyecto;

    public TbProyecto getTbProyecto() {
        return tbProyecto;
    }

    public void setTbProyecto(TbProyecto tbProyecto) {
        this.tbProyecto = tbProyecto;
    }

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




}
