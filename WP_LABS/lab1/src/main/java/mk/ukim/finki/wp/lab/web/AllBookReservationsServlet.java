package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "allBookReservationsServlet", urlPatterns = "/allReservations")
public class AllBookReservationsServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final BookReservationService bookReservationService;

    public AllBookReservationsServlet(SpringTemplateEngine springTemplateEngine, BookReservationService bookReservationService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookReservationService = bookReservationService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("bookTitle");

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        context.setVariable("title", title);
        context.setVariable("res", this.bookReservationService.listAllByBookTitle(title));

        springTemplateEngine.process("allReservations.html", context, resp.getWriter());
    }
}
