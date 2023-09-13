package uchuca.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_chat")
@Data

public class TbChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chat", nullable = false)
    private Integer idChat;

    @Column(name = "cha_descripcion", nullable = false)
    private String chatDescripcion;

    @Column(name = "cha_fecha_insercion", nullable = false)
    private Timestamp chatFecha;

    @Column(name = "proyecto_id",nullable = false)
    private Integer idProyecto;

    @Column(name = "user_id", nullable = false)
    private Integer idUsuario;


    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public String getChatDescripcion() {
        return chatDescripcion;
    }

    public void setChatDescripcion(String chatDescripcion) {
        this.chatDescripcion = chatDescripcion;
    }

    public Timestamp getChatFecha() {
        return chatFecha;
    }

    public void setChatFecha(Timestamp chatFecha) {
        this.chatFecha = chatFecha;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
