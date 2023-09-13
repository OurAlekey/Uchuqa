package uchuca.domain;

public class Comentario {
    private Integer id;
    private String descripcion;
    private  Integer usuaId;
    private Integer idProyecto;
    private Integer idComentarioFk;

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

    public Integer getUsuaId() {
        return usuaId;
    }

    public void setUsuaId(Integer usuaId) {
        this.usuaId = usuaId;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getIdComentarioFk() {
        return idComentarioFk;
    }

    public void setIdComentarioFk(Integer idComentarioFk) {
        this.idComentarioFk = idComentarioFk;
    }
}
