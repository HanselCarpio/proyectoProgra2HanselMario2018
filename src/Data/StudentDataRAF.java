/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Student;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

/**
 *
 * @author hansel
 */
public class StudentDataRAF {

    //atributos
    private RandomAccessFile archive;
    private String myFilePath;
    private int regSize;
    private int regQuantity;

    //constructor
    public StudentDataRAF() throws IOException {
        this.myFilePath = "student.dad";
        File file = new File(this.myFilePath);
        start(file);
    }

    //se crea el archivo
    private void start(File file) throws IOException {
        this.myFilePath = file.getPath();
        this.regSize = 150;
        if (file.exists() && !file.isFile()) {
            throw new IOException(file.getName() + " archivo invalido");
        } else {
            this.archive = new RandomAccessFile(file, "rw");
            this.regQuantity = (int) Math.ceil((double) this.archive.length() / (double) this.regSize);
        }
    }

    //se guarda el estudiante
    public boolean saveStudent(int position, Student studentRAF) throws IOException {
        if (position >= 0 && position <= regQuantity) {
            if (studentRAF.regSize() > this.regSize) {
                return false;
            } else {
                this.archive.seek(position * this.regSize);
                this.archive.writeUTF(studentRAF.getIdStudent());
                this.archive.writeUTF(studentRAF.getNameStudent());
                this.archive.writeUTF(studentRAF.getCareerStudent());
                this.regQuantity++;
                return true;
            }
        }
        return false;
    }

    public boolean saveStudentAgain(Student studentRAF) throws IOException {
        return saveStudent(this.regQuantity, studentRAF);
    }
}
