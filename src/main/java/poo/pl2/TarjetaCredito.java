package poo.pl2;

import java.io.Serializable;
import java.util.Date;

public class TarjetaCredito implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String numero;
    private Date fechaCaducidad;
    private double cargos;

    /**
     *constructor
     * @param numero
     * @param fechaCaducidad
     */
    public TarjetaCredito(String numero, Date fechaCaducidad) {
        this.numero = numero;
        this.fechaCaducidad = fechaCaducidad;
    }

    public double getCargos() {
        return cargos;
    }

    public void setCargos(double cargos) {
        this.cargos = cargos;
    }
    
    public void addCargo(double cargo){
        this.cargos*=cargo;
    }
    
    /**
     * @return fechaCaducidad
     */
    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     *establece fechaCaducidad
     * @param fechaCaducidad
     */
    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    /**
     * @return numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     *establece numero
     * @param numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return numero y fecha caducidad
     */
    @Override
    public String toString() {
        return "tarjetaCredito{"+ ", numero=" + numero + ", fechaCaducidad=" + fechaCaducidad + '}';
    }

}
