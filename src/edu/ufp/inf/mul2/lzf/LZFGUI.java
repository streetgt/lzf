package edu.ufp.inf.mul2.lzf;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author tiagocardoso
 */
public class LZFGUI extends javax.swing.JFrame {

    private final static String SUFFIX = ".lzf";
    private final JFileChooser fc = new JFileChooser();
    private boolean openedFile = false;
    private String filename = null;
    private byte[] lzfCompressResult = null;
    private byte[] lzfDecompressResult = null;
    protected static int Sleep = 500;

    /**
     * Creates new form LZFGUI
     */
    public LZFGUI() {
        initComponents();
        initCustomComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOpenFile = new javax.swing.JButton();
        btnSaveFile = new javax.swing.JButton();
        btnCompress = new javax.swing.JButton();
        btnDecompress = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taInput = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taOutput = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        btnOpenFile.setText("Abrir Compressão");
        btnOpenFile.setToolTipText("");
        btnOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenFileActionPerformed(evt);
            }
        });

        btnSaveFile.setText("Guardar Compressão");
        btnSaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveFileActionPerformed(evt);
            }
        });

        btnCompress.setText("Comprimir");
        btnCompress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompressActionPerformed(evt);
            }
        });

        btnDecompress.setText("Descomprimir");

        btnNext.setText("Próximo");

        taInput.setColumns(20);
        taInput.setRows(5);
        jScrollPane2.setViewportView(taInput);

        jLabel1.setText("Input:");

        jLabel2.setText("Output:");

        taOutput.setColumns(20);
        taOutput.setRows(5);
        jScrollPane1.setViewportView(taOutput);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnOpenFile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSaveFile, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(40, 40, 40)
                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnDecompress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCompress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOpenFile, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCompress))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSaveFile)
                            .addComponent(btnDecompress)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNext)
                        .addGap(42, 42, 42)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenFileActionPerformed
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            this.openedFile = true;
            File selectedFile = fc.getSelectedFile();

            filename = selectedFile.getAbsolutePath();

            try {
                FileReader reader = new FileReader(filename);
                BufferedReader br = new BufferedReader(reader);
                taInput.read(br, null);
                br.close();
                System.out.println(taInput.getText());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnOpenFileActionPerformed

    private void btnSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveFileActionPerformed
        if(lzfCompressResult == null) {
            JOptionPane.showMessageDialog(this, "É necessario que já exista alguma string compressa!");
            return;
        }
        
        int result = fc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            
            File selectedFile = fc.getSelectedFile();
            filename = selectedFile.getAbsolutePath();
            
            try {
                    File resultFile = new File(filename + SUFFIX);
                    FileOutputStream out = new FileOutputStream(resultFile);
                    out.write(LZFDecoder.decode(lzfCompressResult));
                    out.close();
                    System.out.println("Wrote in file '" + resultFile.getAbsolutePath() + "'.");
                    
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }//GEN-LAST:event_btnSaveFileActionPerformed

    private void btnCompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompressActionPerformed

        if (this.taInput.getText().length() > 0 || this.openedFile == true) //|| this.openedFile == false
        {
            String output = null;
            byte[] data = null;
            if (this.openedFile == true) {
                try {
                    File src = new File(filename);
                    if (!src.exists()) {
                        System.err.println("File '" + filename + "' does not exist.");
                        System.exit(1);
                    }
                
                    data = readData(src);
                    System.out.println("Read " + data.length + " bytes.");
                    lzfCompressResult = LZFEncoder.encode(data);
                    System.out.println("Processed into " + lzfCompressResult.length + " bytes.");
                    
                    // em lzfResult fica o resultado comprimido
                    output = Utils.bytesToBinaryString(lzfCompressResult);
                    System.out.println(output);
                    
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                
                data = taInput.getText().getBytes();
                System.out.println("Read " + data.length + " bytes.");
                lzfCompressResult = LZFEncoder.encode(data);
                System.out.println("Processed into " + lzfCompressResult.length + " bytes.");
                    
                output = Utils.bytesToBinaryString(lzfCompressResult);
                System.out.println(output);
                  
            }
            
            btnNext.setEnabled(true);
            btnOpenFile.setEnabled(false);
            btnCompress.setEnabled(false);
            btnDecompress.setEnabled(false);
            System.out.println("Começou");
            taOutput.setText(output);
            
        } else {
            JOptionPane.showMessageDialog(this, "Ainda não abriu um ficheiro ou não escreveu nenhuma string de input");
        }
    }//GEN-LAST:event_btnCompressActionPerformed

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
            java.util.logging.Logger.getLogger(LZFGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LZFGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LZFGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LZFGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LZFGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompress;
    private javax.swing.JButton btnDecompress;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOpenFile;
    private javax.swing.JButton btnSaveFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taInput;
    private javax.swing.JTextArea taOutput;
    // End of variables declaration//GEN-END:variables

    private void initCustomComponents() {
        this.btnNext.setEnabled(false);
        this.taOutput.setEnabled(false);
        this.taInput.setEnabled(false);
    }

    private byte[] readData(File in) throws IOException {
        int len = (int) in.length();
        System.out.println("readDates in.length = " + len);
        byte[] result = new byte[len];
        int offset = 0;
        FileInputStream fis = new FileInputStream(in);

        while (len > 0) {
            int count = fis.read(result, offset, len);
            if (count < 0) {
                break;
            }
            len -= count;
            offset += count;
        }
        fis.close();
        if (len > 0) { // should never occur...
            throw new IOException("Could not read the whole file -- received EOF when there was "
                    + len + " bytes left to read");
        }
        return result;
    }
    
    

}
