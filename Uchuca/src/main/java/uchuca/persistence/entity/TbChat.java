package uchuca.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_chat")
@Data

public class TbChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chat", nullable = false)
    private Integer idChat;

    @Column(name = "chat_descripcion", nullable = false)
    private String chatDescripcion;

    @Column(name = "chat_fecha", nullable = false)
    private String chatFecha;

    @Column(name = "id_Proyecto",nullable = false)
    private Integer idProyecto;

    @Column(name = "id_Usuario", nullable = false)
    private Integer idUsuario;


    public long getChatid() {
        return idChat;
    }

    public void setChatId(Integer idChat){
        this.idChat = idChat;
    }



    public String getChatDescripcion(){
        return chatDescripcion;
    }

    public void setChatdescripcion(String chatDescripcion){
        this.chatDescripcion = chatDescripcion;
    }



    public String getChatFecha() {
        return chatFecha;
    }

    public void setChatFecha(String chatfecha){
        this.chatFecha = chatfecha;
    }

    public Integer getIdProyecto(){
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto){
        this.idProyecto = idProyecto;
    }

    public Integer getIdUsuario(){
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario){
        this.idUsuario = idUsuario;
    }
}
