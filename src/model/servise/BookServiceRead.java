package model.servise;

import model.entity.Book;

import java.util.List;

public interface BookServiceRead {
    Book findById(long id);

    List<Book> findByAll();

}
