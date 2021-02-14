
package com.seguridadallimite.evaluacion.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseAuth {

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("role")
    @Expose
    private String role;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("numerodocumento")
    @Expose
    private String numerodocumento;

    @SerializedName("nombreusuario")
    @Expose
    private String nombreusuario;

    @SerializedName("tienepassword")
    @Expose
    private String tienepassword;

    @SerializedName("cursoRs")
    @Expose
    private Object cursoRs;

    @SerializedName("aprendiz")
    @Expose
    private Aprendiz aprendiz;

    @SerializedName("idaprendiz")
    @Expose
    private Long idaprendiz;

    @SerializedName("idinstructor")
    @Expose
    private String idinstructor;

    @SerializedName("personal")
    @Expose
    private Personal personal;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponseAuth() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getTienepassword() {
        return tienepassword;
    }

    public void setTienepassword(String tienepassword) {
        this.tienepassword = tienepassword;
    }

    public Object getCursoRs() {
        return cursoRs;
    }

    public void setCursoRs(Object cursoRs) {
        this.cursoRs = cursoRs;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(Aprendiz aprendiz) {
        this.aprendiz = aprendiz;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Long getIdaprendiz() {
        return idaprendiz;
    }

    public void setIdaprendiz(Long idaprendiz) {
        this.idaprendiz = idaprendiz;
    }

    public String getIdinstructor() {
        return idinstructor;
    }
}
