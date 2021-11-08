package md.tekwill.service.impl;

import md.tekwill.domain.Book;
import md.tekwill.repository.BookRepository;
import md.tekwill.service.iservice.BookService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

//    Book create(Book newbook) {
//
//        return null;
//    }

    @Override
    public Book read(int id) {
        return bookRepository.findById(id).orElseThrow(null);
    }

    @GetMapping("/book")
    public List<Book> readall() {
        return bookRepository.findAll();
    }
}
