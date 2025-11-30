package mk.ukim.finki.wp.wpaud.repository.impl;

import mk.ukim.finki.wp.wpaud.bootstrap.DataHolder;
import mk.ukim.finki.wp.wpaud.model.Category;
import mk.ukim.finki.wp.wpaud.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryCategoryRepositoryImpl implements CategoryRepository {
    @Override
    public Category save(Category category) {
        // Remove existing with same name (prevents duplicates)
        DataHolder.categories.removeIf(c -> c.getName().equals(category.getName()));
        DataHolder.categories.add(category);
        return category;
    }

    @Override
    public List<Category> findAll() {
        return DataHolder.categories;
    }

    @Override
    public Optional<Category> findByName(String name) {
        return DataHolder.categories.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Category> search(String text) {
        return DataHolder.categories.stream()
                .filter(c -> c.getName().contains(text) ||
                        c.getDescription().contains(text))
                .toList();
    }

    @Override
    public void delete(String name) {
        DataHolder.categories.removeIf(c -> c.getName().equals(name));
    }
}