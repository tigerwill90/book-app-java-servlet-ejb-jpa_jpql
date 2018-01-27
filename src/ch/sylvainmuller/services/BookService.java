package ch.sylvainmuller.services;

import ch.sylvainmuller.models.Book;
import ch.sylvainmuller.utilites.Utility;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Stateless
public class BookService {

    @PersistenceContext(unitName="books-unit")
    private EntityManager em;

    public List<Book> getBooks() {
        return em.createQuery("SELECT b FROM Book AS b").getResultList();
    }

    public void newBooks(Book book) {
        em.persist(book);
    }

    public void deleteBook(int id) {
        Book book = findBook(id);
        if (book != null) {
            em.remove(book);
        }
    }

    public Book findBook(int id) {
        return em.find(Book.class, id);
    }

    public void updateBook(Book book) {
        em.merge(book);
    }
}
