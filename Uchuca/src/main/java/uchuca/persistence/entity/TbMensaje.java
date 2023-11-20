package uchuca.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_mensajes")
public class TbMensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensaje", nullable = false)
    private Integer idMensaje;

    @Column(name = "id_chat", nullable = true)
    private Integer idChat;
    @Column(name = "men_mensaje", nullable = true)
    private String menMensjae;
    @Column(name = "id_usuario", nullable = true)
    private Integer idUsuario;
    @Column(name = "men_fecha_insercion", nullable = false)
    private  Timestamp menFechaInsercion;

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public String getMenMensjae() {
        return menMensjae;
    }

    public void setMenMensjae(String menMensjae) {
        this.menMensjae = menMensjae;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Timestamp getMenFechaInsercion() {
        return menFechaInsercion;
    }

    public void setMenFechaInsercion(Timestamp menFechaInsercion) {
        this.menFechaInsercion = menFechaInsercion;
    }
}
