package uchuca.persistence.entity;

import lombok.Data;
import uchuca.domain.Departamento;


import javax.persistence.*;


@Entity
@Table(name= "tb_usuario")
@Data

public class TbUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private long idUsuario;
    @Column(name = "usu_edad", nullable = false)
    private int usuEdad;
    @Column(name = "usu_email", nullable = false)
    private String usuEmail;
    @Column(name = "usu_contra", nullable = false)
    private String usoContra;
    @Column(name = "usu_nombre", nullable = false)
    private String usuNombre;
    @Column(name = "ausu_apellido", nullable = false)
    private String usuApellido;
    @Column(name = "usu_perfil", nullable = true)
    private String usuPerfil;
    @Column(name = "usu_portada", nullable = true)
    private String usuPortada;

    @Column(name = "id_departamento", nullable = false)
    private Integer idDepartamento;
    @Column(name = "id_tipo_usurio", nullable = false)
    private Integer idTipoUsuario;

    @Column(name = "id_sexo", nullable = false)
    private Integer idSexo;

    @Column(name = "usu_direccion", nullable = true)
    private String usuDireccion;
    @Column(name = "usu_descripcion", nullable = true)
    private String usuDescripcion;



    @ManyToOne
    @JoinColumn(name = "id_departamento",insertable = false,updatable = false)
    private TbDepartamento tbDepartamento;
    @ManyToOne
    @JoinColumn(name = "id_sexo",insertable = false,updatable = false)
    private TbSexo tbSexo;


    public String getUsuDescripcion() {
        return usuDescripcion;
    }

    public void setUsuDescripcion(String usuDescripcion) {
        this.usuDescripcion = usuDescripcion;
    }

    public String getUsuDireccion() {
        return usuDireccion;
    }

    public void setUsuDireccion(String usuDireccion) {
        this.usuDireccion = usuDireccion;
    }

    public TbSexo getTbSexo() {
        return tbSexo;
    }

    public void setTbSexo(TbSexo tbSexo) {
        this.tbSexo = tbSexo;
    }

    public TbDepartamento getTbDepartamento() {
        return tbDepartamento;
    }

    public void setTbDepartamento(TbDepartamento tbDepartamento) {
        this.tbDepartamento = tbDepartamento;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getUsuEdad() {
        return usuEdad;
    }

    public void setUsuEdad(int usuEdad) {
        this.usuEdad = usuEdad;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public String getUsoContra() {
        return usoContra;
    }

    public void setUsoContra(String usoContra) {
        this.usoContra = usoContra;
    }

    public String getUsuNombre() {
        return usuNombre;
    }

    public void setUsuNombre(String usuNombre) {
        this.usuNombre = usuNombre;
    }

    public String getUsuApellido() {
        return usuApellido;
    }

    public void setUsuApellido(String usuApellido) {
        this.usuApellido = usuApellido;
    }

    public String getUsuPerfil() {
        return usuPerfil;
    }

    public void setUsuPerfil(String usuPerfil) {
        this.usuPerfil = usuPerfil;
    }

    public String getUsuPortada() {
        return usuPortada;
    }

    public void setUsuPortada(String usuPortada) {
        this.usuPortada = usuPortada;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }
}
