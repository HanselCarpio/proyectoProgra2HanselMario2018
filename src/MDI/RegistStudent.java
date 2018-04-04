/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDI;

import Business.StudentBusinessRAF;
import Domain.Student;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author hansel
 */
public class RegistStudent extends javax.swing.JInternalFrame {

    //atributos
    private StudentBusinessRAF studentBusinessRAF;
    private static int i = 0;

    /**
     * Creates new form RegistStudent
     */
    //constructor
    public RegistStudent() {
        initComponents();
        try {
            this.studentBusinessRAF = new StudentBusinessRAF();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "have an error");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbCareer = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNameStudent = new javax.swing.JTextField();
        txtYear = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdStudent = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Insert students");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Full name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Year");

        cbCareer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbCareer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----SELECT-----", "Agronomia", "Educacion", "Informatica" }));
        cbCareer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCareerActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Career");

        txtYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYearActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Id student");

        txtIdStudent.setEditable(false);

        btnInsert.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNameStudent)
                    .addComponent(txtYear)
                    .addComponent(cbCareer, 0, 159, Short.MAX_VALUE)
                    .addComponent(txtIdStudent))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNameStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCareer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnInsert)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYearActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        try {
            String nameStudent = txtNameStudent.getText();
            String carrerStudent = cbCareer.getSelectedItem().toString();
            int yearStudent = Integer.parseInt(txtYear.getText());
            String idStu = "";
            String idStudent = "";
            String careerStudent = cbCareer.getSelectedItem().toString();
            if (careerStudent.equalsIgnoreCase("Agronomia")) {
                cbCareer.setSelectedIndex(1);
                idStu += "A";
            } else if (careerStudent.equalsIgnoreCase("Educacion")) {
                cbCareer.setSelectedIndex(2);
                idStu += "E";
            } else if (careerStudent.equalsIgnoreCase("Informatica")) {
                cbCareer.setSelectedIndex(3);
                idStu += "I";
            }
            i++;
            idStudent = idStu + (((yearStudent % 10) * 1000) + i);
            System.err.println(idStudent);
            if (studentBusinessRAF.saveStudent(new Student(idStudent, nameStudent, carrerStudent, yearStudent))) {
                JOptionPane.showMessageDialog(this, "Se registró con exito");
                this.txtIdStudent.setText(null);
                this.txtNameStudent.setText(null);
                this.txtIdStudent.setText(idStudent);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar al estudiante");
            this.txtIdStudent.setText(null);
            this.txtNameStudent.setText(null);
            this.txtIdStudent.setText(null);
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void cbCareerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCareerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCareerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JComboBox<String> cbCareer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtIdStudent;
    private javax.swing.JTextField txtNameStudent;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
