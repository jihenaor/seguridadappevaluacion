
package com.seguridadallimite.evaluacion.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Personal {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tipodocumento")
    @Expose
    private String tipodocumento;
    @SerializedName("numerodocumento")
    @Expose
    private String numerodocumento;
    @SerializedName("nombrecompleto")
    @Expose
    private String nombrecompleto;
    @SerializedName("entrenador")
    @Expose
    private String entrenador;
    @SerializedName("supervisor")
    @Expose
    private String supervisor;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Personal() {
    }

    /**
     * 
     * @param entrenador
     * @param numerodocumento
     * @param nombrecompleto
     * @param id
     * @param supervisor
     * @param tipodocumento
     */
    public Personal(Integer id, String tipodocumento, String numerodocumento, String nombrecompleto, String entrenador, String supervisor) {
        super();
        this.id = id;
        this.tipodocumento = tipodocumento;
        this.numerodocumento = numerodocumento;
        this.nombrecompleto = nombrecompleto;
        this.entrenador = entrenador;
        this.supervisor = supervisor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

}
