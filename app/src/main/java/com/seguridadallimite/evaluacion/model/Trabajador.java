
package com.seguridadallimite.evaluacion.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trabajador {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tipodocumento")
    @Expose
    private String tipodocumento;
    @SerializedName("numerodocumento")
    @Expose
    private String numerodocumento;
    @SerializedName("primernombre")
    @Expose
    private String primernombre;
    @SerializedName("segundonombre")
    @Expose
    private String segundonombre;
    @SerializedName("primerapellido")
    @Expose
    private String primerapellido;
    @SerializedName("segundoapellido")
    @Expose
    private Object segundoapellido;
    @SerializedName("nombrecompleto")
    @Expose
    private String nombrecompleto;
    @SerializedName("areatrabajo")
    @Expose
    private String areatrabajo;
    @SerializedName("niveleducativo")
    @Expose
    private String niveleducativo;
    @SerializedName("cargoactual")
    @Expose
    private String cargoactual;
    @SerializedName("genero")
    @Expose
    private String genero;
    @SerializedName("nacionalidad")
    @Expose
    private String nacionalidad;
    @SerializedName("fechanacimiento")
    @Expose
    private String fechanacimiento;
    @SerializedName("lugarexpedicion")
    @Expose
    private String lugarexpedicion;
    @SerializedName("fechaexpedicion")
    @Expose
    private String fechaexpedicion;
    @SerializedName("departamentonacimiento")
    @Expose
    private String departamentonacimiento;
    @SerializedName("ciudadnacimiento")
    @Expose
    private String ciudadnacimiento;
    @SerializedName("tiposangre")
    @Expose
    private String tiposangre;
    @SerializedName("ocupacion")
    @Expose
    private String ocupacion;
    @SerializedName("departamentodomicilio")
    @Expose
    private String departamentodomicilio;
    @SerializedName("ciudaddomicilio")
    @Expose
    private String ciudaddomicilio;
    @SerializedName("direcciondomicilio")
    @Expose
    private String direcciondomicilio;
    @SerializedName("celular")
    @Expose
    private String celular;
    @SerializedName("correoelectronico")
    @Expose
    private String correoelectronico;
    @SerializedName("ideps")
    @Expose
    private Integer ideps;
    @SerializedName("sabeleerescribir")
    @Expose
    private String sabeleerescribir;
    @SerializedName("tiempotrabajoalturas")
    @Expose
    private String tiempotrabajoalturas;
    @SerializedName("labordesarrolla")
    @Expose
    private String labordesarrolla;
    @SerializedName("siso")
    @Expose
    private String siso;
    @SerializedName("alergias")
    @Expose
    private String alergias;
    @SerializedName("medicamentos")
    @Expose
    private String medicamentos;
    @SerializedName("enfermedades")
    @Expose
    private String enfermedades;
    @SerializedName("lesiones")
    @Expose
    private String lesiones;
    @SerializedName("nombrecontacto")
    @Expose
    private String nombrecontacto;
    @SerializedName("telefonocontacto")
    @Expose
    private String telefonocontacto;
    @SerializedName("parentescocontacto")
    @Expose
    private String parentescocontacto;
    @SerializedName("createAt")
    @Expose
    private String createAt;
    @SerializedName("updateAt")
    @Expose
    private String updateAt;
    @SerializedName("base64")
    @Expose
    private Object base64;
    @SerializedName("documentotrabajadors")
    @Expose
    private Object documentotrabajadors;
    @SerializedName("aprendiz")
    @Expose
    private Object aprendiz;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Trabajador() {
    }

    /**
     * 
     * @param fechaexpedicion
     * @param telefonocontacto
     * @param siso
     * @param base64
     * @param nombrecompleto
     * @param updateAt
     * @param ocupacion
     * @param correoelectronico
     * @param niveleducativo
     * @param medicamentos
     * @param createAt
     * @param nacionalidad
     * @param cargoactual
     * @param departamentodomicilio
     * @param lesiones
     * @param genero
     * @param tiposangre
     * @param celular
     * @param sabeleerescribir
     * @param id
     * @param ideps
     * @param direcciondomicilio
     * @param aprendiz
     * @param tipodocumento
     * @param enfermedades
     * @param departamentonacimiento
     * @param tiempotrabajoalturas
     * @param labordesarrolla
     * @param parentescocontacto
     * @param primernombre
     * @param numerodocumento
     * @param primerapellido
     * @param ciudaddomicilio
     * @param lugarexpedicion
     * @param alergias
     * @param documentotrabajadors
     * @param segundoapellido
     * @param areatrabajo
     * @param fechanacimiento
     * @param nombrecontacto
     * @param segundonombre
     * @param ciudadnacimiento
     */
    public Trabajador(Integer id, String tipodocumento, String numerodocumento, String primernombre, String segundonombre, String primerapellido, Object segundoapellido, String nombrecompleto, String areatrabajo, String niveleducativo, String cargoactual, String genero, String nacionalidad, String fechanacimiento, String lugarexpedicion, String fechaexpedicion, String departamentonacimiento, String ciudadnacimiento, String tiposangre, String ocupacion, String departamentodomicilio, String ciudaddomicilio, String direcciondomicilio, String celular, String correoelectronico, Integer ideps, String sabeleerescribir, String tiempotrabajoalturas, String labordesarrolla, String siso, String alergias, String medicamentos, String enfermedades, String lesiones, String nombrecontacto, String telefonocontacto, String parentescocontacto, String createAt, String updateAt, Object base64, Object documentotrabajadors, Object aprendiz) {
        super();
        this.id = id;
        this.tipodocumento = tipodocumento;
        this.numerodocumento = numerodocumento;
        this.primernombre = primernombre;
        this.segundonombre = segundonombre;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.nombrecompleto = nombrecompleto;
        this.areatrabajo = areatrabajo;
        this.niveleducativo = niveleducativo;
        this.cargoactual = cargoactual;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.fechanacimiento = fechanacimiento;
        this.lugarexpedicion = lugarexpedicion;
        this.fechaexpedicion = fechaexpedicion;
        this.departamentonacimiento = departamentonacimiento;
        this.ciudadnacimiento = ciudadnacimiento;
        this.tiposangre = tiposangre;
        this.ocupacion = ocupacion;
        this.departamentodomicilio = departamentodomicilio;
        this.ciudaddomicilio = ciudaddomicilio;
        this.direcciondomicilio = direcciondomicilio;
        this.celular = celular;
        this.correoelectronico = correoelectronico;
        this.ideps = ideps;
        this.sabeleerescribir = sabeleerescribir;
        this.tiempotrabajoalturas = tiempotrabajoalturas;
        this.labordesarrolla = labordesarrolla;
        this.siso = siso;
        this.alergias = alergias;
        this.medicamentos = medicamentos;
        this.enfermedades = enfermedades;
        this.lesiones = lesiones;
        this.nombrecontacto = nombrecontacto;
        this.telefonocontacto = telefonocontacto;
        this.parentescocontacto = parentescocontacto;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.base64 = base64;
        this.documentotrabajadors = documentotrabajadors;
        this.aprendiz = aprendiz;
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

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public Object getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(Object segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getAreatrabajo() {
        return areatrabajo;
    }

    public void setAreatrabajo(String areatrabajo) {
        this.areatrabajo = areatrabajo;
    }

    public String getNiveleducativo() {
        return niveleducativo;
    }

    public void setNiveleducativo(String niveleducativo) {
        this.niveleducativo = niveleducativo;
    }

    public String getCargoactual() {
        return cargoactual;
    }

    public void setCargoactual(String cargoactual) {
        this.cargoactual = cargoactual;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getLugarexpedicion() {
        return lugarexpedicion;
    }

    public void setLugarexpedicion(String lugarexpedicion) {
        this.lugarexpedicion = lugarexpedicion;
    }

    public String getFechaexpedicion() {
        return fechaexpedicion;
    }

    public void setFechaexpedicion(String fechaexpedicion) {
        this.fechaexpedicion = fechaexpedicion;
    }

    public String getDepartamentonacimiento() {
        return departamentonacimiento;
    }

    public void setDepartamentonacimiento(String departamentonacimiento) {
        this.departamentonacimiento = departamentonacimiento;
    }

    public String getCiudadnacimiento() {
        return ciudadnacimiento;
    }

    public void setCiudadnacimiento(String ciudadnacimiento) {
        this.ciudadnacimiento = ciudadnacimiento;
    }

    public String getTiposangre() {
        return tiposangre;
    }

    public void setTiposangre(String tiposangre) {
        this.tiposangre = tiposangre;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDepartamentodomicilio() {
        return departamentodomicilio;
    }

    public void setDepartamentodomicilio(String departamentodomicilio) {
        this.departamentodomicilio = departamentodomicilio;
    }

    public String getCiudaddomicilio() {
        return ciudaddomicilio;
    }

    public void setCiudaddomicilio(String ciudaddomicilio) {
        this.ciudaddomicilio = ciudaddomicilio;
    }

    public String getDirecciondomicilio() {
        return direcciondomicilio;
    }

    public void setDirecciondomicilio(String direcciondomicilio) {
        this.direcciondomicilio = direcciondomicilio;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public Integer getIdeps() {
        return ideps;
    }

    public void setIdeps(Integer ideps) {
        this.ideps = ideps;
    }

    public String getSabeleerescribir() {
        return sabeleerescribir;
    }

    public void setSabeleerescribir(String sabeleerescribir) {
        this.sabeleerescribir = sabeleerescribir;
    }

    public String getTiempotrabajoalturas() {
        return tiempotrabajoalturas;
    }

    public void setTiempotrabajoalturas(String tiempotrabajoalturas) {
        this.tiempotrabajoalturas = tiempotrabajoalturas;
    }

    public String getLabordesarrolla() {
        return labordesarrolla;
    }

    public void setLabordesarrolla(String labordesarrolla) {
        this.labordesarrolla = labordesarrolla;
    }

    public String getSiso() {
        return siso;
    }

    public void setSiso(String siso) {
        this.siso = siso;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getLesiones() {
        return lesiones;
    }

    public void setLesiones(String lesiones) {
        this.lesiones = lesiones;
    }

    public String getNombrecontacto() {
        return nombrecontacto;
    }

    public void setNombrecontacto(String nombrecontacto) {
        this.nombrecontacto = nombrecontacto;
    }

    public String getTelefonocontacto() {
        return telefonocontacto;
    }

    public void setTelefonocontacto(String telefonocontacto) {
        this.telefonocontacto = telefonocontacto;
    }

    public String getParentescocontacto() {
        return parentescocontacto;
    }

    public void setParentescocontacto(String parentescocontacto) {
        this.parentescocontacto = parentescocontacto;
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

    public Object getBase64() {
        return base64;
    }

    public void setBase64(Object base64) {
        this.base64 = base64;
    }

    public Object getDocumentotrabajadors() {
        return documentotrabajadors;
    }

    public void setDocumentotrabajadors(Object documentotrabajadors) {
        this.documentotrabajadors = documentotrabajadors;
    }

    public Object getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(Object aprendiz) {
        this.aprendiz = aprendiz;
    }

}
