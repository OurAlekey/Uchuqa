package uchuca.domain;

import lombok.Data;

import java.util.List;

@Data
public class Proyecto {
    private Integer id;

    private String nombre;
    private String descripcion;
    private Integer idUsuario;
    private List<Imagenes> imagenes;
    private  Usuario usuario;

    private Double precio;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Imagenes> getImagenes() {
        return imagenes;
    }


    public void setImagenes(List<Imagenes> imagenes) {
        this.imagenes = imagenes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdUsuario(){
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario){
        this.idUsuario = idUsuario;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
