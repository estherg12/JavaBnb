package poo.pl2;

import java.io.Serializable;

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * constructor
     * @param dni
     * @param nombre
     * @param telefono
     * @param correoElectronico
     * @param clave
     * @param tipo
     */
    public Cliente(String dni, String nombre, String telefono, String correoElectronico, String clave, String tipo) {
        this.correoElectronico = correoElectronico;
        this.clave = clave;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    /**
     *
     * @param tipo
     */
    public Cliente(String tipo) {
        this.tipo = tipo;
    }
    
    private String correoElectronico;
    private String clave;
    private String dni;
    private String nombre;
    private String telefono;
    private String tipo;

    /**
     *
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *establecer telefono
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *establecer nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return dni
     */
    public String getDni() {
        return dni;
    }

    /**
     *establecer dni
     * @param dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     *
     * @return correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     *establecer correoElectronico
     * @param correoElectronico
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     *
     * @return clave
     */
    public String getClave() {
        return clave;
    }

    /**
     *establecer clave
     * @param clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    /**
     *
     * @return cliente String
     */
    @Override
    public String toString() {
        return "Cliente: " +"tipo = "+ tipo + "correoElectronico = " + correoElectronico + ", clave = " + clave + ", \ndni = " + dni + ", nombre = " + nombre + ", telefono = " + telefono;
    }

   
    

}
