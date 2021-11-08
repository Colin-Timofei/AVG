package md.tekwill.controller;

import md.tekwill.domain.Book;
import md.tekwill.service.iservice.BookService;
import org.springframework.web.bind.annotation.GetMapping;

public class BookController {

    BookService bookService;

    @GetMapping("/book/{id}")
    public Book find(int id) {
        return bookService.read(id);
    }
}
