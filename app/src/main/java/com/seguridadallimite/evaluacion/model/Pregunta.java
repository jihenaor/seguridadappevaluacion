
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
    private Grupopregunta grupo;

    @SerializedName("idenfasis")
    @Expose
    private Enfasis idenfasis;

    @SerializedName("respuestacorrecta")
    @Expose
    private String respuestacorrecta;

    @SerializedName("idnivel")
    @Expose
    private Integer idnivel;

    @SerializedName("respuestas")
    @Expose
    private List<Respuesta> respuestas = null;

    @SerializedName("idrespuesta")
    @Expose
    private Integer idrespuesta;

    @SerializedName("idevaluacion")
    @Expose
    private Long idevaluacion;

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
    public Pregunta(Integer id, String pregunta, Integer numerorespuestacorrecta,
                    Integer orden, Grupopregunta grupo, Enfasis idenfasis, Integer idnivel,
                    List<Respuesta> respuestas, String respuestacorrecta) {
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

    public Grupopregunta getGrupo() {
        return grupo;
    }

    public Enfasis getIdenfasis() {
        return idenfasis;
    }

    public void setIdenfasis(Enfasis idenfasis) {
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

    public Long getIdevaluacion() {
        return idevaluacion;
    }

    public void setIdevaluacion(Long idevaluacion) {
        this.idevaluacion = idevaluacion;
    }
}
