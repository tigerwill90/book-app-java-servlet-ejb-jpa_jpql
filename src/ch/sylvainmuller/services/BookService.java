package ch.sylvainmuller.services;

import ch.sylvainmuller.models.Book;
import ch.sylvainmuller.utility.utility;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Stateless
public class BookService implements BookServiceIt {

    @PersistenceContext(unitName="books-unit")
    private EntityManager em;

    /**
     * Mock data on start
     */
    public void init() {
        ArrayList<Book> books = new ArrayList<Book>()
                {{
                    add(new Book("Croisière sans escale", "Brian Aldiss", "Brian Aldiss", utility.intYearToYearDate(1958)));
                    add(new Book("La Patrouille du temps", "Poul Anderson", "Bélial", utility.intYearToYearDate(1960)));
                    add(new Book("Le monde s'effondre", "Chinua Achebe", "Éditions Présence africaine", utility.intYearToYearDate(1958)));
                }};

        for (Book book : books) {
            em.persist(book);

        }
    }

    /**
     * Get a list of books
     * @return
     */
    public List<Book> getBooks() {
        return em.createQuery("SELECT b FROM Book AS b").getResultList();
    }

    /**
     * Create a new book
     * @param book
     * @return
     */
    public void newBooks(Book book) {
        em.persist(book);
    }

    /**
     * Delete a book
     * @param id
     */
    public void deleteBook(int id) {
        Book book = findBook(id);
        if (book != null) {
            em.remove(book);
        }
    }

    /**
     * Find a book
     * @param id
     * @return
     */
    public Book findBook(int id) {
        return em.find(Book.class, id);
    }

    /**
     * Update a book
     * @param book
     */
    public void updateBook(Book book) {
        em.merge(book);
    }
}
