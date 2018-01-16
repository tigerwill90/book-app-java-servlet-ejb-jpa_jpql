package ch.sylvainmuller.controller;

import ch.sylvainmuller.models.Book;
import ch.sylvainmuller.services.BookServiceIt;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/books", loadOnStartup = 1)
public class BookController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private BookServiceIt bookService;

    public void init(ServletConfig config) {
        bookService.init();
        System.out.println("Data initialized");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /** Get id of item to delete */
        String param = request.getParameter("id");
        if (param != null && !param.isEmpty()) {
            int id = Integer.parseInt(param);
            bookService.deleteBook(id);
        }

        /** Get books collection */
        List<Book> books = bookService.getBooks();

        /** Set attribute and forward */
        request.setAttribute("books", books);
        request.getRequestDispatcher("/resources/book.jsp").forward(request, response);
    }



}
