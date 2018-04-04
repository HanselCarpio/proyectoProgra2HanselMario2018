package Domain;

import java.io.Serializable;
import java.text.DateFormat;
import javax.swing.*;

public class Book implements Serializable {

    // atributos    
    private String codeBook;
    private String nameBook;
    private String typeBook;
    private int annoBook;
    private String authorName;

    // constructor vacio
    public Book() {
    }

    // constructor con parametros   
    public Book(String codeBook, String nameBook, String typeBook, int annoBook, String authorName) {
        this.codeBook = codeBook;
        this.nameBook = nameBook;
        this.typeBook = typeBook;
        this.annoBook = annoBook;
        this.authorName = authorName;
    }

    //setter & getter
    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getTypeBook() {
        return typeBook;
    }

    public void setTypeBook(String typeBook) {
        this.typeBook = typeBook;
    }

    public int getAnnoBook() {
        return annoBook;
    }

    public void setAnnoBook(int annoBook) {
        this.annoBook = annoBook;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    //toString
    @Override
    public String toString() {
        return "Book{" + "codeBook=" + codeBook + ", nameBook=" + nameBook + ", typeBook=" + typeBook + ", annoBook=" + annoBook + ", authorName=" + authorName + '}';
    }

}
