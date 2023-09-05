package uchuca.domain;

public class Contacto {

    private Integer id;
    private String descripcion;
    private Integer usuarioId;
    private Integer idTipoContacto;

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

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getIdTipoContacto() {
        return idTipoContacto;
    }

    public void setIdTipoContacto(Integer idTipoContacto) {
        this.idTipoContacto = idTipoContacto;
    }
}
