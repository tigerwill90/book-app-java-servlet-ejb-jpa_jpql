package ch.sylvainmuller.controller;

import ch.sylvainmuller.models.Book;
import ch.sylvainmuller.services.BookServiceIt;
import ch.sylvainmuller.utility.Utility;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/create")
public class NewBookController extends HttpServlet {

    /** Universal version identifier for Serializable class */
    private static final long serialVersionUID = 1L;

    @EJB
    private BookServiceIt bookService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/newBook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /** Fetch data */
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

        request.setAttribute("books", books);
        request.setAttribute("notif", true);
        request.setAttribute("bookTitle", book.getTitle());
        request.getRequestDispatcher("/WEB-INF/views/book.jsp").forward(request, response);

    }
}
