package view;

import common.StaticScanner;
import controler.BookControler;
import model.entity.Book;
import model.entity.Genre;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BookControler bookControler = new BookControler();
        Scanner input = StaticScanner.getData();


        for (; ; ) {
            menu();
            int requestUserForSwitch = input.nextInt();
            input.nextLine();
            switch (requestUserForSwitch) {
                case 1 -> { // insert
                    Book book = new Book();

                    System.out.print("insert book name:");
                    book.setBookName(input.nextLine());

                    System.out.print("insert number of genre (1.Dram 2.Historical 3.Science): ");
                    int temp = input.nextInt();
                    if (temp == 1)
                        book.setGenre(Genre.DRAM);
                    else if (temp == 2)
                        book.setGenre(Genre.HISTORICAL);
                    else if (temp == 3)
                        book.setGenre(Genre.SCIENCE);


                    System.out.print("insert book id: ");
                    book.setId(input.nextLong());
                    input.nextLine();

                    System.out.print("insert author: ");
                    book.setAuthor(input.nextLine());

                    bookControler.save(book);

                }

                case 2 -> {


                }

                case 3 -> {


                }

                case 4 -> {

                }

                case 5 -> {

                }

                case 6 -> {
                    return;
                }

            }

        }
    }

    private static void menu() {
        System.out.println("1.insert");
        System.out.println("2.search");
        System.out.println("3.update");
        System.out.println("4.delete");
        System.out.println("5.show all");
        System.out.println("6.exit");
    }

}