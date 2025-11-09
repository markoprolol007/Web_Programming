package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.repository.BookReservationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryBookReservationRepository implements BookReservationRepository {
    @Override
    public BookReservation save(BookReservation reservation) {
        DataHolder.reservations.add(reservation);
        return reservation;
    }

    @Override
    public List<BookReservation> findByBookTitle(String title) {
        return DataHolder.reservations.stream()
                .filter(t -> t.getBookTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
}
