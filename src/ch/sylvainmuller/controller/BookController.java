package ch.sylvainmuller.controller;

import static ch.sylvainmuller.utilites.Constants.*;
import ch.sylvainmuller.models.Book;
import ch.sylvainmuller.services.BookServiceIt;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/books")
public class BookController extends HttpServlet {

    /** Universal version identifier for Serializable class */
    private static final long serialVersionUID = 1L;

    @EJB
    private BookServiceIt bookService;

    /**
     * Fetch books list in DB and display it
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        /** Get id of item to delete */
        String param = request.getParameter("id");
        if (param != null && !param.isEmpty()) {
            int id = Integer.parseInt(param);
            bookService.deleteBook(id);
        }

        /** Get books collection */
        List<Book> books = bookService.getBooks();

        /** Set attribute and forward */
        session.setAttribute("books", books);
        request.getRequestDispatcher(WEBINF_PATH + "/book.jsp").forward(request, response);
    }
}
