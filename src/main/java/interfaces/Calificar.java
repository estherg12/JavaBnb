
package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import poo.pl2.Calificacion;
import poo.pl2.Particular;
import poo.pl2.Reserva;
import poo.pl2.UtilInmuebles;

public class Calificar extends javax.swing.JDialog {

    private int calificacion = 0;
    private String comentario = "";
    Frame principal;
    private Reserva reserva;
    private Particular particular;
    /**
     * Creates new form Calificar
     * @param parent
     * @param modal
     */
    
    public Calificar(java.awt.Frame parent, boolean modal){
        super(parent, modal);
        initComponents();
        initUI();
        this.setVisible(true);
    }
    
    public Calificar(java.awt.Frame parent, boolean modal, Reserva res, Particular partic){
        super(parent, modal);
        initComponents();
        
        ArrayList<Calificacion> calificaciones = UtilInmuebles.getCalificaciones();
        
        //comprobar que el particular no ha calificado ya la reserva
        for(Calificacion calif: calificaciones){
            if(calif.getParticular().getCorreoElectronico().equals(partic.getCorreoElectronico())&&calif.getInmueble().getTitulo().equals(res.getInmuebleDatos().getTitulo())){
                JOptionPane.showMessageDialog(principal, "Ya existe una calificación de este usuario al mismo inmueble.", "Mensaje", JOptionPane.ERROR_MESSAGE);
                dispose();
            }
        }
        
        initUI();
        
        reserva = res;
        particular = partic;
        
        this.setVisible(true);
    }
    
    /**
     *inicia los componentes de las estrellas, el área de texto y el botón de guardar
     */
    public void initUI(){
        setSize(300, 200);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
         // Panel para las estrellas
        JPanel panelEstrellas = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JLabel[] estrellas = new JLabel[5];
        for(int i=0; i<estrellas.length; i++){
            estrellas[i] = new JLabel("\u2606");//estrella vacía
            estrellas[i].setFont(new Font("SansSerif",Font.PLAIN,30));
            final int index = i+1;
            estrellas[i].addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    // Al pasar el ratón, coloreamos las estrellas hasta la que está siendo apuntada
                    for(int j=0; j<index; j++){
                        estrellas[j].setText("\u2605"); //estrella llena
                        repaint();
                    }
                }
                
                @Override
                public void mouseExited(MouseEvent e){
                    // Al salir el ratón, restauramos las estrellas a su estado original
                    for (int j = 0; j < estrellas.length; j++) {
                        if (j < calificacion) {
                            estrellas[j].setText("\u2605"); // estrella llena
                        } else {
                            estrellas[j].setText("\u2606"); // estrella vacía
                        }
                    }
                }
                
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Al hacer clic, guardamos la calificación
                    calificacion = index;
                    
                    // Coloreamos las estrellas hasta la calificación
                    for (int j = 0; j < estrellas.length; j++) {
                        if (j < calificacion) {
                            estrellas[j].setText("\u2605"); // estrella llena
                        } else {
                            estrellas[j].setText("\u2606"); // estrella vacía
                        }
                    }
                }
            });
            panelEstrellas.add(estrellas[i]);
        }
        
        JTextArea textAreaComentario = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textAreaComentario);
        
        // Botón Guardar
        JButton buttonGuardar = new JButton("Guardar");
        buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comentario = textAreaComentario.getText();
                JOptionPane.showMessageDialog(principal, 
                        "Comentario: "+comentario+". Calificacion: "+calificacion
                        , "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                
                try{
                    UtilInmuebles.añadirCalificacion(reserva, calificacion, comentario, particular);
                    dispose();
                }catch (Exception exp) {
                    JOptionPane.showMessageDialog(Calificar.this, 
                            "Excepción al calificar: " + exp.getMessage(), 
                            "Mensaje", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Error: " + exp.toString());
                }
                
            }
        });
        
        //agregar componentes al JDIalog
        add(panelEstrellas, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonGuardar, BorderLayout.SOUTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Esthe\\OneDrive - Universidad de Alcala\\GISI\\1curso\\Programación\\PL2\\imagenes\\LogoPequeño.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(310, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(276, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Calificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Calificar dialog = new Calificar(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
