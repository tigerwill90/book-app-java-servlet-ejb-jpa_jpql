package ch.sylvainmuller.listeners;

import ch.sylvainmuller.services.BookServiceIt;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener implements ServletContextListener{

    @EJB
    private BookServiceIt bookService;

    /**
     * Mocking data by Listener
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        bookService.init();
        System.out.println("Data initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {}
}
