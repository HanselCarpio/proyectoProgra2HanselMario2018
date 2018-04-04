/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDI;

import Business.GiveMaterialBusiness;
import Domain.ArrayAV;
import Domain.AudioVisual;
import Domain.Book;
import Domain.GiveMaterial;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hansel
 */
public class RegistAudiovisual extends javax.swing.JInternalFrame {

    //atributos
    AudioVisual audioVisual;
    ArrayAV arrayAV;
    DefaultTableModel myModel;
    String[] upTittle = {"#", "Code", "Name of AV", "Type of AV", "year", "Color"};
    String[][] data = {};
    int num = 0;

    //constructor
    public RegistAudiovisual() {
        initComponents();
        myModel = new DefaultTableModel(data, upTittle);
        tblRegisters.setModel(myModel);
        arrayAV = new ArrayAV();
        start();
        updateTable();
        txtCodeAV.requestFocus();
    }

    //metodo para extraer la info del archivo al arreglo de objetos
    public void start() {
        try {
            FileInputStream fis = new FileInputStream("audiovisual.dat");
            ObjectInputStream in = new ObjectInputStream(fis);
            if (in != null) {
                arrayAV = (ArrayAV) in.readObject();
                in.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in upload the file.." + ex);
        }
    }

    //metodo para mostrar los mensajes 
    public void message(String texto) {
        JOptionPane.showMessageDialog(this, texto);
    }

    //metodo para insertar el audiovisual del arreglo al archivo 
    public void saveAuVi() {
        try {
            FileOutputStream fos = new FileOutputStream("audiovisual.dat");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            if (out != null) {
                out.writeObject(arrayAV);
                out.close();
            }
        } catch (IOException ex) {
            message("Error in write on the file.." + ex);
        }
    }

    //Limpia la tabla una vez que se actualiza
    public void endTable() {
        int filas = tblRegisters.getRowCount();
        for (int i = 0; i < filas; i++) {
            myModel.removeRow(0);
        }
    }

    //metodo para actualizar la tabla 
    public void updateTable() {
        endTable();
        int n = arrayAV.numAV();
        for (int i = 0; i < n; i++) {
            String codeAV = arrayAV.getAV(i).getCodeAV();
            String nameAV = arrayAV.getAV(i).getNameAV();
            String typeAV = arrayAV.getAV(i).getTypeAV();
            int annoAV = arrayAV.getAV(i).getAnnoAV();
            String colorAV = arrayAV.getAV(i).getColorAV();
            insertar(i + 1, codeAV, nameAV, typeAV, annoAV, colorAV);
        }
    }

    //metodo para eliminar un registro del archivo a la hora de hacer un prestamo
    public void deleteAV() {
        int position = arrayAV.SearchAV(txtCodeAV.getText().toUpperCase());
        if (position != -1) {
            arrayAV.deleteAV(position);
            cleanEntries();
            saveAuVi();
            updateTable();
            txtCodeAV.requestFocus();
            message("borrowed item audiovisual..");
        }
    }

    //metodo para modificar el articulo seleccionado 
    public void modifyAV() {
        String codeAv = txtCodeAV.getText().toUpperCase();
        int position = arrayAV.SearchAV(codeAv);
        String nameAV = txtNameAV.getText().toUpperCase();
        String typeAV = cbTypeAV.getSelectedItem().toString();
        int annoAV = Integer.parseInt(txtAnnoAV.getText());
        String colorAV = txtColorAV.getText();
        audioVisual = new AudioVisual(codeAv, nameAV, typeAV, annoAV, colorAV);
        if (position == -1) {
            arrayAV.addAV(audioVisual);
        } else {
            arrayAV.modifiAV(position, audioVisual);
        }
        cleanEntries();
        saveAuVi();
        updateTable();
        txtCodeAV.requestFocus();
    }

    //metodo para llenar los espacios
    public void SearchUnavailabiliity() {
        String codeAV = txtCodeAV.getText().toUpperCase();
        int position = arrayAV.SearchAV(codeAV);
        if (position == -1) {
            message("Codigo no existe");
            cleanEntries();
        } else {
            audioVisual = arrayAV.getAV(position);
            String nombre = audioVisual.getNameAV();
            String tipo = audioVisual.getTypeAV();
            int anio = audioVisual.getAnnoAV();
            String colorAV = audioVisual.getColorAV();
            txtNameAV.setText(nombre);
            if (tipo.equalsIgnoreCase("Laptops")) {
                cbTypeAV.setSelectedIndex(1);
            } else if (tipo.equalsIgnoreCase("Proyectores")) {
                cbTypeAV.setSelectedIndex(2);
            } else if (tipo.equalsIgnoreCase("Parlantes")) {
                cbTypeAV.setSelectedIndex(3);
            } else if (tipo.equalsIgnoreCase("CD's")) {
                cbTypeAV.setSelectedIndex(4);
            } else if (tipo.equalsIgnoreCase("DVD's")) {
                cbTypeAV.setSelectedIndex(5);
            }
            txtNameAV.setText(nombre);
            txtAnnoAV.setText(String.valueOf(anio));
            txtColorAV.setText(colorAV);

        }
    }

    //metodo para limpiar las entradas
    void cleanEntries() {
        txtCodeAV.setText("");
        txtNameAV.setText("");
        txtAnnoAV.setText("");
        cbTypeAV.setSelectedIndex(0);
        txtColorAV.setText("");
        txtCodeAV.requestFocus(true);
    }

    void insertar(int num, String codeAV, String nameAV, String typeAV, int anno, String colorAV) {
        Object[] line = {num, codeAV, nameAV, typeAV, String.valueOf(anno), colorAV};
        myModel.addRow(line);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        btnForHire = new javax.swing.JButton();
        txtAnnoAV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNameAV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCodeAV = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegisters = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cbTypeAV = new javax.swing.JComboBox();
        btnRegAV = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        jLabel6 = new javax.swing.JLabel();
        txtColorAV = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Insert & Give Audiovisual");
        setPreferredSize(new java.awt.Dimension(666, 439));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscar.setText("Search");
        btnBuscar.setMaximumSize(new java.awt.Dimension(121, 59));
        btnBuscar.setMinimumSize(new java.awt.Dimension(21, 59));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnForHire.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnForHire.setText("Give Article");
        btnForHire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForHireActionPerformed(evt);
            }
        });

        txtAnnoAV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnnoAVKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Year");

        txtNameAV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameAVKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Brand");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("I t e m   l i s t ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Code");

        txtCodeAV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodeAVKeyPressed(evt);
            }
        });

        tblRegisters.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblRegisters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblRegisters);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("type of art.");

        cbTypeAV.setBackground(new java.awt.Color(204, 204, 255));
        cbTypeAV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----SELECCIONE-------------", "Laptops", "Proyectores", "Parlantes", "CD's", "DVD's" }));
        cbTypeAV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTypeAVActionPerformed(evt);
            }
        });
        cbTypeAV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbTypeAVKeyPressed(evt);
            }
        });

        btnRegAV.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegAV.setText("Insert Article");
        btnRegAV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegAVActionPerformed(evt);
            }
        });

        btnModify.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModify.setText("Modify");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Loan date");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Return date");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Color");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(txtColorAV, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTypeAV, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNameAV, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAnnoAV, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(144, 144, 144)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnForHire))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(30, 30, 30))
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtCodeAV, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnRegAV, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNameAV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtAnnoAV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTypeAV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColorAV, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegAV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtCodeAV, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnForHire, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        SearchUnavailabiliity();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnForHireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForHireActionPerformed
        try {
            GiveMaterialBusiness giveMaterialBusiness = new GiveMaterialBusiness();
            String codeAv = txtCodeAV.getText().toUpperCase();
            String nameAV = txtNameAV.getText().toUpperCase();
            String typeAV = cbTypeAV.getSelectedItem().toString();
            int annoAV = Integer.parseInt(txtAnnoAV.getText());
            String colorAV = txtColorAV.getText();
            AudioVisual audioVisualMaterial = new AudioVisual(codeAv, nameAV, typeAV, annoAV, colorAV);
            GiveMaterial material = new GiveMaterial(audioVisualMaterial);
            giveMaterialBusiness.saveObjectMaterial(material);
        } catch (IOException ex) {
            Logger.getLogger(RegistBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        deleteAV();
    }//GEN-LAST:event_btnForHireActionPerformed

    private void txtAnnoAVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnnoAVKeyPressed

    }//GEN-LAST:event_txtAnnoAVKeyPressed

    private void txtNameAVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameAVKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            cbTypeAV.requestFocus();
        }
    }//GEN-LAST:event_txtNameAVKeyPressed

    private void txtCodeAVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeAVKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeAVKeyPressed

    private void cbTypeAVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTypeAVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTypeAVActionPerformed

    private void cbTypeAVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbTypeAVKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtAnnoAV.requestFocus();
        }
    }//GEN-LAST:event_cbTypeAVKeyPressed

    private void btnRegAVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegAVActionPerformed
        String codeAV = txtCodeAV.getText().toUpperCase();
        String nameAV = txtNameAV.getText().toUpperCase();
        String typeAV = cbTypeAV.getSelectedItem().toString();
        int annoAV = Integer.parseInt(txtAnnoAV.getText());
        String colorAV = txtColorAV.getText();
        audioVisual = new AudioVisual(codeAV, nameAV, typeAV, annoAV, colorAV);
        if (arrayAV.SearchAV(audioVisual.getCodeAV()) != -1) {
            message("Codigo Repetido");
        } else {
            arrayAV.addAV(audioVisual);
            insertar(0, codeAV, nameAV, typeAV, annoAV, colorAV);
            cleanEntries();
            saveAuVi();
            updateTable();
        }
    }//GEN-LAST:event_btnRegAVActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        modifyAV();
    }//GEN-LAST:event_btnModifyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnForHire;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnRegAV;
    private javax.swing.JComboBox cbTypeAV;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRegisters;
    private javax.swing.JTextField txtAnnoAV;
    private javax.swing.JTextField txtCodeAV;
    private javax.swing.JTextField txtColorAV;
    private javax.swing.JTextField txtNameAV;
    // End of variables declaration//GEN-END:variables
}
