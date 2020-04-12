
package com.seguridadallimite.evaluacion.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Aprendiz {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("fechaverificacion")
    @Expose
    private Object fechaverificacion;
    @SerializedName("codigoverificacion")
    @Expose
    private Object codigoverificacion;
    @SerializedName("pagocurso")
    @Expose
    private String pagocurso;
    @SerializedName("evaluacionformacion")
    @Expose
    private Double evaluacionformacion;
    @SerializedName("evaluacionentrenamiento")
    @Expose
    private Double evaluacionentrenamiento;
    @SerializedName("cumplehoras")
    @Expose
    private String cumplehoras;
    @SerializedName("createAt")
    @Expose
    private String createAt;
    @SerializedName("updateAt")
    @Expose
    private String updateAt;
    @SerializedName("idenfasis")
    @Expose
    private Integer idenfasis;
    @SerializedName("idgrupo")
    @Expose
    private Integer idgrupo;
    @SerializedName("idempresa")
    @Expose
    private Integer idempresa;
    @SerializedName("trabajador")
    @Expose
    private Trabajador trabajador;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Aprendiz() {
    }

    /**
     * 
     * @param idenfasis
     * @param updateAt
     * @param createAt
     * @param codigoverificacion
     * @param trabajador
     * @param idempresa
     * @param evaluacionformacion
     * @param id
     * @param fechaverificacion
     * @param pagocurso
     * @param idgrupo
     * @param evaluacionentrenamiento
     * @param cumplehoras
     */
    public Aprendiz(Integer id, Object fechaverificacion, Object codigoverificacion, String pagocurso, Double evaluacionformacion, Double evaluacionentrenamiento, String cumplehoras, String createAt, String updateAt, Integer idenfasis, Integer idgrupo, Integer idempresa, Trabajador trabajador) {
        super();
        this.id = id;
        this.fechaverificacion = fechaverificacion;
        this.codigoverificacion = codigoverificacion;
        this.pagocurso = pagocurso;
        this.evaluacionformacion = evaluacionformacion;
        this.evaluacionentrenamiento = evaluacionentrenamiento;
        this.cumplehoras = cumplehoras;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.idenfasis = idenfasis;
        this.idgrupo = idgrupo;
        this.idempresa = idempresa;
        this.trabajador = trabajador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getFechaverificacion() {
        return fechaverificacion;
    }

    public void setFechaverificacion(Object fechaverificacion) {
        this.fechaverificacion = fechaverificacion;
    }

    public Object getCodigoverificacion() {
        return codigoverificacion;
    }

    public void setCodigoverificacion(Object codigoverificacion) {
        this.codigoverificacion = codigoverificacion;
    }

    public String getPagocurso() {
        return pagocurso;
    }

    public void setPagocurso(String pagocurso) {
        this.pagocurso = pagocurso;
    }

    public Double getEvaluacionformacion() {
        return evaluacionformacion;
    }

    public void setEvaluacionformacion(Double evaluacionformacion) {
        this.evaluacionformacion = evaluacionformacion;
    }

    public Double getEvaluacionentrenamiento() {
        return evaluacionentrenamiento;
    }

    public void setEvaluacionentrenamiento(Double evaluacionentrenamiento) {
        this.evaluacionentrenamiento = evaluacionentrenamiento;
    }

    public String getCumplehoras() {
        return cumplehoras;
    }

    public void setCumplehoras(String cumplehoras) {
        this.cumplehoras = cumplehoras;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
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

    public Integer getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

}
