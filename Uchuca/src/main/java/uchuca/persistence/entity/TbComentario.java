package uchuca.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_comentarios")
@Data

public class TbComentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario", nullable = false)
    private Integer idComentario;

    @Column(name = "com_descripcion", nullable = false)
    private String comDescripcion;

    @Column(name = "com_usua_id", nullable = false)
    private Integer comUsuaId;

    @Column(name = "id_proyecto",nullable = false)
    private Integer idProyecto;

    @Column(name = "id_comentario_fk", nullable = false)
    private Integer idComentarioFk;

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getComDescripcion() {
        return comDescripcion;
    }

    public void setComDescripcion(String comDescripcion) {
        this.comDescripcion = comDescripcion;
    }

    public Integer getComUsuaId() {
        return comUsuaId;
    }

    public void setComUsuaId(Integer comUsuaId) {
        this.comUsuaId = comUsuaId;
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
