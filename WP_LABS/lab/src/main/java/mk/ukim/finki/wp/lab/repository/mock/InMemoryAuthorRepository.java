package mk.ukim.finki.wp.lab.repository.mock;

import mk.ukim.finki.wp.lab.model.Author;

import java.util.List;
import java.util.Optional;

public interface InMemoryAuthorRepository {
    public List<Author> findAll();
    Optional<Author> findById(Long id);
}
