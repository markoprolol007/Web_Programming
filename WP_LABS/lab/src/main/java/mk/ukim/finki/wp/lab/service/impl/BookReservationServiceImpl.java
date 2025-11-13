package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.repository.impl.InMemoryBookReservationRepository;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookReservationServiceImpl implements BookReservationService {

    private final InMemoryBookReservationRepository bookReservationRepository;

    public BookReservationServiceImpl(InMemoryBookReservationRepository bookReservationRepository) {
        this.bookReservationRepository = bookReservationRepository;
    }

    @Override
    public BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies) {
        BookReservation reservation = new BookReservation(bookTitle, readerName, readerAddress, (long) numberOfCopies);
        return this.bookReservationRepository.save(reservation);
    }

    @Override
    public List<BookReservation> listAllByBookTitle(String title) {
        return this.bookReservationRepository.findByBookTitle(title);
    }
}
