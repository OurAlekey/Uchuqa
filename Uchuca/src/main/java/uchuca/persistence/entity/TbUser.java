package uchuca.persistence.entity;

import lombok.Data;
import uchuca.domain.Departamento;


import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name= "tb_usuario")

public class TbUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private long idUsuario;
    @Column(name = "usu_fecha_nacimiento", nullable = false)
    private Date usuFechaNacimiento;
    @Column(name = "usu_email", nullable = false)
    private String usuEmail;
    @Column(name = "usu_contra", nullable = false)
    private String usoContra;
    @Column(name = "usu_nombre", nullable = false)
    private String usuNombre;
    @Column(name = "ausu_apellido", nullable = false)
    private String usuApellido;
    @Column(name = "id_municipio", nullable = false)
    private Integer idMunicipio;
    @Column(name = "id_tipo_usurio", nullable = false)
    private Integer idTipoUsuario;

    @Column(name = "id_sexo", nullable = false)
    private Integer idSexo;

    @Column(name = "usu_descripcion", nullable = true)
    private String usuDescripcion;
    @Column(name = "usu_direccion", nullable = true)
    private String usuDireccion;
    @Column(name = "perfil", nullable = true)
    private String perfil;
    @Column(name = "portada", nullable = true)
    private String portada;
    @ManyToOne
    @JoinColumn(name = "id_municipio",insertable = false,updatable = false)
    private TbMunicipio tbMunicipio;
    @ManyToOne
    @JoinColumn(name = "id_sexo",insertable = false,updatable = false)
    private TbSexo tbSexo;

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getUsuFechaNacimiento() {
        return usuFechaNacimiento;
    }

    public void setUsuFechaNacimiento(Date usuFechaNacimiento) {
        this.usuFechaNacimiento = usuFechaNacimiento;
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

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
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

    public TbMunicipio getTbMunicipio() {
        return tbMunicipio;
    }

    public void setTbMunicipio(TbMunicipio tbMunicipio) {
        this.tbMunicipio = tbMunicipio;
    }

    public TbSexo getTbSexo() {
        return tbSexo;
    }

    public void setTbSexo(TbSexo tbSexo) {
        this.tbSexo = tbSexo;
    }
}
