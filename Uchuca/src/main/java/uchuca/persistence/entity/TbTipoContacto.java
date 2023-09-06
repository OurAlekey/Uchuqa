package uchuca.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_tipo_contacto")
public class TbTipoContacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_contacto", nullable = false)
    private Integer idTipoContacto;
    @Column(name = "tco_descripcion", nullable = false)
    private String tcoDescripcion;

    public Integer getIdTipoContacto() {
        return idTipoContacto;
    }

    public void setIdTipoContacto(Integer idTipoContacto) {
        this.idTipoContacto = idTipoContacto;
    }

    public String getTcoDescripcion() {
        return tcoDescripcion;
    }

    public void setTcoDescripcion(String tcoDescripcion) {
        this.tcoDescripcion = tcoDescripcion;
    }
}
