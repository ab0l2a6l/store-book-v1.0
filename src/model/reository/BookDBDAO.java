package model.reository;

import model.entity.Book;
import model.entity.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDBDAO implements BookDBDAOWrite, BookDBDAORead {

    final String url = "jdbc:mysql://localhost:3306/firstdb";
    final String username = "root";
    final String password = "Am311865186";

    private String query;

    final Connection connection;
    final Statement statement;
    private PreparedStatement stmt;

    public BookDBDAO() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            System.out.println(connection + " connected :)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws Exception {
        statement.close();
        connection.close();
        System.out.println("disconnected :(");
    }

    @Override
    public List<Book> findByALL() throws Exception {
        List<Book> bookList = new ArrayList<>();

        query = "select * from book";
        ResultSet set = statement.executeQuery(query);
        while (set.next()) {
            Book book =new Book();
            book.setBookName(set.getString("book_name"));
            book.setAuthor(set.getString("book_author"));
            book.setId(set.getInt("book_id"));
            book.setGenre(Genre.valueOf(set.getString("book_genre")));
            bookList.add(book);
        }

        return bookList;
    }

    @Override
    public void update(Book book) throws Exception {
        query = "update book set book_name = \"" + book.getBookName() +
                "\" ,book_genre = \"" + book.getGenre() +
                "\" , book_author =  \"" + book.getAuthor() +
                "\" where book_id = " + book.getId();
        statement.executeUpdate(query);
        System.out.println(query);
    }

    @Override
    public void delete(long id) throws Exception {
        query = "delete from book where book_id = " + id;
        statement.executeUpdate(query);

    }

    @Override
    public Book findById(long id) throws Exception {
        query = "select * from book where book_id = " + id;
        System.out.println(query);
        stmt = connection.prepareStatement(query);
        ResultSet set = stmt.executeQuery();

        if (set.next()) {
            Book book = new Book();
            book.setId(set.getInt("book_id"));
            book.setBookName(set.getString("book_name"));
            book.setGenre(Genre.valueOf(set.getString("book_genre")));
            book.setAuthor(set.getString("book_author"));

            return book;
        }
        return null;
    }

    @Override
    public void save(Book book) throws Exception {
        query = "insert into book values (" + book.getId() + "," + "\"" + book.getBookName() + "\"" + "," +
                "\"" + book.getGenre() + "\" , " + "\"" + book.getAuthor() + "\"" + ")";
        System.out.println(query);
        statement.executeUpdate(query);
    }
}
