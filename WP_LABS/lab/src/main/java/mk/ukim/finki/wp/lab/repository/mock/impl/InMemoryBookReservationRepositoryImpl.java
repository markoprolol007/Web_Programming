package mk.ukim.finki.wp.lab.repository.mock.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.repository.mock.InMemoryBookReservationRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryBookReservationRepositoryImpl implements InMemoryBookReservationRepository {
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
