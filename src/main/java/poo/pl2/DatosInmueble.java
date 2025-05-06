package poo.pl2;

import java.io.Serializable;

public class DatosInmueble implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     *constructor
     * @param huespedes
     * @param habitaciones
     * @param camas
     * @param baños
     */
    public DatosInmueble(String huespedes, String habitaciones, String camas, String baños) {
        this.huespedes = huespedes;
        this.habitaciones = habitaciones;
        this.camas = camas;
        this.baños = baños;
    }
    
    private String huespedes;
    private String habitaciones;
    private String camas;
    private String baños;

    /**
     *
     * @return baños
     */
    public String getBaños() {
        return baños;
    }

    /**
     *establecer baños
     * @param baños
     */
    public void setBaños(String baños) {
        this.baños = baños;
    }

    /**
     *
     * @return camas
     */
    public String getCamas() {
        return camas;
    }

    /**
     *establecer camas
     * @param camas
     */
    public void setCamas(String camas) {
        this.camas = camas;
    }

    /**
     *
     * @return habitaciones
     */
    public String getHabitaciones() {
        return habitaciones;
    }

    /**
     *establecer habitaciones
     * @param habitaciones
     */
    public void setHabitaciones(String habitaciones) {
        this.habitaciones = habitaciones;
    }

    /**
     *
     * @return huespedes
     */
    public String getHuespedes() {
        return huespedes;
    }

    /**
     *establecer huespedes
     * @param huespedes
     */
    public void setHuespedes(String huespedes) {
        this.huespedes = huespedes;
    }

    /**
     *
     * @return datosInmueble String
     */
    @Override
    public String toString() {
        return "datosInmueble{" + "huespedes=" + huespedes + ", habitaciones=" + habitaciones + ", camas=" + camas + ", ba\u00f1os=" + baños + '}';
    }

}
