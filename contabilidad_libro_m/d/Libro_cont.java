/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package contabilidad_libro_m.d;

import Funciones.LLave;
import Funciones.LecturaDeArchivo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author yaser
 */
public class Libro_cont extends javax.swing.JFrame {

    RandomAccessFile file;
    
    public String Archivo1 = "";
    public String Archivo2 = "";

    /**
     * Creates new form Libro_cont
     */
    public Libro_cont() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblArchivo2 = new javax.swing.JLabel();
        lblArchivo1 = new javax.swing.JLabel();
        txtArchivo1 = new javax.swing.JTextField();
        txtArchivo2 = new javax.swing.JTextField();
        btnContinuar = new javax.swing.JButton();
        btnArchivo1 = new javax.swing.JButton();
        btnArchivo2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Libro contabilidad");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 510, 480));
        setMaximumSize(new java.awt.Dimension(510, 480));
        setMinimumSize(new java.awt.Dimension(510, 480));
        setPreferredSize(new java.awt.Dimension(510, 480));
        getContentPane().setLayout(null);

        lblArchivo2.setText("Archivo 2");
        getContentPane().add(lblArchivo2);
        lblArchivo2.setBounds(28, 155, 125, 30);

        lblArchivo1.setText("Archivo 1");
        getContentPane().add(lblArchivo1);
        lblArchivo1.setBounds(28, 46, 164, 30);
        getContentPane().add(txtArchivo1);
        txtArchivo1.setBounds(28, 94, 252, 43);
        getContentPane().add(txtArchivo2);
        txtArchivo2.setBounds(28, 203, 252, 43);

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(btnContinuar);
        btnContinuar.setBounds(170, 340, 150, 45);

        btnArchivo1.setText("Buscar");
        btnArchivo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivo1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnArchivo1);
        btnArchivo1.setBounds(380, 110, 93, 22);

        btnArchivo2.setText("Buscar");
        btnArchivo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivo2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnArchivo2);
        btnArchivo2.setBounds(380, 220, 93, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArchivo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivo1ActionPerformed
        // TODO add your handling code here:
        //estoy creano mi vairable archivo de la clase jfilechooser, con el constructor vacio
        JFileChooser archivo = new JFileChooser();
        archivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        //filtro para permitir que solo acepte los archivos txt
        FileNameExtensionFilter txtfile = new FileNameExtensionFilter("Archivos de Texto plano .txt", "txt");

        //asigne el filtro al selector de archivos
        archivo.setFileFilter(txtfile);

        //el this hace referencia a esta misma clase
        int resultado = archivo.showOpenDialog(this);

        //aqui hacemos la comparacion 
        if (resultado != JFileChooser.CANCEL_OPTION) {
            File file = archivo.getSelectedFile();
            txtArchivo1.setText(file.getAbsolutePath());
            if (file == null || (file.getName().equals(""))) {
                JOptionPane.showMessageDialog(rootPane, "La carga del archivo fue cancelada",
                        "uups! algo malio sal",
                        JOptionPane.ERROR_MESSAGE);
            }
            txtArchivo1.setEditable(false);
        } else {

            JOptionPane.showMessageDialog(rootPane, "La carga del archivo fue cancelada",
                    "uups! algo malio sal",
                    JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnArchivo1ActionPerformed

    private void btnArchivo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivo2ActionPerformed
        // TODO add your handling code here:
        //estoy creano mi vairable archivo de la clase jfilechooser, con el constructor vacio
        JFileChooser archivo = new JFileChooser();
        archivo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        //filtro para permitir que solo acepte los archivos txt
        FileNameExtensionFilter txtfile = new FileNameExtensionFilter("Archivos de Texto plano .txt", "txt");

        //asigne el filtro al selector de archivos
        archivo.setFileFilter(txtfile);

        //el this hace referencia a esta misma clase
        int resultado = archivo.showOpenDialog(this);

        //aqui hacemos la comparacion 
        if (resultado != JFileChooser.CANCEL_OPTION) {
            File file = archivo.getSelectedFile();
            txtArchivo2.setText(file.getAbsolutePath());
            if (file == null || (file.getName().equals(""))) {
                JOptionPane.showMessageDialog(rootPane, "La carga del archivo fue cancelada",
                        "uups! algo malio sal",
                        JOptionPane.ERROR_MESSAGE);
            }
            txtArchivo2.setEditable(false);
        } else {

            JOptionPane.showMessageDialog(rootPane, "La carga del archivo fue cancelada",
                    "uups! algo malio sal",
                    JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnArchivo2ActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
        Archivo1 = txtArchivo1.getText().trim();
        Archivo2 = txtArchivo2.getText().trim();
        if (Archivo1.isEmpty() | Archivo2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Faltan datos por llenar", "Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        LecturaDeArchivo lectu = new LecturaDeArchivo();

        lectu.escribirTxtDat(Archivo1, "llaves1.dat");
        lectu.escribirTxtDat(Archivo2, "llaves2.dat");
        try {
            BufferedReader bf = new BufferedReader(new FileReader(Archivo1));
            BufferedReader bf2 = new BufferedReader(new FileReader(Archivo2));
            
            System.out.println("ARchivo 2");
            lectu.reporte("llaves2.dat");
                    
            System.out.println("orde 1");
            lectu.ordenar("llaves1.dat");
            System.out.println("orde 2");
            lectu.ordenar("llaves2.dat");
            
            System.out.println("datos ordenados 1");
            lectu.reporte("llavesMayor1.dat");
            System.out.println("datos ordenados 2");
            lectu.reporte("llavesDiario2.dat");
            
            System.out.println("Secuencia");
            lectu.Secuencia("llavesMayor1.dat", "llavesDiario2.dat");
            
            
            System.out.println("reporte ordenado");
            lectu.reporte("libroOrdenadoContabilidad.dat");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en algun archivo seleccionado","Error",JOptionPane.ERROR);
            
        }
        
    }//GEN-LAST:event_btnContinuarActionPerformed

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
            java.util.logging.Logger.getLogger(Libro_cont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Libro_cont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Libro_cont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Libro_cont.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Libro_cont().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchivo1;
    private javax.swing.JButton btnArchivo2;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JLabel lblArchivo1;
    private javax.swing.JLabel lblArchivo2;
    private javax.swing.JTextField txtArchivo1;
    private javax.swing.JTextField txtArchivo2;
    // End of variables declaration//GEN-END:variables

}
