package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaUtility {

    private ArrayList<Book> bookList = new ArrayList<>();
    private ArrayList<String> menu= new ArrayList<>();

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public BibliotecaUtility() {
        bookList.add(new Book("Harry potter1", "J. K. Rowling", "1995"));
        bookList.add(new Book("Harry potter2", "J. K. Rowling", "1996"));
        bookList.add(new Book("Harry potter3", "J. K. Rowling", "1997"));
        menu.add("List Books");
    }


    public void showWelcomeMessage() {
        System.out.print("Welcome to Biblioteca");
    }

    public void showListOfBooks() {
        for(Book book : bookList) {
            System.out.println(book.getName());
        }
    }

    public void showAllBookDetails() {
        for(Book book : bookList) {
            System.out.println(book.toString());
        }
    }

    public void showMainMenu() {
        for(String option : menu) {
            System.out.println(option);
        }
    }

    public void showErrorMessage(String consoleInput) {
        for(String option : menu) {
            if(option.equals(consoleInput)) {
                return;
            }
        }
        System.out.println("Select a valid option!");
    }

    public void checkout(String bookname) {
        for(Book book : bookList) {
            if(book.getName() == bookname) {
                bookList.remove(book);
                System.out.print("Thank you! Enjoy the book");
                return;
            }
        }
        System.out.print("That book is not available.");
    }

    public void returnBook(String bookName) {

    }
}
