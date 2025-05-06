package poo.pl2;

import java.io.Serializable;
import java.util.Date;

public class Particular extends Cliente implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     *constructor
     * @param tarjetaCredito
     * @param dni
     * @param nombre
     * @param telefono
     * @param correoElectronico
     * @param clave
     * @param tipo
     */
    public Particular(TarjetaCredito tarjetaCredito, String dni, String nombre, String telefono, String correoElectronico, String clave, String tipo) {
        super(dni, nombre, telefono, correoElectronico, clave, tipo);
        this.tarjetaCredito = tarjetaCredito;
        this.tipo = tipo;
    }
    
    private boolean vip;
    private TarjetaCredito tarjetaCredito;
    private String tipo;
    private Date fechaRegistro; 
    
    /**
     * @return tarjetaCredito
     */
    public TarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return boolean vip
     */
    public boolean isVip() {
        return UtilUsuarios.esParticularVip(this);
    }

    public void setVip(boolean vip) {
        this.vip = vip;
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
     * @return clave
     */
    @Override
    public String getClave() {
        return super.getClave(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
     * @return nombre
     */
    @Override
    public String getNombre() {
        return super.getNombre(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
     * @return telefono
     */
    @Override
    public String getTelefono() {
        return super.getTelefono(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }  
   
    /**
     * @return particular to String
     */
    @Override
    public String toString() {
        return super.toString() + "particular{" + "vip=" + vip + ", tarjetaCredito=" + tarjetaCredito + '}';
    }

}
