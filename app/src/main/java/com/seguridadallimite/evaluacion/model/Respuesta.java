
package com.seguridadallimite.evaluacion.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Respuesta {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("numero")
    @Expose
    private Integer numero;
    @SerializedName("respuesta")
    @Expose
    private String respuesta;
    @SerializedName("idpregunta")
    @Expose
    private Integer idpregunta;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Respuesta() {
    }

    /**
     * 
     * @param numero
     * @param idpregunta
     * @param id
     * @param respuesta
     */
    public Respuesta(Integer id, Integer numero, String respuesta, Integer idpregunta) {
        super();
        this.id = id;
        this.numero = numero;
        this.respuesta = respuesta;
        this.idpregunta = idpregunta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Integer getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(Integer idpregunta) {
        this.idpregunta = idpregunta;
    }

}
