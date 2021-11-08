package md.tekwill.service.iservice;

import md.tekwill.domain.Book;

import java.util.List;

public interface BookService {

//    Book create(Book newbook);

    Book read(int id);

    List<Book> readall();

//    Book update(int id, Book newbook);
//
//    boolean delete(int id);
}
