package poo.pl2;

import java.io.Serializable;

public class ServiciosInmueble implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     *constructor
     * @param wifi
     * @param cocina
     * @param aireAcondicionado
     * @param zonaTrabajo
     * @param aparcamiento
     * @param piscina
     * @param lavadora
     * @param secador
     */
    public ServiciosInmueble(boolean wifi, boolean cocina, boolean aireAcondicionado, boolean zonaTrabajo, boolean aparcamiento, boolean piscina, boolean lavadora, boolean secador) {
        this.wifi = wifi;
        this.cocina = cocina;
        this.aireAcondicionado = aireAcondicionado;
        this.zonaTrabajo = zonaTrabajo;
        this.aparcamiento = aparcamiento;
        this.piscina = piscina;
        this.lavadora = lavadora;
        this.secador = secador;
    }
    
    private boolean wifi;
    private boolean cocina;
    private boolean aireAcondicionado;
    private boolean zonaTrabajo;
    private boolean aparcamiento;
    private boolean piscina;
    private boolean lavadora;
    private boolean secador;

    /**
     * @return boolean wifi
     */
    public boolean isWifi() {
        return wifi;
    }

    /**
     *establecer wifi
     * @param wifi
     */
    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    /**
     * @return boolean cocina
     */
    public boolean isCocina() {
        return cocina;
    }

    /**
     *establecer cocina
     * @param cocina
     */
    public void setCocina(boolean cocina) {
        this.cocina = cocina;
    }

    /**
     * @return boolean aireAcondicionado
     */
    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    /**
     *establecer aireAcondicionado
     * @param aireAcondicionado
     */
    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    /**
     * @return boolean zonaTrabajo
     */
    public boolean isZonaTrabajo() {
        return zonaTrabajo;
    }

    /**
     *establecer zonaTrabajo
     * @param zonaTrabajo
     */
    public void setZonaTrabajo(boolean zonaTrabajo) {
        this.zonaTrabajo = zonaTrabajo;
    }

    /**
     * @return boolean aparcamiento
     */
    public boolean isAparcamiento() {
        return aparcamiento;
    }

    /**
     *establecer aparcamiento
     * @param aparcamiento
     */
    public void setAparcamiento(boolean aparcamiento) {
        this.aparcamiento = aparcamiento;
    }

    /**
     * @return boolean piscina
     */
    public boolean isPiscina() {
        return piscina;
    }

    /**
     *establecer piscina
     * @param piscina
     */
    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    /**
     * @return boolean lavadora
     */
    public boolean isLavadora() {
        return lavadora;
    }

    /**
     *establecer lavadora
     * @param lavadora
     */
    public void setLavadora(boolean lavadora) {
        this.lavadora = lavadora;
    }

    /**
     * @return boolean secador
     */
    public boolean isSecador() {
        return secador;
    }

    /**
     *establecer secador
     * @param secador
     */
    public void setSecador(boolean secador) {
        this.secador = secador;
    }

    @Override
    public String toString() {
        return "serviciosInmueble{" + "wifi=" + wifi + ", cocina=" + cocina + ", aireAcondicionado=" + aireAcondicionado + ", zonaTrabajo=" + zonaTrabajo + ", aparcamiento=" + aparcamiento + ", piscina=" + piscina + ", lavadora=" + lavadora + ", secador=" + secador + '}';
    }
    
}
