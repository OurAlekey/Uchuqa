package uchuca.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name= "tb_tipousuario")
public class TbTipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario", nullable = false)
    private Integer idTipoUsuario;
    @Column(name = "tus_descripcion", nullable = false)
    private String tusDescripcion;


    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTusDescripcion() {
        return tusDescripcion;
    }

    public void setTusDescripcion(String tusDescripcion) {
        this.tusDescripcion = tusDescripcion;
    }
}
