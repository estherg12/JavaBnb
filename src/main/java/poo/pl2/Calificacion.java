
package poo.pl2;

import java.io.Serializable;

public class Calificacion implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     *
     * @param comentario
     * @param califNumero
     * @param inmueble
     * @param partic
     */
    public Calificacion(String comentario, int califNumero, Inmueble inmueble, Particular partic) {
        this.comentario = comentario;
        this.califNumero = califNumero;
        this.inmueble = inmueble;
        this.particular = partic;
    }
    
    private String comentario;
    private int califNumero; //del 1 al 5
    private Inmueble inmueble;
    private Particular particular;

    public int getCalifNumero() {
        return califNumero;
    }

    public void setCalifNumero(int califNumero) {
        this.califNumero = califNumero;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    //Getters & Setters
    public void setInmueble(Inmueble inmueble) {    
        this.inmueble = inmueble;
    }

    /**
     * Get the value of comentario
     *
     * @return the value of comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Set the value of comentario
     *
     * @param comentario new value of comentario
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Particular getParticular() {
        return particular;
    }

    public void setParticular(Particular particular) {
        this.particular = particular;
    }

}
