
package com.seguridadallimite.evaluacion.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestAuth {

    @SerializedName("numerodocumento")
    @Expose
    private String numerodocumento;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RequestAuth() {
    }

    /**
     * 
     * @param numerodocumento
     */
    public RequestAuth(String numerodocumento) {
        super();
        this.numerodocumento = numerodocumento;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

}
