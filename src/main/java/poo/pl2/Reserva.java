package poo.pl2;

import java.io.Serializable;
import java.util.Date;

public class Reserva implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     *constructor
     * @param fechaReserva
     * @param importe
     * @param inmuebleDatos
     * @param clienteParticular
     * @param fechaEntrada
     * @param fechaSalida
     */
    public Reserva(Date fechaReserva, double importe, Inmueble inmuebleDatos, Particular clienteParticular, Date fechaEntrada, Date fechaSalida) {
        this.fechaReserva = fechaReserva;
        this.importe = importe;
        this.inmuebleDatos = inmuebleDatos;
        this.clienteParticular = clienteParticular;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }
    
    private Date fechaReserva;
    private double importe;
    private Inmueble inmuebleDatos;
    private Particular clienteParticular;
    private Date fechaEntrada;
    private Date fechaSalida;

    /**
     * @return fecha reserva
     */
    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    /**
     * @return fecha reserva
     */
    public double getImporte() {
        return importe;
    }

    /**
     *establecer importe
     * @param importe
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }

    /**
     * @return fecha reserva
     */
    public Inmueble getInmuebleDatos() {
        return inmuebleDatos;
    }

    /**
     *establecer inmuebleDatos
     * @param inmuebleDatos
     */
    public void setInmuebleDatos(Inmueble inmuebleDatos) {
        this.inmuebleDatos = inmuebleDatos;
    }

    /**
     * @return fecha reserva
     */
    public Particular getClienteParticular() {
        return clienteParticular;
    }

    /**
     *establecer clienteParticular
     * @param clienteParticular
     */
    public void setClienteParticular(Particular clienteParticular) {
        this.clienteParticular = clienteParticular;
    }

    /**
     * @return fecha reserva
     */
    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    /**
     *establecer fechaEntrada
     * @param fechaEntrada
     */
    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    /**
     * @return fecha reserva
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     *establecer fechaSalida
     * @param fechaSalida
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "reserva{" + "fechaReserva=" + fechaReserva + ", importe=" + importe + ", inmuebleDatos=" + inmuebleDatos + ", clienteParticular=" + clienteParticular + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + '}';
    }

}
