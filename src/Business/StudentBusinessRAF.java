/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.StudentDataRAF;
import Domain.Student;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hansel
 */
public class StudentBusinessRAF {

    //atributos
    private StudentDataRAF studentDataRAF;
    private ArrayList<Student> StudentsReg;

    //constructores
    public StudentBusinessRAF() throws IOException {
        this.studentDataRAF = new StudentDataRAF();
    }

    public boolean saveStudent(Student studentRAF) throws IOException {
        return this.studentDataRAF.saveStudentAgain(studentRAF);
    }
}
