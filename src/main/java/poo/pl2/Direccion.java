package poo.pl2;

import java.io.Serializable;

public class Direccion implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     *constructor
     * @param calle
     * @param numero
     * @param codigoPostal
     * @param ciudad
     */
    public Direccion(String calle, String numero, String codigoPostal, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
    }
    
    private String calle;
    private String numero;
    private String codigoPostal;
    private String ciudad;

    /**
     *
     * @return ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     *establecer ciudad
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     *
     * @return codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     *establecer codigoPostal
     * @param codigoPostal
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     *
     * @return numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     *establecer numero
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     *
     * @return calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     *establecer calle
     * @param calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     *
     * @return direccion String
     */
    @Override
    public String toString() {
        return "direccion{" + "calle=" + calle + ", numero=" + numero + ", codigoPostal=" + codigoPostal + ", ciudad=" + ciudad + '}';
    }

}
