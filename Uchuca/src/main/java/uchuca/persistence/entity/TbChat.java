package uchuca.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "tb_chat")
@Data

public class TbChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chat", nullable = false)
    private Integer idChat;

    @Column(name = "proyecto_id",nullable = true)
    private Integer idProyecto;

    @Column(name = "user_id", nullable = false)
    private Integer idUsuario;
    @Column(name = "user_id2", nullable = false)
    private Integer idUsuario2;


    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private TbUser tbUser;


    @ManyToOne
    @JoinColumn(name = "user_id2",insertable = false,updatable = false)
    private TbUser tbUser2;

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
    }

    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
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

    public Integer getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(Integer idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }
}
