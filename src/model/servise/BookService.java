package model.servise;

import model.entity.Book;
import model.reository.BookDBDAO;
import model.reository.BookDBDAORead;
import model.reository.BookDBDAOWrite;

import java.sql.SQLException;

public class BookService implements BookServiceWrite , BookServiceRead{
    BookDBDAOWrite bookDBDAOWrite;
    BookDBDAORead bookDBDAORead;

    @Override
    public void save(Book book) {
        try {
            bookDBDAOWrite = new BookDBDAO();
            bookDBDAOWrite.save(book);
            bookDBDAOWrite.close();
        }catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}
