package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "bookReservationServlet", urlPatterns = "/bookReservation")
public class BookReservationServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final BookReservationService bookReservationService;

    public BookReservationServlet(SpringTemplateEngine springTemplateEngine, BookReservationService bookReservationService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookReservationService = bookReservationService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String readerName = req.getParameter("readerName");
        String bookTitle = req.getParameter("bookTitle");
        String readerAddress = req.getParameter("readerAddress");
        int numCopies = Integer.parseInt(req.getParameter("numCopies"));
        String ipAddress = req.getRemoteAddr();

        if("reserve".equals(req.getParameter("action"))) {
            this.bookReservationService.placeReservation(bookTitle,readerName, readerAddress, numCopies);

            IWebExchange webExchange = JakartaServletWebApplication
                    .buildApplication(getServletContext())
                    .buildExchange(req, resp);

            WebContext context = new WebContext(webExchange);

            context.setVariable("readerName", readerName);
            context.setVariable("ipAddress", ipAddress);
            context.setVariable("bookTitle", bookTitle);
            context.setVariable("numCopies", numCopies);

            springTemplateEngine.process("reservationConfirmation.html", context, resp.getWriter());
        } else if ("seeReservations".equals(req.getParameter("action"))) {
                resp.sendRedirect("/allReservations?bookTitle=" + bookTitle);
        }
    }

}
