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

public class UtilUsuarios {
    
    //ArrayList
    private static ArrayList<Cliente> clientesTodos = new ArrayList<>();
    private static ArrayList<Anfitrion> anfitriones = new ArrayList<>();
    private static ArrayList<Particular> particulares = new ArrayList<>();
    
    private static Cliente cliente;
    private static Anfitrion anfit;
    private static Particular partic;
    
    /**
     *añade anfitrion a arrayList anfitriones
     * @param anfitrion
     * @return true si anfitrion no está ya en el arrayList
     */
    public static boolean registrarAnfitrion(Anfitrion anfitrion){
        for(Anfitrion anfit: anfitriones){
            if(!anfit.getCorreoElectronico().equals(anfitrion.getCorreoElectronico())){
                anfitriones.add(anfitrion);
                clientesTodos.add(anfitrion);
                setAnfit(anfitrion);
                return true;
            }
        }return false;
    }

    /**
     *añade particular a arrayList particulares
     * @param particular
     * @return true si particular no está ya en el arrayList
     */
    public static boolean registrarParticular(Particular particular){
        for(Particular partic: particulares){
            if(!partic.getCorreoElectronico().equals(particular.getCorreoElectronico())){
                particulares.add(particular);
                clientesTodos.add(particular);
                setPartic(particular);
                return true;
            }
        }return false;
    }
    
    /**
     *verifica el correo y clave de un anfitrion para reconocerlo en el arrayList particulares
     * @param correo
     * @param clave
     * @return true si está en el arratList anfitriones
     */
    public static boolean verificarCorreoClaveAnfitrion (String correo, String clave){
        for (Anfitrion anfitrion: anfitriones){
            if(anfitrion.getCorreoElectronico().equals(correo) && anfitrion.getClave().equals(clave)){
                setAnfit(anfitrion);
                return true;
            }
        }return false;
    }
    
    /**
     *verifica el correo y clave de un particular para reconocerlo en el arrayList particulares
     * @param correo
     * @param clave
     * @return true si está en el arratList particulares
     */
    public static boolean verificarCorreoClaveParticular (String correo, String clave){
        for (Particular particular: particulares){
            if(particular.getCorreoElectronico().equals(correo) && particular.getClave().equals(clave)){
                setPartic(particular);
                return true;
            }
        }return false;
    }
    
    /**
     *verifica el correo y la clave del administrador
     * @param correo
     * @param clave
     * @return boolean
     */
    public static boolean verificarCorreoClaveAdministrador(String correo, String clave){
        return "admin@javabnb.com".equals(correo) && "admin".equals(clave);
    }
        
    /**
     * modifica los datos de un anfitrion uno por uno comprobando que los datos no son los mismos,
     * @param nombre
     * @param dni
     * @param telefono
     * @param correo
     * @param clave
     * @param anfit
     * @return boolean
     */
    public static boolean modificarDatosAnfitrion(String nombre, String dni, String telefono, String correo, String clave, Anfitrion anfit){
        if (anfit == null || !anfitriones.contains(anfit)) {
            return false;
        }
        else{
            if(!anfit.getNombre().equals(nombre)){
                anfit.setNombre(nombre);
                return true;
            }
            if(!anfit.getDni().equals(dni)){
                anfit.setDni(dni);
                return true;
            }
            if(!anfit.getTelefono().equals(telefono)){
                anfit.setTelefono(telefono);
                return true;
            }
            if(!anfit.getCorreoElectronico().equals(correo)){
                anfit.setCorreoElectronico(correo);
                return true;
            }
            if(!anfit.getClave().equals(clave)){
                anfit.setClave(clave);
                return true;
            }
            else{
                return false;
            }
        }
    }
     
    /**
     * modifica los datos de un particular uno por uno comprobando que los datos no son los mismos,
     * @param nombre
     * @param dni
     * @param telefono
     * @param correo
     * @param clave
     * @param numero
     * @param fechaCaducidad
     * @param partic
     * @return boolean
     */
    public static boolean modificarDatosParticular(String nombre, String dni, String telefono, String correo, String clave, String numero, Date fechaCaducidad,  Particular partic){
        if (partic == null || !particulares.contains(partic)) {
            return false;
        }
        else{
            if(!partic.getNombre().equals(nombre)){
                partic.setNombre(nombre);
                return true;
            }
            if(!partic.getDni().equals(dni)){
                partic.setDni(dni);
                return true;
            }
            if(!partic.getTelefono().equals(telefono)){
                partic.setTelefono(telefono);
                return true;
            }
            if(!partic.getCorreoElectronico().equals(correo)){
                partic.setCorreoElectronico(correo);
                return true;
            }
            if(!partic.getClave().equals(clave)){
                partic.setClave(clave);
                return true;
            }
            TarjetaCredito tc = partic.getTarjetaCredito();
            if(tc.getFechaCaducidad()!=fechaCaducidad){
                tc.setFechaCaducidad(fechaCaducidad);
                partic.setTarjetaCredito(tc);
            }
            if(!tc.getNumero().equals(numero)){
                tc.setNumero(numero);
                partic.setTarjetaCredito(tc);
            }
            else{
                return false;
            }
        }
        return false;
    }
    
    /**
     *Si el particular se ha registrado hace 10 días o más es cliente VIP
     * @param partic
     * @return boolean
     */
    public static boolean esParticularVip(Particular partic){
        Date hoy = new Date();
        Date fechaReg = partic.getFechaRegistro();
        
        long difMSeg = hoy.getTime() - fechaReg.getTime(); //diferencia en milisegundos entre hoy y la fecha de reg
        long difDias = difMSeg / (1000 * 60 * 60 * 24); //convertir la diferencia en días
        
        return difDias>=10; //10 días desde el registro para ser VIP
    }
    
