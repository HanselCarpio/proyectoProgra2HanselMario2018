/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;

/**
 *
 * @author hanse
 */
public class Student implements Serializable {

    //atributos
    private String idStudent;
    private String nameStudent;
    private String careerStudent;
    private int yearStudent;
    private int posicion;

    //constructores
    public Student() {
    }

    public Student(String idStudent, String nameStudent, String careerStudent, int yearStudent) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.careerStudent = careerStudent;
        this.yearStudent = yearStudent;
    }

    //getter & setter 
    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getCareerStudent() {
        return careerStudent;
    }

    public void setCareerStudent(String careerStudent) {
        this.careerStudent = careerStudent;
    }

    public int getYearStudent() {
        return yearStudent;
    }

    public void setYearStudent(int yearStudent) {
        this.yearStudent = yearStudent;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    //toString
    @Override
    public String toString() {
        return "Student{" + "idStudent=" + idStudent + ", nameStudent=" + nameStudent + ", careerStudent=" + careerStudent + ", yearStudent=" + yearStudent + ", posicion=" + posicion + '}';
    }

    //para agarrar el tamaño de los registros
    public int regSize() {
        return this.idStudent.length() * 2 + this.nameStudent.length() * 2 + this.careerStudent.length() * 2 + 20;
    }

}
