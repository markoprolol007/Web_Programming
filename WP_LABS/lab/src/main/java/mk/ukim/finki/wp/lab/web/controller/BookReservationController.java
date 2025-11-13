package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookReservationController {

    private final BookReservationService bookReservationService;
    private final BookService bookService;

    public BookReservationController(BookReservationService bookReservationService, BookService bookService) {
        this.bookReservationService = bookReservationService;
        this.bookService = bookService;
    }

    @PostMapping("/bookReservation")
    public String createReservation(@RequestParam Long bookId,
                                    @RequestParam Integer numCopies,
                                    @RequestParam String readerName,
                                    @RequestParam String readerAddress,
                                    HttpServletRequest request,
                                    Model model) {
        Book book = bookService.findById(bookId).orElse(null);
        String ipAddress = request.getRemoteAddr();

        var reservation = bookReservationService.placeReservation(book.getTitle(), readerName, readerAddress, numCopies);
        model.addAttribute("reservation", reservation);
        model.addAttribute("ipAddress", ipAddress);
        model.addAttribute("bookTitle", book.getTitle());
        model.addAttribute("numCopies", numCopies);
        model.addAttribute("readerName", readerName);
        model.addAttribute("readerAddress", readerAddress);
        return "reservationConfirmation";
    }

}
