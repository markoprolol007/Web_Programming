package mk.ukim.finki.wp.lab.repository.mock.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.mock.InMemoryBookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryBookRepositoryImpl implements InMemoryBookRepository {
    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        String LowerCaseText = text.toLowerCase();
        return DataHolder.books.stream().filter(b -> b.getTitle().toLowerCase().contains(LowerCaseText) &&
                b.getAverageRating() >= rating).collect(Collectors.toList());
    }

    @Override
    public Book save(Book book) {
        deleteById(book.getId());
        DataHolder.books.add(book);
        return book;
    }

    @Override
    public void deleteById(Long id) {
        DataHolder.books.removeIf(b -> b.getId().equals(id));
    }

    @Override
    public Optional<Book> findById(Long id) {
        return DataHolder.books.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    @Override
    public void like(Long bookId) {
        Optional<Book> bookOpt = DataHolder.books.stream().filter(b -> b.getId().equals(bookId)).findFirst();
        bookOpt.ifPresent(book -> {
            book.setLiked(!book.isLiked());
        });
    }
}
