package uchuca.persistence.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_proyecto")
@Data
public class TbProyecto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto", nullable = false)
    private Integer idProyecto;

    @Column(name = "pro_nombre", nullable = false)
    private String prNombre;

    @Column(name = "pro_descripcion", nullable = false)
    private String prDescripcion;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;



    @OneToMany(mappedBy = "tbProyecto", cascade = CascadeType.ALL)
    List<TbImagenes> imagenes;


    public List<TbImagenes> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<TbImagenes> imagenes) {
        this.imagenes = imagenes;
    }

    public Integer getIdProyecto(){
        return idProyecto;
    }
    public void setIdProyecto(Integer idProyecto){
        this.idProyecto = idProyecto;
    }

    public String getPrNombre(){
        return prNombre;
    }
    public void setPrNombre(String prNombre){
        this.prNombre = prNombre;
    }

    public String getPrDescripcion(){
        return prDescripcion;
    }
    public void setPrDescripcion(String prDescripcion){
        this.prDescripcion = prDescripcion;
    }


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
