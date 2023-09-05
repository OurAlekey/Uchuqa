package uchuca.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name ="tb_contacato")
public class TbContacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contacto", nullable = false)
    private Integer idContacto;
    @Column(name = "con_descripcion", nullable = false)
    private String conDescripcion;
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @Column(name = "id_tipo_contacto")
    private Integer idTipoContacto;

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public String getConDescripcion() {
        return conDescripcion;
    }

    public void setConDescripcion(String conDescripcion) {
        this.conDescripcion = conDescripcion;
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
