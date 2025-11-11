package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping()
    public String getBooksPage(@RequestParam(required = false) String error,
                               @RequestParam(required = false) String search,
                               @RequestParam(required = false) Double rating,
                               Model model){
        if (error != null) {
            model.addAttribute("error", error);
        }
        List<Book> books;
        if (search == null || search.isEmpty() || rating == null) {
            books = bookService.listAll();
        } else {
            books = bookService.searchBooks(search, rating);
        }
        model.addAttribute("books", books);
        return "listBooks";
    }

    @PostMapping("/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId){
        bookService.saveBook(title, genre, averageRating, authorId);
        return "redirect:/books";
    }

    @GetMapping("/add")
    public String getAddBookPage(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @PostMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId){
        bookService.editBook(bookId, title, genre, averageRating, authorId);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String getEditBookForm(@PathVariable Long id, Model model) {
        return bookService.findById(id).map(book -> {
            model.addAttribute("book", book);
            model.addAttribute("authors", authorService.findAll());
            return "book-form";
        }).orElse("redirect:/books?error=BookNotFound");
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteById(id);
        return "redirect:/books";
    }

}
