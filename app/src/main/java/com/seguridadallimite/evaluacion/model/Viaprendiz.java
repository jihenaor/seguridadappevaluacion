
package com.seguridadallimite.evaluacion.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Viaprendiz {

    @SerializedName("idaprendiz")
    @Expose
    private Integer idaprendiz;
    @SerializedName("numerodocumento")
    @Expose
    private String numerodocumento;
    @SerializedName("nombreaprendiz")
    @Expose
    private String nombreaprendiz;
    @SerializedName("idenfasis")
    @Expose
    private Integer idenfasis;
    @SerializedName("idgrupo")
    @Expose
    private Integer idgrupo;
    @SerializedName("idnivel")
    @Expose
    private Integer idnivel;
    @SerializedName("idempresa")
    @Expose
    private Object idempresa;

    @SerializedName("eenfasis")
    @Expose
    private Double eenfasis;

    @SerializedName("eteorica1")
    @Expose
    private Double eteorica1;

    @SerializedName("eteorica2")
    @Expose
    private Double eteorica2;

    @SerializedName("epractica")
    @Expose
    private Double epractica;

    @SerializedName("nombrenivel")
    @Expose
    private String nombrenivel;

    public Integer getIdaprendiz() {
        return idaprendiz;
    }

    public void setIdaprendiz(Integer idaprendiz) {
        this.idaprendiz = idaprendiz;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getNombreaprendiz() {
        return nombreaprendiz;
    }

    public void setNombreaprendiz(String nombreaprendiz) {
        this.nombreaprendiz = nombreaprendiz;
    }

    public Integer getIdenfasis() {
        return idenfasis;
    }

    public void setIdenfasis(Integer idenfasis) {
        this.idenfasis = idenfasis;
    }

    public Integer getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }

    public Integer getIdnivel() {
        return idnivel;
    }

    public void setIdnivel(Integer idnivel) {
        this.idnivel = idnivel;
    }

    public Object getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Object idempresa) {
        this.idempresa = idempresa;
    }

    public Double getEenfasis() {
        return eenfasis;
    }

    public void setEenfasis(Double eenfasis) {
        this.eenfasis = eenfasis;
    }

    public Double getEteorica1() {
        return eteorica1;
    }

    public void setEteorica1(Double eteorica1) {
        this.eteorica1 = eteorica1;
    }

    public Double getEteorica2() {
        return eteorica2;
    }

    public void setEteorica2(Double eteorica2) {
        this.eteorica2 = eteorica2;
    }

    public Double getEpractica() {
        return epractica;
    }

    public void setEpractica(Double epractica) {
        this.epractica = epractica;
    }

    public String getNombrenivel() {
        return nombrenivel;
    }

    public void setNombrenivel(String nombrenivel) {
        this.nombrenivel = nombrenivel;
    }

}
