package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaUtility {
    private ArrayList<Book> bookList = new ArrayList<>();

    public BibliotecaUtility() {
        bookList.add(new Book("Harry potter1", "J. K. Rowling", "1995"));
        bookList.add(new Book("Harry potter2", "J. K. Rowling", "1996"));
        bookList.add(new Book("Harry potter3", "J. K. Rowling", "1997"));
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


}
