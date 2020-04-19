
package com.seguridadallimite.evaluacion.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pregunta {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("pregunta")
    @Expose
    private String pregunta;
    @SerializedName("numerorespuestacorrecta")
    @Expose
    private Integer numerorespuestacorrecta;
    @SerializedName("orden")
    @Expose
    private Integer orden;
    @SerializedName("grupo")
    @Expose
    private Grupo grupo;

    @SerializedName("idenfasis")
    @Expose
    private Object idenfasis;

    @SerializedName("respuestacorrecta")
    @Expose
    private String respuestacorrecta;

    @SerializedName("idnivel")
    @Expose
    private Integer idnivel;
    @SerializedName("respuestas")
    @Expose
    private List<Respuesta> respuestas = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pregunta() {
    }

    /**
     * 
     * @param idenfasis
     * @param respuestas
     * @param idnivel
     * @param numerorespuestacorrecta
     * @param grupo
     * @param id
     * @param orden
     * @param pregunta
     * @param respuestacorrecta
     */
    public Pregunta(Integer id, String pregunta, Integer numerorespuestacorrecta, Integer orden, Grupo grupo, Object idenfasis, Integer idnivel, List<Respuesta> respuestas, String respuestacorrecta) {
        super();
        this.id = id;
        this.pregunta = pregunta;
        this.numerorespuestacorrecta = numerorespuestacorrecta;
        this.orden = orden;
        this.grupo = grupo;
        this.idenfasis = idenfasis;
        this.idnivel = idnivel;
        this.respuestas = respuestas;
        this.respuestacorrecta = respuestacorrecta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Integer getNumerorespuestacorrecta() {
        return numerorespuestacorrecta;
    }

    public void setNumerorespuestacorrecta(Integer numerorespuestacorrecta) {
        this.numerorespuestacorrecta = numerorespuestacorrecta;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Object getIdenfasis() {
        return idenfasis;
    }

    public void setIdenfasis(Object idenfasis) {
        this.idenfasis = idenfasis;
    }

    public Integer getIdnivel() {
        return idnivel;
    }

    public void setIdnivel(Integer idnivel) {
        this.idnivel = idnivel;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public String getRespuestacorrecta() {
        return respuestacorrecta;
    }

    public void setRespuestacorrecta(String respuestacorrecta) {
        this.respuestacorrecta = respuestacorrecta;
    }
}
