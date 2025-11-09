package mk.ukim.finki.wp.wpaud.repository;

import mk.ukim.finki.wp.wpaud.bootstrap.DataHolder;
import mk.ukim.finki.wp.wpaud.model.Category;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryCategoryRepository {

    public Category save(Category category) {
        // Remove any existing category with the same name before adding (prevents duplicates)
        // Note: We're using names as identifiers for simplicity
        // In later lectures you'll learn why unique IDs are the better approach!
        DataHolder.categories.removeIf(c -> c.getName().equals(category.getName()));
        DataHolder.categories.add(category);
        return category;
    }

    public List<Category> findAll() {
        return DataHolder.categories;
    }

    public Optional<Category> findByName(String name) {
        return DataHolder.categories.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst();
    }

    public List<Category> search(String text) {
        return DataHolder.categories.stream().filter(c -> c.getName().contains(text) ||
                c.getDescription().contains(text)).toList();
    }

    public void delete(String name) {
        DataHolder.categories.removeIf(c -> c.getName().equals(name));
    }

}
