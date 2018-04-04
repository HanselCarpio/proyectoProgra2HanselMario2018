/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author hansel
 */
public class GiveMaterial implements Serializable {

    //atributos
    private String loanDate;
    private String returnDate;
    Book book;
    AudioVisual audioVisual;

    //constructor
    public GiveMaterial() {
    }

    //constructores
    public GiveMaterial(String loanDate, String returnDate, Book book) {
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.book = book;
    }

    public GiveMaterial(String loanDate, String returnDate, AudioVisual audioVisual) {
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.audioVisual = audioVisual;
    }

    public GiveMaterial(Book book) {
        this.book = book;
    }

    public GiveMaterial(AudioVisual audioVisualMaterial) {
        this.audioVisual = audioVisual;
    }

    public GiveMaterial(GiveMaterial audioVisualMaterial) {
    }

    //setter & getter
    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public AudioVisual getAudioVisual() {
        return audioVisual;
    }

    public void setAudioVisual(AudioVisual audioVisual) {
        this.audioVisual = audioVisual;
    }

    //toString
    @Override
    public String toString() {
        return "GiveMaterial{" + "loanDate=" + loanDate + ", returnDate=" + returnDate + ", book=" + book + ", audioVisual=" + audioVisual + '}';
    }

}
