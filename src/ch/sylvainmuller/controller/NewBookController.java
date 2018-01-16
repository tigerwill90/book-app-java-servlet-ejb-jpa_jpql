package ch.sylvainmuller.controller;

import ch.sylvainmuller.models.Book;
import ch.sylvainmuller.services.BookServiceIt;

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
    private static final long serialVersionUID = 1L;

    @EJB
    private BookServiceIt bookService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("newBook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String editor = request.getParameter("editor");
        Date year = new Date(Integer.parseInt(request.getParameter("year")));

        Book book = new Book(title, author, editor, year);

        bookService.newBooks(book);

        List<Book> books = bookService.getBooks();

        request.setAttribute("books", books);
        request.getRequestDispatcher("book.jsp").forward(request, response);

    }
}
