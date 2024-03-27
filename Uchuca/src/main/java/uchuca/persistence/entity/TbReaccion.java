package uchuca.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_proyecto")
public class TbReaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contador_reacciones", nullable = false)
    private Integer idContadorReacciones;
    @Column(name = "reac_total", nullable = false)
    private Integer reacTotal;
    @Column(name = "id_reacciones", nullable = false)
    private Integer idReaccion;
    @Column(name = "id_proyecto", nullable = false)
    private Integer idPoryecto;

    public Integer getIdContadorReacciones() {
        return idContadorReacciones;
    }

    public void setIdContadorReacciones(Integer idContadorReacciones) {
        this.idContadorReacciones = idContadorReacciones;
    }

    public Integer getReacTotal() {
        return reacTotal;
    }

    public void setReacTotal(Integer reacTotal) {
        this.reacTotal = reacTotal;
    }

    public Integer getIdReaccion() {
        return idReaccion;
    }

    public void setIdReaccion(Integer idReaccion) {
        this.idReaccion = idReaccion;
    }

    public Integer getIdPoryecto() {
        return idPoryecto;
    }

    public void setIdPoryecto(Integer idPoryecto) {
        this.idPoryecto = idPoryecto;
    }
}
