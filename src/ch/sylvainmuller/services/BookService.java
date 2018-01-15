package ch.sylvainmuller.services;

import ch.sylvainmuller.models.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class BookService {

    @PersistenceContext(unitName="books-unit")
    private EntityManager em;

    public List<Book> readAll() {
        System.out.println("Yolo form BookService");
        Book book = new Book();
        book.setAuthor("Alfred");
        book.setEditor("Hitchcock");
        book.setTitle("Le bateau de l'ouest");
        em.persist(book);
        Query query = em.createQuery("SELECT b FROM Book AS b");
        return query.getResultList();
    }

    public void save(Book book) {
        em.persist(book);
    }
}
