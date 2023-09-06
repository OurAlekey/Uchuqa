package uchuca.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_departamento")
public class TbDepartamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento", nullable = false)
    private Integer idDepartamento;
    @Column(name = "dep_descripcion", nullable = false)
    private String depDescripcion;

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDepDescripcion() {
        return depDescripcion;
    }

    public void setDepDescripcion(String depDescripcion) {
        this.depDescripcion = depDescripcion;
    }
}
