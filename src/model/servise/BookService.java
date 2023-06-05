package model.servise;

import model.entity.Book;
import model.reository.BookDBDAO;
import model.reository.BookDBDAORead;
import model.reository.BookDBDAOWrite;

import java.util.List;

public class BookService implements BookServiceWrite, BookServiceRead {
    BookDBDAOWrite bookDBDAOWrite;
    BookDBDAORead bookDBDAORead;

    @Override
    public void save(Book book) {
        try {
            bookDBDAOWrite = new BookDBDAO();
            bookDBDAOWrite.save(book);
            bookDBDAOWrite.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Book book) {
        try {
            bookDBDAOWrite = new BookDBDAO();
            bookDBDAOWrite.update(book);
            bookDBDAOWrite.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        try {
            bookDBDAOWrite = new BookDBDAO();
            bookDBDAOWrite.delete(id);
            bookDBDAOWrite.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book findById(long id) {
        Book byId;
        try {
            bookDBDAORead = new BookDBDAO();
            byId = bookDBDAORead.findById(id);
            bookDBDAORead.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return byId;
    }

    @Override
    public List<Book> findByAll() {
        List<Book> bookList;
         try {
             bookDBDAORead = new BookDBDAO();
             bookList = bookDBDAORead.findByALL();
             bookDBDAORead.close();
         }catch (Exception e) {
             throw new RuntimeException(e);
         }
         return bookList;
    }
}
