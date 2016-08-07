package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaUtility {

    private ArrayList<Book> availableBookList = new ArrayList<>();
    private ArrayList<Book> checkedOutBookList = new ArrayList<>();
    private ArrayList<String> menu= new ArrayList<>();

    public ArrayList<Book> getCheckedOutBookList() {
        return checkedOutBookList;
    }

    public ArrayList<Book> getAvailableBookList() {
        return availableBookList;
    }

    public BibliotecaUtility() {
        availableBookList.add(new Book("Harry potter1", "J. K. Rowling", "1995"));
        availableBookList.add(new Book("Harry potter2", "J. K. Rowling", "1996"));
        availableBookList.add(new Book("Harry potter3", "J. K. Rowling", "1997"));
        menu.add("List Books");
    }


    public void showWelcomeMessage() {
        System.out.print("Welcome to Biblioteca");
    }

    public void showListOfBooks() {
        for(Book book : availableBookList) {
            System.out.println(book.getName());
        }
    }

    public void showAllBookDetails() {
        for(Book book : availableBookList) {
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
        for(Book book : availableBookList) {
            if(book.getName() == bookname) {
                availableBookList.remove(book);
                checkedOutBookList.add(book);
                System.out.println("Thank you! Enjoy the book");
                return;
            }
        }
        System.out.println("That book is not available.");
    }

    public void returnBook(String bookName) {
        for(Book book : checkedOutBookList) {
           if(book.getName() == bookName) {
               checkedOutBookList.remove(book);
               availableBookList.add(book);
               System.out.println("Thank you for returning the book.");
               return;
           }
        }
        System.out.println("That is not a valid book to return.");
    }
}
