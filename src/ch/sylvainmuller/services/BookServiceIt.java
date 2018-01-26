package ch.sylvainmuller.services;

import ch.sylvainmuller.models.Book;

import javax.ejb.Local;
import java.util.List;

public interface BookServiceIt {

    void init();

    List<Book> getBooks();

    void newBooks(Book book);

    void deleteBook(int id);

    Book findBook(int id);

    void updateBook(Book book);
}
