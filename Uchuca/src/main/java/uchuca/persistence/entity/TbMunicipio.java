package uchuca.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "tb_municipio")

public class TbMunicipio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_municipio", nullable = false)
    private Integer idMunicipio;

    @Column(name = "mun_descripcion", nullable = false)
    private String   munDescripcion;
    @Column(name = "id_departamento", nullable = false)
    private Integer idDepartamento;


    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getMunDescripcion() {
        return munDescripcion;
    }

    public void setMunDescripcion(String munDescripcion) {
        this.munDescripcion = munDescripcion;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}
