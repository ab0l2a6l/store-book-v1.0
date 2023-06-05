package model.reository;

import model.entity.Book;

public interface BookDBDAOWrite {
    void save(Book book)throws Exception;
    void close()throws  Exception;
}
