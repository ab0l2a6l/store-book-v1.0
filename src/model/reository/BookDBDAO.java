package model.reository;

import model.entity.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDBDAO implements BookDBDAOWrite, BookDBDAORead {

    final String url = "jdbc:mysql://localhost:3306/firstdb";
    final String username = "root";
    final String password = "Am311865186";

    private String query;

    final Connection connection;
    final Statement statement;

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
    public void save(Book book) throws Exception {
        query ="insert into book values (" + book.getId()+ "," +"\"" + book.getBookName() +"\""+"," +
               "\"" +  book.getGenre()+ "\" , "+"\"" + book.getAuthor() +"\"" +  ")";
        System.out.println(query);
        statement.executeUpdate(query);
    }
}
