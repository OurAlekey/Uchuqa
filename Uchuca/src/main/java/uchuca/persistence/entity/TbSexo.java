package uchuca.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name= "tb_sexo")
public class TbSexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sexo", nullable = false)
    private  Integer idSexo;


    @Column(name = "sex_descripcion", nullable = false)
    private String sexDescripcion;

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public String getSexDescripcion() {
        return sexDescripcion;
    }

    public void setSexDescripcion(String sexDescripcion) {
        this.sexDescripcion = sexDescripcion;
    }
}
