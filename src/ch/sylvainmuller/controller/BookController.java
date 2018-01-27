package ch.sylvainmuller.controller;

import static ch.sylvainmuller.utilites.Constants.*;
import ch.sylvainmuller.models.Book;
import ch.sylvainmuller.services.BookService;

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

    private static final long serialVersionUID = 1L;

    @EJB
    private BookService bookService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param = request.getParameter("id");
        if (param != null && !param.isEmpty()) {
            int id = Integer.parseInt(param);
            bookService.deleteBook(id);
        }

        List<Book> books = bookService.getBooks();

        request.setAttribute("books", books);
        request.getRequestDispatcher(WEBINF_PATH + "/book.jsp").forward(request, response);
    }
}
