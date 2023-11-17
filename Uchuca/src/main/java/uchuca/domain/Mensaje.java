package uchuca.domain;

import java.sql.Timestamp;

public class Mensaje {

    private Integer id;
    private  Integer idChat;

    private String mensaje;
    private  Integer idUsuario;
    private Timestamp fechaInsercion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Timestamp getFechaInsercion() {
        return fechaInsercion;
    }

    public void setFechaInsercion(Timestamp fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }
}
