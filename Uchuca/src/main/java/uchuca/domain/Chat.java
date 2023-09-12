package uchuca.domain;

import lombok.Data;

@Data
public class Chat {


    private Integer idChat;

    private String chatDescripcion;

    private String chatFecha;

    private Integer idUsuario;

    private Integer idProyecto;

    public Integer getChatid() {
        return idChat;
    }

    public void setChatid(int id) {
        this.idChat = id;
    }

    public String getDescripcion(){
        return chatDescripcion;
    }

    public void setDescripcion(String descripcion) {
        this.chatDescripcion = descripcion;
    }

    public String getFecha(){
        return chatFecha;
    }

    public void setFecha(String fecha) {
        this.chatFecha = fecha;
    }


    public Integer getIdUsuario(){
        return idUsuario;
    }
    public void setIdUsuario(int idUs){
        this.idUsuario = idUs;
    }

    public Integer getIdProyecto(){
        return idProyecto;
    }
    public void setIdProyecto(int idprj){
        this.idProyecto = idprj;
    }
}

