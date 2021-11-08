package md.tekwill.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private LocalDateTime created;
    private LocalDateTime updated;

    private static int contor;

    private Book() {

        id = -1;
    }

    public Book(String name) {

        id = contor++;
        this.name = name;
        created = LocalDateTime.now();
        updated = created;
    }

    public Book(int id, String name, LocalDateTime created, LocalDateTime updated) {

        this.id = id;
        this.name = name;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        return getName().equals(book.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
