package mk.ukim.finki.wp.wpaud.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Generates getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor
public class Category {
    private String name;
    private String description;
}
