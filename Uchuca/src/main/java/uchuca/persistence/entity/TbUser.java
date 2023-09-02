package uchuca.persistence.entity;

import lombok.Data;


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
    @Column(name = "usu_perfil", nullable = false)
    private String usuPerfil;
    @Column(name = "usu_portada", nullable = false)
    private String usuPortada;

    @Column(name = "id_departamento", nullable = false)
    private Integer idDepartamento;
    @Column(name = "id_tipo_usurio", nullable = false)
    private Integer idTipoUsuario;

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


}
