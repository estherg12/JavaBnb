package interfaces;

import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import poo.pl2.Anfitrion;
import poo.pl2.Cliente;
import poo.pl2.Particular;
import poo.pl2.UtilUsuarios;

public class ListadoUsuarios extends javax.swing.JDialog {

    private DefaultTableModel dtm = new DefaultTableModel();
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Anfitrion> anfitriones = new ArrayList<>();
    ArrayList<Particular> particulares = new ArrayList<>();
    Frame principal;
    /**
     * Creates new form ListadoUsuarios
     * @param parent
     * @param modal
     */
    public ListadoUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        principal = parent;
        initComponents();
        
        jComboBoxOrden.setSelectedItem(0);
        rellenaTabla(jComboBoxOrden.getSelectedIndex());
        this.setVisible(true);
    }
    
    /**
     *vacía la tabla de filas
     */
    public void limpiaTabla() {
        int filas = dtm.getRowCount();
        for (int i = 0; i < filas; i++) {
            dtm.removeRow(0);
        }
    }
    
    /**
     *rellena la tabla según el criterio (Administrador) anfitriones/particulares
     * @param criterio
     */
    public void rellenaTabla(int criterio) {
        limpiaTabla();
        switch (criterio) {
            case 0 -> {
                String columnasA[] = {"NOMBRE", "DNI", "TELEFONO", "CORREO", "CLAVE", "SUPER"};
                dtm.setColumnIdentifiers(columnasA);
                jTable1.setModel(dtm);
                anfitriones = UtilUsuarios.getAnfitriones();
                limpiaTabla();
                
                String superA = "";
                for (Anfitrion cnt : anfitriones) {
                    if(cnt.isSuperAnfitrion()){
                        superA = "Si";
                    }else{
                        superA = "No";
                    }
                    dtm.addRow(new Object[]{cnt.getNombre(), cnt.getDni(), cnt.getTelefono(), cnt.getCorreoElectronico(), cnt.getClave(), superA});
                }
            }
            case 1 -> {
                String columnasP[] = {"NOMBRE", "DNI", "TELEFONO", "CORREO", "CLAVE"};
                dtm.setColumnIdentifiers(columnasP);
                jTable1.setModel(dtm);
                particulares = UtilUsuarios.getParticulares();
                limpiaTabla();
                
                //String vip = "";
                for (Particular cnt : particulares) {
                    /*
                    if(cnt.isVip()){
                        vip="Si";
                    }else{
                        vip="No";
                    }
                    */
                    dtm.addRow(new Object[]{cnt.getNombre(), cnt.getDni(), cnt.getTelefono(), cnt.getCorreoElectronico(), cnt.getClave()});
                }
            }
            default -> {
                break;
            }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonVer = new javax.swing.JButton();
        jComboBoxOrden = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "DNI", "Telefono", "Correo", "Clave"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        buttonVer.setText("Ver Usuario");
        buttonVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVerActionPerformed(evt);
            }
        });

        jComboBoxOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anfitriones", "Particulares" }));
        jComboBoxOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOrdenActionPerformed(evt);
            }
        });

        jLabel1.setText("FILTRO: Tipos de clientes");

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\Esthe\\OneDrive - Universidad de Alcala\\GISI\\1curso\\Programación\\PL2\\imagenes\\LogoPequeño.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(buttonVer))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20)
                                .addComponent(jComboBoxOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel19)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonVer)
                .addGap(13, 13, 13))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVerActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "No hay usuario seleccionado.", "Mensaje", JOptionPane.ERROR_MESSAGE);
        } else {
            switch (jComboBoxOrden.getSelectedIndex()) {
                case 0 -> {
                    Anfitrion anfit = anfitriones.get(fila);
                    ConsultarAnfitrion c = new ConsultarAnfitrion(principal, true, anfit);
                }
                case 1 -> {
                    Particular partic = particulares.get(fila);
                    ConsultarParticular c = new ConsultarParticular(principal, true, partic);
                }
                default -> {
                    break;
                }
            }
            
        }
    }//GEN-LAST:event_buttonVerActionPerformed

    private void jComboBoxOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOrdenActionPerformed
        // TODO add your handling code here:
        rellenaTabla(jComboBoxOrden.getSelectedIndex());
    }//GEN-LAST:event_jComboBoxOrdenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListadoUsuarios dialog = new ListadoUsuarios(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonVer;
    private javax.swing.JComboBox<String> jComboBoxOrden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
