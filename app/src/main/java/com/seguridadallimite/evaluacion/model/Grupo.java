
package com.seguridadallimite.evaluacion.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Grupo {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("tipoevaluacion")
    @Expose
    private String tipoevaluacion;
    @SerializedName("orden")
    @Expose
    private Integer orden;
    @SerializedName("idprograma")
    @Expose
    private Integer idprograma;
    @SerializedName("preguntas")
    @Expose
    private Object preguntas;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Grupo() {
    }

    /**
     * 
     * @param tipoevaluacion
     * @param idprograma
     * @param preguntas
     * @param id
     * @param orden
     * @param nombre
     */
    public Grupo(Integer id, String nombre, String tipoevaluacion, Integer orden, Integer idprograma, Object preguntas) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.tipoevaluacion = tipoevaluacion;
        this.orden = orden;
        this.idprograma = idprograma;
        this.preguntas = preguntas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoevaluacion() {
        return tipoevaluacion;
    }

    public void setTipoevaluacion(String tipoevaluacion) {
        this.tipoevaluacion = tipoevaluacion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getIdprograma() {
        return idprograma;
    }

    public void setIdprograma(Integer idprograma) {
        this.idprograma = idprograma;
    }

    public Object getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Object preguntas) {
        this.preguntas = preguntas;
    }

}
