package Domain;
//Declaracion de librerias adicionales

import Domain.Book;
import java.io.Serializable;
import java.util.ArrayList;

public class ArrayBook implements Serializable {

    //atributos
    private ArrayList<Book> bookList;

    //Constructor
    public ArrayBook() {
        bookList = new ArrayList();// crea el objeto
    }

    // agrega un nuevo Libro
    public void addBook(Book book) {
        bookList.add(book);
    }

    // obtiene un Libro
    public Book getBook(int i) {
        return bookList.get(i);
    }

    // reemplaza un informacion de un libro
    public void modifiBook(int i, Book updateBook) {
        bookList.set(i, updateBook);
    }

    // elimina un libro
    public void deleteBook(int i) {
        bookList.remove(i);
    }

    // elimina todos los libros
    public void deleteBook() {
        for (int i = 0; i < numBooks(); i++) {
            bookList.remove(0);
        }
    }

    // obtiene numero de libros registrado
    public int numBooks() {
        return bookList.size();
    }

    // busca un libro por codigo
    public int searchBook(String codigo) {
        for (int i = 0; i < numBooks(); i++) {
            if (codigo.equalsIgnoreCase(getBook(i).getCodeBook())) {
                return i;
            }
        }
        return -1;
    }
}
