package ch.sylvainmuller.controller;

import static ch.sylvainmuller.utilites.Constants.*;

import ch.sylvainmuller.models.Book;
import ch.sylvainmuller.services.BookService;
import ch.sylvainmuller.utilites.Utility;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/create")
public class NewBookController extends HttpServlet {

    /** Universal version identifier for Serializable class */
    private static final long serialVersionUID = 1L;

    @EJB
    private BookService bookService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(WEBINF_PATH + "/newBook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String editor = request.getParameter("editor");
        String strYear = request.getParameter("year");

        /** Check if year is numeric and create new book consequently */
        Book book;
        if (Utility.isNumeric(strYear) && strYear != null && !strYear.isEmpty()) {
            Date year = Utility.intYearToYearDate(Integer.parseInt(strYear));
            book = new Book(title, author, editor, year);
        } else {
            book = new Book(title, author, editor);
        }

        bookService.newBooks(book);

        List<Book> books = bookService.getBooks();

        session.setAttribute("notif", true);
        session.setAttribute("bookTitle",book.getTitle());

        /** Following POST/redirect/GET pattern */
        response.addHeader("Location", request.getContextPath() + "/books");
        response.sendError(303);
    }
}
