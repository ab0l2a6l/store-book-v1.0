package model.servise;

import model.entity.Book;

public interface BookServiceWrite {
    void save(Book book);

    void update(Book book);

    void delete(long id);
}
