package poo.pl2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class UtilInmuebles {
    
    private static ArrayList<Inmueble> inmuebles = new ArrayList<>();
    private static Inmueble objInmAux;
    private static ArrayList<Calificacion> calificaciones = new ArrayList<>();
        
    /**
     *añade inmueble a arraylist inmuebles comprobando si ese inmueble ya está dentro del arraylist
     * @param inmueble
     * @return true si arraylist inmuebles no contiene ya a inmueble
     */
    public static boolean crearInmueble(Inmueble inmueble){
        if(!inmuebles.contains(inmueble)){
            inmuebles.add(inmueble);
            return true;
        }else {
            return false;
        }
    }
    
    /**
     *da de baja un inmueble, elimina el elemento Inmueble del arraylist. 
     * Usado por Anfitriones
     * @param inmueble
     * @return boolean
     */
    public static boolean eliminarInmueble(Inmueble inmueble){
        if(inmuebles.contains(inmueble)){
            inmuebles.remove(inmueble);
            return true;
        }else {
            return false;
        }
    }
    
    
    
    /**
     *devuelve un arrayList con todos los inmuebles de un anfitrion
     * @param anfit
     * @return arrayList Inmueble inmueblesAnfit
     */
    public static ArrayList<Inmueble> inmueblesAnfit(Anfitrion anfit){
        ArrayList<Inmueble> inmueblesAnfit = new ArrayList<>();
        for (Inmueble inm: inmuebles){
            if(inm.getAnfitrion().getDni().equals(anfit.getDni())){
                inmueblesAnfit.add(inm);
            }
        }
        return inmueblesAnfit;
    }
    
    /**
     *Modifica los datos de un inmueble
     * @param inm
     * @param titulo
     * @param direccion
     * @param datosInmueble
     * @param tipo
     * @param servicios
     * @param imagen
     * @param precioXnoche
     * @param anfitrion
     * @return boolean
     */
    public static boolean modificarDatosInmueble(Inmueble inm, String titulo, Direccion direccion, DatosInmueble datosInmueble, String tipo, ServiciosInmueble servicios, String imagen, double precioXnoche, Anfitrion anfitrion){
        if (inm == null || !inmuebles.contains(inm)) {
            return false;
        }
        else{
            if(!inm.getTitulo().equals(titulo)){
                inm.setTitulo(titulo);
                return true;
            }
            if(!inm.getDireccion().equals(direccion)){
                inm.setDireccion(direccion);
                return true;
            }
            if(!inm.getDatosInmueble().equals(datosInmueble)){
                inm.setDatosInmueble(datosInmueble);
                return true;
            }
            if(!inm.getTipo().equals(tipo)){
                inm.setTipo(tipo);
                return true;
            }
            if(!inm.getServicios().equals(servicios)){
                inm.setServicios(servicios);
                return true;
            }
            if(!inm.getDireccion().equals(direccion)){
                inm.setDireccion(direccion);
                return true;
            }
            if(!inm.getImagen().equals(imagen)){
                inm.setImagen(imagen);
                return true;
            }
            if(!inm.getDireccion().equals(direccion)){
                inm.setDireccion(direccion);
                return true;
            }
            if(!(inm.getPrecioXnoche()==(precioXnoche))){
                inm.setPrecioXnoche(precioXnoche);
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    /**
     *añade una calificación por parte de un particular al arrayList de calificaciones
     * @param res
     * @param calif
     * @param comentario
     * @param partic
     * @return calificacion
     */
    public static double añadirCalificacion(Reserva res, int calif, String comentario, Particular partic){
        if(calif < 1 || calif > 5) {
            throw new IllegalArgumentException("La calificación debe estar en el rango de 1 a 5.");
        }
        try {
            Inmueble inm = res.getInmuebleDatos();
            Calificacion calificacionCompleta = new Calificacion(comentario, calif, inm, partic);
            calificaciones.add(calificacionCompleta);

            if(Double.isNaN(calcularCalificacionMedia(inm))){
                return 0.0;
            } else {
                return calcularCalificacionMedia(inm);
            }
        } catch (NullPointerException e) {
            // Manejar la excepción si alguno de los parámetros es nulo
            System.err.println("Error: " + e.getMessage());
            return 0.0;
        }
    }
    
    /**
     *calcula la calificación media entre todas las calificaciones recibidas de un inmueble
     * @param inm
     * @return calificacion
     */
    public static double calcularCalificacionMedia(Inmueble inm){
        int suma = 0;
        int contador = 0;

        try {
            if(calificaciones.isEmpty()){
                return 0.0;
            } else {
                for(Calificacion calif: calificaciones){
                    if(calif.getInmueble().getTitulo().equals(inm.getTitulo())){
                        suma += calif.getCalifNumero();
                        contador++;
                    }
                }
                if((contador==0)||suma==0){
                    return 0.0;
                } else {
                    return (double) suma/contador;
                }
            }
        } catch (ArithmeticException e) {
            // Manejar la excepción si se produce una división por cero
            System.err.println("Error: " + e.getMessage());
            return 0.0;
        }
    }
    
    
    /**
     *filtra los inmuebles disponibles en la ciudad buscada y en las fechas
     * compara la fecha de Entrada con la fecha de Salida de cada reserva 
     * y la fecha de Salida con la fecha de Entrada de cada reserva
     * @param ciudad
     * @param fechaEntrada
     * @param fechaSalida
     * @return ArrayList Inmueble disponibles
     */
    public static ArrayList<Inmueble> buscarInmueblesDisponibles(String ciudad, Date fechaEntrada, Date fechaSalida) {
        ArrayList<Reserva> reservas = UtilReservas.getReservas();
        ArrayList<Inmueble> inmDispo = new ArrayList<>();
        for (Inmueble inm : inmuebles) {
            if (inm.getDireccion().getCiudad().equalsIgnoreCase(ciudad)) {
                boolean disponible = true;
                for (Reserva res : reservas) {
                    if (res.getInmuebleDatos().getTitulo().equals(inm.getTitulo())) {
                        if (!(fechaSalida.before(res.getFechaEntrada()) || fechaEntrada.after(res.getFechaSalida()))) {
                            // Las fechas se solapan, el inmueble no está disponible
                            disponible = false;
                            break;
                        }
                    }
                }
                if (disponible) {
                    inmDispo.add(inm);
                }
            }
        }
        return inmDispo;
    }
    

    /**
     * Ordena los arrayList de todos los inmuebles de UtilInmuebles por orden alfabético del nombre / título
     * @return arrayList inmuebles de tipo Inmueble ordenados por Nombre
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Inmueble> getInmueblesXnombre(){
        Comparator NomproComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Inmueble inm1 = (Inmueble) o1;
                Inmueble inm2 = (Inmueble) o2;
                return inm1.getTitulo().compareTo(inm2.getTitulo());
            }
        };
        //Se ordena el array inmuebles
        Collections.sort(inmuebles, NomproComp);
        return inmuebles;
    }
    
    /** Devuelve el ArrayList de Inmuebles ordenados por Precio de menor a mayor
     * @return   ArrayList Inmueble
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Inmueble> getInmueblesXprecio() {
        //Comparador para ordenar los Productos por su nombre
        Comparator PrecioComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Inmueble inm1 = (Inmueble) o1;
                Inmueble inm2 = (Inmueble) o2;
                Double pr1 = inm1.getPrecioXnoche();
                Double pr2 = inm2.getPrecioXnoche();
                return pr1.compareTo(pr2);
            }
        };
        //Ordenamos el array
        Collections.sort(inmuebles, PrecioComp);
        return inmuebles;
    }
    
    /**
     *recibe un arraylist de inmuebles disponibles y los ordena por precio de menor a mayor
     * @param inmDispo
     * @return ArrayList Inmueble
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Inmueble> getInmueblesXprecioFiltrados(ArrayList<Inmueble> inmDispo) {
        //Comparador para ordenar los Productos por su nombre
        Comparator PrecioComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Inmueble inm1 = (Inmueble) o1;
                Inmueble inm2 = (Inmueble) o2;
                Double pr1 = inm1.getPrecioXnoche();
                Double pr2 = inm2.getPrecioXnoche();
                return pr1.compareTo(pr2);
            }
        };
        //Ordenamos el array
        Collections.sort(inmDispo, PrecioComp);
        return inmDispo;
    }
    
    /**
     *recibe el tipo (casa/apartamento) y un arraylist de inmuebles disponibles
     * devuelve el arraylist de los inmuebles disponibles filtrados por el tipo (solo casas o solo apartamentos)
     * @param tipo
     * @param inmueblesDispo
     * @return ArrayList Inmueble
     */
    public static ArrayList<Inmueble> getInmueblesTipo(String tipo, ArrayList<Inmueble> inmueblesDispo){
        ArrayList<Inmueble> inmTipo = new ArrayList<>();
        for(Inmueble inm: inmueblesDispo){
            if(inm.getTipo().equalsIgnoreCase(tipo)){
                inmTipo.add(inm);
            }
        }
        return inmTipo;
    }
    
    /**
     *Recibe un arrayList de inmuebles y los ordena según la calificación de mayor a menor
     * @param inmDispo
     * @return ArrayList Inmueble
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Inmueble> getInmueblesCalificacion(ArrayList<Inmueble> inmDispo){
        //Comparador para ordenar los Productos por su nombre
        Comparator CalifComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Inmueble inm1 = (Inmueble) o1;
                Inmueble inm2 = (Inmueble) o2;
                Double pr1 = UtilInmuebles.calcularCalificacionMedia(inm1);
                Double pr2 = UtilInmuebles.calcularCalificacionMedia(inm2);
                return pr2.compareTo(pr1);
            }
        };
        //Ordenamos el array
        Collections.sort(inmDispo, CalifComp);
        return inmDispo;
    }
    
    /**Mediante un número entero, se localiza un inmueble dentro del arrayList de UtilInmuebles
     * @param indice
     * @return  Inmueble*/
    public static Inmueble consultaInmueble(int indice) {
        objInmAux = inmuebles.get(indice);
        return objInmAux;
    }
    
    /**
     *guardar arrayList inmuebles en copiasegInm
     */
    public static void guardarDatos(){
        try {
            // Si hay datos en al menos una de las listas, las guardamos...
            if (!inmuebles.isEmpty() /**|| !anfitriones.isEmpty() || !particulares.isEmpty()*/) {
                // Serialización de los objetos
                FileOutputStream ostreamUtilInmuebles = new FileOutputStream("copiasegInm.dat");
                ObjectOutputStream oosInm = new ObjectOutputStream(ostreamUtilInmuebles);

                // Guardamos solo las listas que no están vacías
                if (!inmuebles.isEmpty()) {
                    oosInm.writeObject(inmuebles);
                }
                if (!calificaciones.isEmpty()) {
                    oosInm.writeObject(calificaciones);
                }

                oosInm.close();
            } else {
                System.out.println("Error: No hay datos en ninguna lista...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     *carga los arrayList inmuebles desde el fichero copiasegInm
     */
    public static void cargarDatos() {
        try {
            //Lectura de los objetos de tipo persona
            FileInputStream istreamInm = new FileInputStream("copiasegInm.dat");
            ObjectInputStream oisInm = new ObjectInputStream(istreamInm);
            inmuebles = (ArrayList) oisInm.readObject();
            calificaciones = (ArrayList) oisInm.readObject();
            istreamInm.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Getter & Setter

    /**
     *
     * @return arraylist de toooodas las calificaciones de todos los inmuebles
     */
    public static ArrayList<Calificacion> getCalificaciones() {
        return calificaciones;
    }
    
    public static void setCalificaciones(ArrayList<Calificacion> calificaciones) {    
        UtilInmuebles.calificaciones = calificaciones;
    }

    public static ArrayList<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public static void setInmuebles(ArrayList<Inmueble> inmuebles) {
        UtilInmuebles.inmuebles = inmuebles;
    }

    public static Inmueble getObjInmAux() {
        return objInmAux;
    }

    public static void setObjInmAux(Inmueble objInmAux) {
        UtilInmuebles.objInmAux = objInmAux;
    }
    
    @Override
    public String toString(){
        return "inmueble: "+inmuebles;
    }
    
}
