package mk.ukim.finki.wp.lab.repository.jpa;

import jakarta.transaction.Transactional;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByTitleContainingIgnoreCaseAndAverageRatingGreaterThanEqual(String text, Double rating);
    List<Book> findAllByAuthor_Id(Long authorId);
    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.liked = CASE WHEN b.liked = true THEN false ELSE true END WHERE b.id = :id")
    void likeBook(@Param("id") Long bookId);
}
