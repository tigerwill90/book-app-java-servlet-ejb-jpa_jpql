package ch.sylvainmuller.listeners;

import ch.sylvainmuller.models.Book;
import ch.sylvainmuller.services.BookService;
import ch.sylvainmuller.utilites.Utility;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;

public class AppContextListener implements ServletContextListener{

    @EJB
    private BookService bookService;

    /**
     * Mocking data for simulate not empty DB on startup
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ArrayList<Book> books = new ArrayList<Book>()
        {{
            add(new Book("Croisière sans escale", "Brian Aldiss", "Brian Aldiss", Utility.intYearToYearDate(1958)));
            add(new Book("La Patrouille du temps", "Poul Anderson", "Bélial", Utility.intYearToYearDate(1960)));
            add(new Book("Le monde s'effondre", "Chinua Achebe", "Éditions Présence africaine", Utility.intYearToYearDate(1958)));
        }};

        for (Book book : books) {
            bookService.newBooks(book);
        }

        System.out.println("Data initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
