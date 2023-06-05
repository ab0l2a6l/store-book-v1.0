package controler;

import model.entity.Book;
import model.servise.BookService;
import model.servise.BookServiceWrite;

public class BookControler {
    BookServiceWrite bookServiceWrite = new BookService();

    public void save(Book book) {
        bookServiceWrite.save(book);
    }
}
