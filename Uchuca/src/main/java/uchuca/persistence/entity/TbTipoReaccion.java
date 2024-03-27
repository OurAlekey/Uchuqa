package uchuca.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_tipo_reacciones")
public class TbTipoReaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reacciones", nullable = false)
    private Integer idReaccion;
    @Column(name = "tip_descripcion", nullable = false)
    private String tipDescripcion;

    public Integer getIdReaccion() {
        return idReaccion;
    }

    public void setIdReaccion(Integer idReaccion) {
        this.idReaccion = idReaccion;
    }

    public String getTipDescripcion() {
        return tipDescripcion;
    }

    public void setTipDescripcion(String tipDescripcion) {
        this.tipDescripcion = tipDescripcion;
    }
}
