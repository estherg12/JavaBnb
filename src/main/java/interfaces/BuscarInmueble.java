package interfaces;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import poo.pl2.Inmueble;
import poo.pl2.UtilInmuebles;

public class BuscarInmueble extends javax.swing.JPanel {

    Frame principal;
    /**
     * Creates new form BuscarInmueble
     */
    public BuscarInmueble() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        calenFechaSalida = new com.toedter.calendar.JCalendar();
        calenFechaEntrada = new com.toedter.calendar.JCalendar();
        fieldCiudad = new javax.swing.JTextField();
        buttonBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Ciudad");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Fecha Entrada");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Fecha Salida");

        calenFechaSalida.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        calenFechaSalida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        calenFechaSalida.setSundayForeground(new java.awt.Color(0, 0, 255));
        calenFechaSalida.setWeekOfYearVisible(false);

        calenFechaEntrada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        calenFechaEntrada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        calenFechaEntrada.setSundayForeground(new java.awt.Color(0, 0, 255));
        calenFechaEntrada.setWeekOfYearVisible(false);

        fieldCiudad.setToolTipText("Ciudad");

        buttonBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonBuscar.setForeground(new java.awt.Color(56, 91, 253));
        buttonBuscar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Esthe\\OneDrive - Universidad de Alcala\\GISI\\1curso\\Programación\\PL2\\imagenes\\busquedaPequeña.png")); // NOI18N
        buttonBuscar.setText("BUSCAR");
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Esthe\\OneDrive - Universidad de Alcala\\GISI\\1curso\\Programación\\PL2\\imagenes\\LogoPequeño.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(fieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(calenFechaEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calenFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(357, 357, 357)
                .addComponent(buttonBuscar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(calenFechaEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calenFechaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonBuscar)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed
        // TODO add your handling code here:
        String ciudad = fieldCiudad.getText();
        Date fechaEntrada = calenFechaEntrada.getDate();
        Date fechaSalida = calenFechaSalida.getDate();
        
        String orden = "";
        String tipo = "";
        
        ArrayList<Inmueble> inmDispo = UtilInmuebles.buscarInmueblesDisponibles(ciudad, fechaEntrada, fechaSalida);
        System.out.println(inmDispo);
        System.out.println(fechaEntrada);
        System.out.println(fechaSalida);
        
        if(inmDispo.isEmpty()){
            JOptionPane.showMessageDialog(this, "No hay inmuebles disponibles.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        }else{
            String[] ordenes = {"Precio", "Tipo", "Calificacion"};
            // Mostrar el JOptionPane y guardar la opción seleccionada
            int selectedOrden = JOptionPane.showOptionDialog(
                    null, // Componente padre (null para centrar en la pantalla)
                    "Filtrar los inmuebles por:", // Mensaje
                    "Orden de inmuebles", // Título del diálogo
                    JOptionPane.DEFAULT_OPTION, // Tipo de opción
                    JOptionPane.INFORMATION_MESSAGE, // Tipo de mensaje
                    null, // Icono (null para el icono predeterminado)
                    ordenes, // Opciones
                    ordenes[0] // Opción predeterminada
            );
            if(selectedOrden==1){
                orden = "Tipo";
                
                String[] opcionesTipos = {"Casa", "Apartamento"};
                int selectedTipo = JOptionPane.showOptionDialog(
                null,"Tipo de inmueble: ","Elegir tipo",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,
                        opcionesTipos,opcionesTipos[0]);
                
                if(selectedTipo==0){
                    tipo = "Casa";
                }else if(selectedTipo==1){
                    tipo = "Apartamento";
                }
            }else{
                tipo = "";
                if(selectedOrden==0){
                    orden = "Precio";
                }else if(selectedOrden==2){
                    orden = "Calificacion";
                }
            }
            ConsultarInmuebles ci = new ConsultarInmuebles(principal, true, inmDispo, fechaEntrada, fechaSalida, orden, tipo);
            ci.setVisible(true);
        }
    }//GEN-LAST:event_buttonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBuscar;
    private com.toedter.calendar.JCalendar calenFechaEntrada;
    private com.toedter.calendar.JCalendar calenFechaSalida;
    private javax.swing.JTextField fieldCiudad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

    //Getters & Setters
    public String getFieldCiudad(){
        return fieldCiudad.getText();
    }
    
    public void setFieldCiudad(String txt){
        fieldCiudad.setText(txt);
    }
    
    public Date getFechaEntrada(){
        return calenFechaEntrada.getDate();
    }
    
    public void setFechaEntrada(Date fechaEn){
        calenFechaEntrada.setDate(fechaEn);
    }
    
    public Date getFechaSalida(){
        return calenFechaSalida.getDate();
    }
    
    public void setFechaSalida(Date fechaSal){
        calenFechaSalida.setDate(fechaSal);
    }
}
