
package com.seguridadallimite.evaluacion.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseAuth {

    @SerializedName("numerodocumento")
    @Expose
    private String numerodocumento;

    @SerializedName("jwt")
    @Expose
    private Object jwt;

    @SerializedName("cursoRs")
    @Expose
    private Object cursoRs;

    @SerializedName("perfil")
    @Expose
    private String perfil;

    @SerializedName("aprendiz")
    @Expose
    private Aprendiz aprendiz;

    @SerializedName("personal")
    @Expose
    private Personal personal;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponseAuth() {
    }

    /**
     * 
     * @param cursoRs
     * @param jwt
     * @param numerodocumento
     * @param personal
     * @param aprendiz
     * @param perfil
     */
    public ResponseAuth(String numerodocumento, Object jwt, Object cursoRs, String perfil, Aprendiz aprendiz, Personal personal) {
        super();
        this.numerodocumento = numerodocumento;
        this.jwt = jwt;
        this.cursoRs = cursoRs;
        this.perfil = perfil;
        this.aprendiz = aprendiz;
        this.personal = personal;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public Object getJwt() {
        return jwt;
    }

    public void setJwt(Object jwt) {
        this.jwt = jwt;
    }

    public Object getCursoRs() {
        return cursoRs;
    }

    public void setCursoRs(Object cursoRs) {
        this.cursoRs = cursoRs;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
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

}
