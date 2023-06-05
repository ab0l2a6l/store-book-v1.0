package controler;

import model.entity.Book;
import model.servise.BookService;
import model.servise.BookServiceRead;
import model.servise.BookServiceWrite;

import java.util.List;

public class BookControler {
    BookServiceWrite bookServiceWrite = new BookService();
    BookServiceRead bookServiceRead = new BookService();

    public void save(Book book) {
        bookServiceWrite.save(book);
    }

    public Book findById(long id) {
        return bookServiceRead.findById(id);
    }

    public void update(Book book) {
        bookServiceWrite.update(book);
    }

    public void delete(long id) {
        bookServiceWrite.delete(id);
    }

    public List<Book> findByAll() {
        return bookServiceRead.findByAll();
    }
}