    /**
     *Si el anfitrion tiene una calificación media de más de 4 en todos sus inmuebles
     * @param anfit
     * @return boolean
     */
    public static boolean esSuperAnfitrion(Anfitrion anfit){
        double suma=0;
        ArrayList<Inmueble> inmueblesAnfit = UtilInmuebles.inmueblesAnfit(anfit);
        for(Inmueble inm: inmueblesAnfit){
            suma+=UtilInmuebles.calcularCalificacionMedia(inm);
        }
        if(inmueblesAnfit.isEmpty()){
            return false;
        }else {
            return (suma/inmueblesAnfit.size())>=4;
        }
    }
    
    /**
     *guardar arrayList clientesTodos, anfitriones y particulares en copiasegUsuar 
     */
    public static void guardarDatos(){
        try {
            // Si hay datos en al menos una de las listas, las guardamos...
            if (!clientesTodos.isEmpty() || !anfitriones.isEmpty() || !particulares.isEmpty()) {
                // Serialización de los objetos
                FileOutputStream ostreamUtilUsuarios = new FileOutputStream("copiasegUsuar.dat");
                ObjectOutputStream oosUsuar = new ObjectOutputStream(ostreamUtilUsuarios);

                // Guardamos solo las listas que no están vacías
                if (!clientesTodos.isEmpty()) {
                    oosUsuar.writeObject(clientesTodos);
                }
                if (!anfitriones.isEmpty()) {
                    oosUsuar.writeObject(anfitriones);
                }
                if (!particulares.isEmpty()) {
                    oosUsuar.writeObject(particulares);
                }

                oosUsuar.close();
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
     *carga los arrayList clientesTodos, anfitriones y particulares desde el fichero copiasegUsuar
     */
    public static void cargarDatos() {
        try {
            //Lectura de los objetos de tipo persona
            FileInputStream istreamUsuar = new FileInputStream("copiasegUsuar.dat");
            ObjectInputStream oisUsuar = new ObjectInputStream(istreamUsuar);
            clientesTodos = (ArrayList) oisUsuar.readObject();
            anfitriones = (ArrayList) oisUsuar.readObject();
            particulares = (ArrayList) oisUsuar.readObject();
            istreamUsuar.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     *Busca el anfitrion en el arrayList con el mismo nombre y dni que el cliente
     * @param cliente
     * @return
     */
    public static Anfitrion getAnfitrionXCliente (Cliente cliente){
        for(Anfitrion anfitrion: anfitriones){
            if(cliente.getNombre().equals(anfitrion.getNombre())&&cliente.getDni().equals(anfitrion.getDni())){
              return anfitrion;  
            }
        }
        return null;
    }
    
    /**
     *Busca el particular en el arrayList que es el mismo que el cliente
     * @param cliente
     * @return particular
     */
    public static Particular getParticularXCliente (Cliente cliente){
        for(Particular particular: particulares){
            if(cliente.getNombre().equals(particular.getNombre())&&cliente.getDni().equals(particular.getDni())){
              return particular;  
            }
        }
        return null;
    }
    
    /**
     *ordena todos los clientes registrados en el arrayList clientesTodos
     * por orden alfabético según su nombre
     * @return Array List Clientes
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Cliente> getClientesPorNombre() {
        //Comparador para ordenar los Productos por su nombre
        Comparator NomproComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Cliente p1 = (Cliente) o1;
                Cliente p2 = (Cliente) o2;
                return p1.getNombre().compareTo(p2.getNombre());
            }
        };
        //Ordenamos el array
        Collections.sort(clientesTodos, NomproComp);
        return clientesTodos;
    }
    //Setters & Getters

    /**
     * @return arrayList de clientes
     */
    public static ArrayList<Cliente> getClientesTodos() {
        return clientesTodos;
    }

    /**
     *establece el arrayList de clientes
     * @param clientesTodos
     */
    public void setClientesTodos(ArrayList<Cliente> clientesTodos) {
        UtilUsuarios.clientesTodos = clientesTodos;
    }

    /**
     * @return arrayList anfitriones
     */
    public static ArrayList<Anfitrion> getAnfitriones() {
        return anfitriones;
    }

    /**
     *establece arraylist anfitriones
     * @param anfitriones
     */
    public void setAnfitriones(ArrayList<Anfitrion> anfitriones) {
        UtilUsuarios.anfitriones = anfitriones;
    }

    /**
     *@return arrayList particulares
     */
    public static ArrayList<Particular> getParticulares() {
        return particulares;
    }

    /**
     *establece arrayList particulares
     * @param particulares
     */
    public void setParticulares(ArrayList<Particular> particulares) {
        UtilUsuarios.particulares = particulares;
    }

    /**
     * @return Cliente cliente
     */
    public static Cliente getCliente() {
        return cliente;
    }

    /**
     *establece Cliente cliente a cliente
     * @param cliente
     */
    public static void setCliente(Cliente cliente) {
        UtilUsuarios.cliente = cliente;
    }

    /**
     * @return anfit
     */
    public static Anfitrion getAnfit() {
        return anfit;
    }

    /**
     *establece Anfitrion anfit a anfit
     * @param anfit
     */
    public static void setAnfit(Anfitrion anfit) {
        UtilUsuarios.anfit = anfit;
    }

    /**
     * @return partic
     */
    public static Particular getPartic() {
        return partic;
    }

    /**
     *establece Particular partic a partic
     * @param partic
     */
    public static void setPartic(Particular partic) {
        UtilUsuarios.partic = partic;
    }
    
}
