/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteGratitud.demo.DTO;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class RegistroUsuarioDto {

    private String nombre;
    private String apellidoP;
    private String apellidoM;

    private String gmail;
    private String contrasenia;
    private String telefono;

    private String tipoIdentificacionId;

    private String numeroDni;
    private LocalDate fechaNacimiento;

    // Datos de la dirección
    private String pais;
    private String departamento;
    private String ciudad;
    private String barrio;
    private LocalDate fechaRegistro;

    public RegistroUsuarioDto() {
    }

    public RegistroUsuarioDto(String nombre, String apellidoP, String apellidoM, String gmail, String contrasenia, String telefono, String tipoIdentificacionId, String numeroDni, LocalDate fechaNacimiento, String pais, String departamento, String ciudad, String barrio, LocalDate fechaRegistro) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.gmail = gmail;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.tipoIdentificacionId = tipoIdentificacionId;
        this.numeroDni = numeroDni;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.barrio = barrio;
        this.fechaRegistro = fechaRegistro;
    }

 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoIdentificacionId() {
        return tipoIdentificacionId;
    }

    public void setTipoIdentificacionId(String tipoIdentificacionId) {
        this.tipoIdentificacionId = tipoIdentificacionId;
    }

   

    public String getNumeroDni() {
        return numeroDni;
    }

    public void setNumeroDni(String numeroDni) {
        this.numeroDni = numeroDni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
