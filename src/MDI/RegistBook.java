/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDI;

import Business.GiveMaterialBusiness;
import Domain.ArrayBook;
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
public class RegistBook extends javax.swing.JInternalFrame {

    //atributos
    Book book;
    ArrayBook arrayBook;
    DefaultTableModel myModel;
    String[] upTitlle = {"Nº", "Code", "Tittle", "Type", "Year", "Author's name"};
    String[][] data = {};
    int num = 0;

    //constructor
    public RegistBook() {
        initComponents();
        myModel = new DefaultTableModel(data, upTitlle);
        tblRegisters.setModel(myModel);
        arrayBook = new ArrayBook();
        start();
        updateTable();
        txtCodeBook.requestFocus();
    }

    //metodo para extraer la info del archivo al arreglo de objetos
    public void start() {
        try {
            FileInputStream fileInputStream = new FileInputStream("book.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            if (objectInputStream != null) {
                arrayBook = (ArrayBook) objectInputStream.readObject();
                objectInputStream.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in upload the file.." + ex);
        }
    }

    //metodo para mostrar los mensajes 
    public void message(String text) {
        JOptionPane.showMessageDialog(this, text);
    }

    //metodo para insertar el audiovisual del arreglo al archivo 
    public void saveBook() {
        try {
            FileOutputStream outputStream = new FileOutputStream("book.dat");
            ObjectOutputStream outputStream1 = new ObjectOutputStream(outputStream);
            if (outputStream1 != null) {
                outputStream1.writeObject(arrayBook);
                outputStream1.close();
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
        int n = arrayBook.numBooks();
        for (int i = 0; i < n; i++) {   // Se extrae la informacion de cada objeto del Arreglo
            String codeBook = arrayBook.getBook(i).getCodeBook();
            String nameBok = arrayBook.getBook(i).getNameBook();
            String typeBook = arrayBook.getBook(i).getTypeBook();
            int annoBook = arrayBook.getBook(i).getAnnoBook();
            String authorName = arrayBook.getBook(i).getAuthorName();
            insert(i + 1, codeBook, nameBok, typeBook, annoBook, authorName);
        }
    }

    //metodo para eliminar un registro del archivo a la hora de hacer un prestamo
    public void deleteBook() {
        SearchUnavailabiliity();
        int position = arrayBook.searchBook(txtCodeBook.getText().toUpperCase());
        if (position != -1) {
                arrayBook.deleteBook(position);
                cleanEntries();
                saveBook();
                updateTable();
                txtCodeBook.requestFocus();
                message("borrowed book..");
//            }
        }
    }

    //metodo para modificar el articulo seleccionado
    public void modifyBook() {
        String codeBook = txtCodeBook.getText().toUpperCase();
        int position = arrayBook.searchBook(codeBook);
        String nameBook = txtTittleBook.getText().toUpperCase();
        String typeBook = cbTipeBook.getSelectedItem().toString();
        int annoBook = Integer.parseInt(txtAnnoBook.getText());
        String authorName = txtAuthorNameBook.getText();
        book = new Book(codeBook, nameBook, typeBook, annoBook, authorName);
        if (position == -1) {
            arrayBook.addBook(book);
        } else {
            arrayBook.modifiBook(position, book);
        }
        cleanEntries();
        saveBook();
        updateTable();
        txtCodeBook.requestFocus();
    }

    //metodo para llenar los espacios 
    public void SearchUnavailabiliity() {
        String codeBook = txtCodeBook.getText().toUpperCase();
        int position = arrayBook.searchBook(codeBook);
        if (position == -1) {
            message("Codigo no existe");
            cleanEntries();
        } else {
            book = arrayBook.getBook(position);
            String nameBook = book.getNameBook();
            String typeBook = book.getTypeBook();
            int annoBook = book.getAnnoBook();
            String authorName = book.getAuthorName();
            txtTittleBook.setText(nameBook);
            if (typeBook.equalsIgnoreCase("physical")) {
                cbTipeBook.setSelectedIndex(1);
            } else if (typeBook.equalsIgnoreCase("Digital")) {
                cbTipeBook.setSelectedIndex(2);
            }
            txtTittleBook.setText(nameBook);
            txtAnnoBook.setText(String.valueOf(annoBook));
            txtAuthorNameBook.setText(authorName);
        }
    }

    //metodo para limpiar las entradas
    void cleanEntries() {
        txtCodeBook.setText("");
        txtTittleBook.setText("");
        txtAnnoBook.setText("");
        cbTipeBook.setSelectedIndex(0);
        txtCodeBook.requestFocus(true);
        txtAuthorNameBook.setText("");
    }

    void insert(int num, String codeAV, String nameAV, String typeAV, int anno, String authorName) {
        Object[] line = {num, codeAV, nameAV, typeAV, String.valueOf(anno), authorName};
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

        txtCodeBook = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegisters = new javax.swing.JTable();
        btnSearchBook = new javax.swing.JButton();
        btnForHire = new javax.swing.JButton();
        jlTypeBook = new javax.swing.JLabel();
        txtAnnoBook = new javax.swing.JTextField();
        cbTipeBook = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        btnInsertBook = new javax.swing.JButton();
        txtTittleBook = new javax.swing.JTextField();
        jlTittleBook = new javax.swing.JLabel();
        jlListBooks = new javax.swing.JLabel();
        jlCodeBook = new javax.swing.JLabel();
        btnModificar7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jdLoanDate = new datechooser.beans.DateChooserCombo();
        jdReturnDate = new datechooser.beans.DateChooserCombo();
        jLabel3 = new javax.swing.JLabel();
        txtAuthorNameBook = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Insert & Give Books");

        txtCodeBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodeBookKeyPressed(evt);
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

        btnSearchBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearchBook.setText("Search");
        btnSearchBook.setMaximumSize(new java.awt.Dimension(121, 59));
        btnSearchBook.setMinimumSize(new java.awt.Dimension(21, 59));
        btnSearchBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchBookActionPerformed(evt);
            }
        });

        btnForHire.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnForHire.setText("Give book");
        btnForHire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForHireActionPerformed(evt);
            }
        });

        jlTypeBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlTypeBook.setText("type of book");

        txtAnnoBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAnnoBookKeyPressed(evt);
            }
        });

        cbTipeBook.setBackground(new java.awt.Color(204, 204, 255));
        cbTipeBook.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-----SELECT-------", "Physical", "Digital" }));
        cbTipeBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipeBookActionPerformed(evt);
            }
        });
        cbTipeBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbTipeBookKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("year edicion");

        btnInsertBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInsertBook.setText("Insert Book");
        btnInsertBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertBookActionPerformed(evt);
            }
        });

        txtTittleBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTittleBookKeyPressed(evt);
            }
        });

        jlTittleBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlTittleBook.setText("Tittle");

        jlListBooks.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlListBooks.setText("B o o k ' s   l i s t");

        jlCodeBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlCodeBook.setText("Code");

        btnModificar7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModificar7.setText("Modify");
        btnModificar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar7ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Loan date");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Return date");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Author's name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlCodeBook)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodeBook, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertBook, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(jlTittleBook)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTittleBook, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtAnnoBook, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(249, 249, 249)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jdReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addGap(65, 65, 65)
                                    .addComponent(btnForHire))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtAuthorNameBook, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, Short.MAX_VALUE)
                                    .addComponent(jlTypeBook, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbTipeBook, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(19, 19, 19))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jdLoanDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jlListBooks))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTittleBook)
                    .addComponent(txtTittleBook, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtAnnoBook, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlTypeBook)
                        .addComponent(cbTipeBook, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAuthorNameBook, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertBook, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodeBook, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCodeBook))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdLoanDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnForHire, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlListBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodeBookKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeBookKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeBookKeyPressed

    private void btnSearchBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBookActionPerformed
        SearchUnavailabiliity();
    }//GEN-LAST:event_btnSearchBookActionPerformed

    private void btnForHireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForHireActionPerformed
        try {
            GiveMaterialBusiness giveMaterialBusiness = new GiveMaterialBusiness();
            String codeBook = txtCodeBook.getText().toUpperCase();
            String nameBook = txtTittleBook.getText().toUpperCase();
            String typeBook = cbTipeBook.getSelectedItem().toString();
            String authorName = txtAuthorNameBook.getText();
            int annoBook = Integer.parseInt(txtAnnoBook.getText());
            Book bookMaterial = new Book(codeBook, nameBook, typeBook, annoBook, authorName);
            GiveMaterial material = new GiveMaterial(bookMaterial);
            giveMaterialBusiness.saveObjectMaterial(material);
        } catch (IOException ex) {
            Logger.getLogger(RegistBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        deleteBook();
    }//GEN-LAST:event_btnForHireActionPerformed

    private void txtAnnoBookKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnnoBookKeyPressed

    }//GEN-LAST:event_txtAnnoBookKeyPressed

    private void cbTipeBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipeBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipeBookActionPerformed

    private void cbTipeBookKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbTipeBookKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtAnnoBook.requestFocus();
        }
    }//GEN-LAST:event_cbTipeBookKeyPressed

    private void btnInsertBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertBookActionPerformed
        //Se leen los datos de entrada de los TextField
        String codeBook = txtCodeBook.getText().toUpperCase();
        String nameBook = txtTittleBook.getText().toUpperCase();
        String typeBook = cbTipeBook.getSelectedItem().toString();
        int annoBook = Integer.parseInt(txtAnnoBook.getText());
        String authorName = txtAuthorNameBook.getText();
        book = new Book(codeBook, nameBook, typeBook, annoBook, authorName);
        // Verificando si el codigo existe dentro del arreglo
        if (arrayBook.searchBook(book.getCodeBook()) != -1) {
            message("Codigo Repetido");
        } else {
            arrayBook.addBook(book);
            insert(0, codeBook, nameBook, typeBook, annoBook, authorName);
            cleanEntries();
            saveBook();
            updateTable();
        }
    }//GEN-LAST:event_btnInsertBookActionPerformed

    private void txtTittleBookKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTittleBookKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            cbTipeBook.requestFocus();
        }
    }//GEN-LAST:event_txtTittleBookKeyPressed

    private void btnModificar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar7ActionPerformed
        modifyBook();
    }//GEN-LAST:event_btnModificar7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnForHire;
    private javax.swing.JButton btnInsertBook;
    private javax.swing.JButton btnModificar7;
    private javax.swing.JButton btnSearchBook;
    private javax.swing.JComboBox cbTipeBook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private datechooser.beans.DateChooserCombo jdLoanDate;
    private datechooser.beans.DateChooserCombo jdReturnDate;
    private javax.swing.JLabel jlCodeBook;
    private javax.swing.JLabel jlListBooks;
    private javax.swing.JLabel jlTittleBook;
    private javax.swing.JLabel jlTypeBook;
    private javax.swing.JTable tblRegisters;
    private javax.swing.JTextField txtAnnoBook;
    private javax.swing.JTextField txtAuthorNameBook;
    private javax.swing.JTextField txtCodeBook;
    private javax.swing.JTextField txtTittleBook;
    // End of variables declaration//GEN-END:variables
}
