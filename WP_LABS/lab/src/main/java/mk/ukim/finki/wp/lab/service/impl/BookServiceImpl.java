package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.jpa.BookRepository;
import mk.ukim.finki.wp.lab.repository.mock.impl.InMemoryBookRepositoryImpl;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<Book> findAllByTitleContainingIgnoreCaseAndAverageRatingGreaterThanEqual(String text, Double rating) {
        return this.bookRepository.findAllByTitleContainingIgnoreCaseAndAverageRatingGreaterThanEqual(text, rating);
    }

    public List<Book> findAllByAuthor_Id(Long authorId) {
        return this.bookRepository.findAllByAuthor_Id(authorId);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }


    @Override
    public Book saveBook(String title, String genre, double rating, Long authorId) {
        Author author = authorService.findById(authorId);
        Book book = new Book(title, genre, rating, author);
        return bookRepository.save(book);
    }

    @Override
    public Book editBook(Long id, String title, String genre, Double averageRating, Long authorId) {
        Book book = bookRepository.findById(id).orElseThrow();
        Author author = authorService.findById(authorId);
        book.setTitle(title);
        book.setGenre(genre);
        book.setAverageRating(averageRating);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void likeBook(Long bookId) {
        bookRepository.likeBook(bookId);
    }
}
