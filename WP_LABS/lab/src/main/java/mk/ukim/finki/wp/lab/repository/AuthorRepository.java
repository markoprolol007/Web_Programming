package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    public List<Author> findAll();
    Optional<Author> findById(Long id);
}
