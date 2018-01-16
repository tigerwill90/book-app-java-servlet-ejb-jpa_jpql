package ch.sylvainmuller.services;

import ch.sylvainmuller.models.Book;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BookServiceIt {

    public void init();

    public List<Book> getBooks();

    public void newBooks(Book book);

    public void deleteBook(int id);

    public Book findBook(int id);

    public void updateBook(Book book);
}
