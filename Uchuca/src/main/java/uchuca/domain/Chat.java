package uchuca.domain;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;


@Data
public class Chat {


    private Integer id;


    private Integer idProyecto;

    private Integer idUsuario;

    private Integer idUsuario2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

