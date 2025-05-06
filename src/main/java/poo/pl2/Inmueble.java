package poo.pl2;

import java.io.Serializable;

public class Inmueble implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     *constructor
     * @param titulo
     * @param direccion
     * @param datosInmueble
     * @param tipo
     * @param servicios
     * @param imagen
     * @param precioXnoche
     * @param anfitrion
     */
    public Inmueble(String titulo, Direccion direccion, DatosInmueble datosInmueble, String tipo, ServiciosInmueble servicios, String imagen, double precioXnoche, Anfitrion anfitrion) {
        this.titulo = titulo;
        this.direccion = direccion;
        this.datosInmueble = datosInmueble;
        this.tipo = tipo;
        this.servicios = servicios;
        this.imagen = imagen;
        this.precioXnoche = precioXnoche;
        this.anfitrion = anfitrion;
    }
    
    private String titulo;
    private Direccion direccion;
    private DatosInmueble datosInmueble;
    private Anfitrion anfitrion;

    private String tipo;
    private ServiciosInmueble servicios;
    private String imagen;
    private double calificacion = 0;
    private double precioXnoche;
    
    //Getters y Setters

    /**
     *
     * @return precioXnoche
     */
    public double getPrecioXnoche() {
        return precioXnoche;
    }

    /**
     *establecer precioXnoche
     * @param precioXnoche
     */
    public void setPrecioXnoche(double precioXnoche) {
        this.precioXnoche = precioXnoche;
    }
    
    /**
     *
     * @return servicios
     */
    public ServiciosInmueble getServicios() {
        return servicios;
    }

    /**
     *establecer servicios
     * @param servicios
     */
    public void setServicios(ServiciosInmueble servicios) {
        this.servicios = servicios;
    }

    /**
     *
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *establecer tipo
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
     * @return datosInmueble
     */
    public DatosInmueble getDatosInmueble() {
        return datosInmueble;
    }

    /**
     *establecer datosInmueble
     * @param datosInmueble
     */
    public void setDatosInmueble(DatosInmueble datosInmueble) {
        this.datosInmueble = datosInmueble;
    }

    /**
     *
     * @return direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     *establecer direccion
     * @param direccion
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    /**
     *
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *establecer titulo
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     *
     * @return imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     *establecer fotografia
     * @param imagen
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     *
     * @return calificacion
     */
    public double getCalificacion() {
        return calificacion;
    }

    /**
     *establecer calificacion
     * @param calificacion
     */
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    /**
     *
     * @return afitrion
     */
    public Anfitrion getAnfitrion() {
        return anfitrion;
    }

    /**
     *establecer anfitrion
     * @param anfitrion
     */
    public void setAnfitrion(Anfitrion anfitrion) {
        this.anfitrion = anfitrion;
    }    

}
