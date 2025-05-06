package poo.pl2;

import java.io.Serializable;
import java.time.LocalDate;

public class Anfitrion extends Cliente implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     *constructor
     * @param dni
     * @param nombre
     * @param telefono
     * @param correoElectronico
     * @param clave
     * @param tipo
     */
    public Anfitrion(String dni, String nombre, String telefono, String correoElectronico, String clave, String tipo) {
        super(dni, nombre, telefono, correoElectronico, clave, tipo);
        this.fechaRegistro = LocalDate.now();
    }
    
    private LocalDate fechaRegistro;
    private boolean superAnfitrion;

    /**
     *
     * @return boolean superAnfitrion
     */
    public boolean isSuperAnfitrion() {
        return UtilUsuarios.esSuperAnfitrion(this);
    }

    /**
     *establecer superAnfitrion
     * @param superAnfitrion
     */
    public void setSuperAnfitrion(boolean superAnfitrion) {
        this.superAnfitrion = superAnfitrion;
    }

    /**
     *
     * @return fechaRegistro
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     *establecer fechaRegistro
     * @param fechaRegistro
     */
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public void setTipo(String tipo) {
        super.setTipo(tipo); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getTipo() {
        return super.getTipo(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     *establecer clave
     * @param clave
     */
    @Override
    public void setClave(String clave) {
        super.setClave(clave); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     *
     * @return clave
     */
    @Override
    public String getClave() {
        return super.getClave(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     *establecer telefono
     * @param telefono
     */
    @Override
    public void setTelefono(String telefono) {
        super.setTelefono(telefono); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    

    /**
     *establecer correoElectronico
     * @param correoElectronico
     */
    @Override
    public void setCorreoElectronico(String correoElectronico) {
        super.setCorreoElectronico(correoElectronico); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     *
     * @return correoElectronico
     */
    @Override
    public String getCorreoElectronico() {
        return super.getCorreoElectronico(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     *establecer dni
     * @param dni
     */
    @Override
    public void setDni(String dni) {
        super.setDni(dni); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     *
     * @return dni
     */
    @Override
    public String getDni() {
        return super.getDni(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     *establecer nombre
     * @param nombre
     */
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     *
     * @return nombre
     */
    @Override
    public String getNombre() {
        return super.getNombre(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     *
     * @return telefono
     */
    @Override
    public String getTelefono() {
        return super.getTelefono(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
    /**
     *
     * @return anfitrion to String
     */
    @Override
    public String toString() {
        return super.toString() + ".\nAnfitrion: " + "fechaRegistro = " + fechaRegistro + ", superAnfitrion = " + superAnfitrion + '}';
    }
    
}
