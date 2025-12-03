package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();
    Optional<Book> findById(Long id);
    List<Book> findAllByAuthor_Id(Long authorId);
    List<Book> findAllByTitleContainingIgnoreCaseAndAverageRatingGreaterThanEqual(String text, Double rating);
    Book saveBook(String title, String genre, double rating, Long authorId);
    Book editBook(Long id, String title, String genre, Double averageRating, Long authorId);
    void deleteById(Long id);
    void likeBook(Long bookId);
}
