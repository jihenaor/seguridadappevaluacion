
package com.seguridadallimite.evaluacion.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Grupo {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("idnivel")
    @Expose
    private Long idnivel;

    @SerializedName("fechainicio")
    @Expose
    private String fechainicio;

    @SerializedName("fechafinal")
    @Expose
    private String fechafinal;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Grupo() {
    }

    public Grupo(Long id, Long idnivel, String fechainicio, String fechafinal) {
        this.id = id;
        this.idnivel = idnivel;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdnivel() {
        return idnivel;
    }

    public void setIdnivel(Long idnivel) {
        this.idnivel = idnivel;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }
}
