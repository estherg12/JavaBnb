package poo.pl2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class UtilReservas {
    private static ArrayList<Reserva> reservas = new ArrayList<>();
    
    /**
     *añade una reserva al arraylist de reservas comprobando antes si ya está en el arraylist
     * @param reserva
     * @return boolean
     * @throws java.io.IOException
     */
    public static boolean crearReserva(Reserva reserva) throws IOException{
        if(!reservas.contains(reserva)){
            reservas.add(reserva);
            
            cargoTarjetaCredito(reserva);
            
            Date fechaEntrada = reserva.getFechaEntrada();
            Date fechaSalida = reserva.getFechaSalida();
            long noches = (fechaEntrada.getTime()-fechaSalida.getTime())/ (1000 * 60 * 60 * 24);
            
            generaFactura(reserva, noches);
            
            return true;
        }else {
            return false;
        }
    }
    
    /**
     *elimina una reserva del arraylist de reservas comprobando si está
     * @param reserva
     * @return boolean
     */
    public static boolean eliminarReserva(Reserva reserva){
        if(reservas.contains(reserva)){
            reservas.remove(reserva);
            return true;
        }else {
            return false;
        }
    }
    
    /**
     *filtra de entre todas las reservas las hechas solo por el mismo cliente particular
     * @param partic
     * @return arraylist reserva de las reservas de un particular
     */
    public static ArrayList<Reserva> getReservasParticular(Particular partic){
        ArrayList<Reserva> reservasPartic = new ArrayList<>();
        for (Reserva res: reservas){
            if(res.getClienteParticular().getCorreoElectronico().equals(partic.getCorreoElectronico())){
                reservasPartic.add(res);
            }
        }
        return reservasPartic;
    }
    
    /**
     *filtra de entre todas las reservas las de los inmuebles de un anfitrion
     * @param inmueble
     * @return arraylist reserva de reservas de los inmuebles de los anfitriones
     */
    public static ArrayList<Reserva> getReservasInmueble(Inmueble inmueble){
        ArrayList<Reserva> reservasAnfit = new ArrayList<>();
        for (Reserva res: reservas){
            if(res.getInmuebleDatos().getTitulo().equals(inmueble.getTitulo())){
                reservasAnfit.add(res);
            }
        }
        return reservasAnfit;
    }
    
    /**
     *ordena el arrayList de reservas por fecha
     * @param reservas
     * @return arraylist de reservas ordenadas por fecha
     */
    public static ArrayList<Reserva> getReservasXfecha(ArrayList<Reserva> reservas){
        //ordena los elementos de la lista
        Collections.sort(reservas, new Comparator<Reserva>(){//clase anónima que implementa la interfaz Comparator Reserva
            @Override
            public int compare(Reserva r1, Reserva r2){//método compare que toma dos objetos Reserva y los compara en función de su fechaReserva
                return r2.getFechaReserva().compareTo(r1.getFechaReserva());
            }
        });
        return reservas;
    }
    
    /**
     *carga el importe en la tarjeta de crédito del cliente particular
     * @param reserva
     */
    public static void cargoTarjetaCredito(Reserva reserva){
        Particular partic = reserva.getClienteParticular();
        TarjetaCredito tc = partic.getTarjetaCredito();
        double importe = reserva.getImporte();
        
        tc.addCargo(importe);
    }
    
    /** Crea un fichero de texto con los datos de una reserva de un inmueble
     * @param reserva
     * @param noches
     * @throws java.io.IOException */
    public static void generaFactura(Reserva reserva, long noches) throws IOException {
        LocalDate hoy = LocalDate.now();
        Inmueble inm = reserva.getInmuebleDatos();
        
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
        String fn = hoy.format(formatoCorto);
        String rutaFicheroFactura = "./Facturas/Factura(" + fn.replace('/', '_') + ").txt";
        double importe = inm.getPrecioXnoche() * noches;
        try {
            //Si no existe el directorio Facturas, lo creamos
            File dirFacturas = new File("./Facturas");

            if (!dirFacturas.exists()) {
                dirFacturas.mkdir();
            }

            FileWriter fw = new FileWriter(rutaFicheroFactura);
            try (PrintWriter salida = new PrintWriter(new BufferedWriter(fw))) {
                salida.println("-------------------------------- Factura Reserva --------------------------------");
                salida.println("\n");
                salida.println("-------------------------------- Fecha: " + fn + " -------------------------------");
                salida.println("\n");
                salida.println("Inmueble: "+inm.getTitulo());
                salida.println("Ciudad: "+inm.getDireccion().getCiudad());
                if (inm.getTipo().equals("Apartamento")) {
                    salida.println("Tipo: Apartamento");
                } else {
                    salida.println("Tipo: Casa");
                }
                salida.println("\nNombre: " + inm.getTitulo());
                salida.println("Anfitrion: " + (inm.getAnfitrion()));
                salida.println("Particular: "+(reserva.getClienteParticular()));
                salida.println("\n");
                salida.println("Fecha de Entrada: "+(reserva.getFechaEntrada()));
                salida.println("Fecha de Salida: "+ reserva.getFechaSalida());
                salida.println("Precio por noche: " + inm.getPrecioXnoche());
                salida.println("Noches: " + noches);
                salida.println("---------------------------------------------------------------------------------");
                salida.println("IMPORTE: " + importe);
                salida.println("\n");
                salida.println("-------------------------------------------------------------------------------");
            }
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        }
    }//fin generaFactura
    
    /**
     *guardar arrayList reservas en copiasegInm
     */
    public static void guardarDatos(){
        try {
            // Si hay datos en al menos una de las listas, las guardamos...
            if (!reservas.isEmpty() /**|| !anfitriones.isEmpty() || !particulares.isEmpty()*/) {
                // Serialización de los objetos
                FileOutputStream ostreamUtilReservas = new FileOutputStream("copiasegRes.dat");
                ObjectOutputStream oosRes = new ObjectOutputStream(ostreamUtilReservas);

                // Guardamos solo las listas que no están vacías
                if (!reservas.isEmpty()) {
                    oosRes.writeObject(reservas);
                }
                /**if (!anfitriones.isEmpty()) {
                    oosUsuar.writeObject(anfitriones);
                }
                if (!particulares.isEmpty()) {
                    oosUsuar.writeObject(particulares);
                }
                */

                oosRes.close();
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
     *carga los arrayList reservas desde el fichero copiasegInm
     */
    public static void cargarDatos() {
        try {
            //Lectura de los objetos de tipo persona
            FileInputStream istreamRes = new FileInputStream("copiasegRes.dat");
            ObjectInputStream oisRes = new ObjectInputStream(istreamRes);
            reservas = (ArrayList) oisRes.readObject();
            istreamRes.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    //Getters & Setters
    public static ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public static void setReservas(ArrayList<Reserva> reservas) {
        UtilReservas.reservas = reservas;
    }
    
}
