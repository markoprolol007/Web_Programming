package mk.ukim.finki.wp.wpaud.service;

import mk.ukim.finki.wp.wpaud.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> listCategories();
    Category create(String name, String description);
    Category update(String name, String description);
    void delete(String name);
    List<Category> searchCategories(String text);

}
