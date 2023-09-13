package uchuca.persistence.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "tb_asignacionetiqueta")
@Data
public class TbAsignacionEtiquetas {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion_etiqueta", nullable = false)
    private Integer idAsignacionEtiqueta;

    @Column(name = "id_etiqueta",nullable = false)
    private Integer idEtiqueta;

    @Column(name = "id_proyecto", nullable = false)
    private Integer idProyecto;

    public Integer getIdAsignacionEtiqueta(){
        return idAsignacionEtiqueta;
    }
    public void setIdAsignacionEtiqueta(Integer idAsignacionEtiqueta){
        this.idAsignacionEtiqueta = idAsignacionEtiqueta;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(Integer idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }
}
