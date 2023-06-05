package model.reository;

import model.entity.Book;

import java.util.List;

public interface BookDBDAORead {
    Book findById(long id) throws Exception;

    void close() throws Exception;

    List<Book> findByALL() throws Exception;
}
