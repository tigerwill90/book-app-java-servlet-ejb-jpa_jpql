package ch.sylvainmuller.servlets;

import ch.sylvainmuller.models.Book;
import ch.sylvainmuller.services.BookService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/books")
public class BookServlet extends HttpServlet {

    @EJB
    private BookService bookService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("It's ok here");


        List books = bookService.readAll();
        for (Object o : books) {
            System.out.println("yolo 2 : " + o.toString());
        }

        request.setAttribute("books", books);
        request.getRequestDispatcher("book.jsp").forward(request, response);
    }

}
