package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = new ArrayList<>();
    public static List<BookReservation> reservations = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();

    @PostConstruct
    public void init() {

//        authors.add(new Author("George", "Orwell", "England", "English novelist and essayist, known for his dystopian works."));
//        authors.add(new Author("Jane", "Austen", "England", "Renowned for her novels on the British landed gentry."));
//        authors.add(new Author("J.R.R.", "Tolkien", "England", "Famous for his high-fantasy works including The Hobbit and The Lord of the Rings."));
//
//        books.add(new Book("The Great Gatsby", "Fiction", 4.2, authors.get(0)));
//        books.add(new Book("To Kill a Mockingbird", "Fiction", 4.5, authors.get(1)));
//        books.add(new Book("1984", "Dystopian", 4.4, authors.get(0)));
//        books.add(new Book("Pride and Prejudice", "Romance", 4.3, authors.get(1)));
//        books.add(new Book("The Hobbit", "Fantasy", 4.6, authors.get(2)));
//        books.add(new Book("Sapiens", "Non-Fiction", 4.7, authors.get(0)));
//        books.add(new Book("The Catcher in the Rye", "Fiction", 4.0, authors.get(1)));
//        books.add(new Book("The Alchemist", "Adventure", 4.1, authors.get(0)));
//        books.add(new Book("The Lord of the Rings", "Fantasy", 4.8, authors.get(2)));
//        books.add(new Book("Harry Potter and the Sorcerer's Stone", "Fantasy", 4.9, authors.get(2)));
    }

//    INSERT INTO AUTHOR (NAME, SURNAME, COUNTRY, BIOGRAPHY) VALUES
//        ('George', 'Orwell', 'England', 'English novelist and essayist, known for his dystopian works.'),
//        ('Jane', 'Austen', 'England', 'Renowned for her novels on the British landed gentry.'),
//        ('J.R.R.', 'Tolkien', 'England', 'Famous for his high-fantasy works including The Hobbit and The Lord of the Rings.');
//    INSERT INTO BOOKS (TITLE, GENRE, AVERAGE_RATING, AUTHOR_ID, IS_LIKED) VALUES
//            ('The Great Gatsby', 'Fiction', 4.2, 1, FALSE),
//            ('To Kill a Mockingbird', 'Fiction', 4.5, 2, FALSE),
//            ('1984', 'Dystopian', 4.4, 1, FALSE),
//            ('Pride and Prejudice', 'Romance', 4.3, 2, FALSE),
//            ('The Hobbit', 'Fantasy', 4.6, 3, FALSE),
//            ('Sapiens', 'Non-Fiction', 4.7, 1, FALSE),
//            ('The Catcher in the Rye', 'Fiction', 4.0, 2, FALSE),
//            ('The Alchemist', 'Adventure', 4.1, 1, FALSE),
//            ('The Lord of the Rings', 'Fantasy', 4.8, 3, FALSE),
//            ('Harry Potter and the Sorcerer''s Stone', 'Fantasy', 4.9, 3, FALSE);

}
