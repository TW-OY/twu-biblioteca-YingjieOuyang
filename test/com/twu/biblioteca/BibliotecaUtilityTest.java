package com.twu.biblioteca;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class BibliotecaUtilityTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    BibliotecaUtility bibliotecaUtilityTestable ;

    @Before
    public void setUpOutStream()
    {
        bibliotecaUtilityTestable = new BibliotecaUtility();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void clearUpOutStream(){
        System.setOut(null);
    }

    @Test
    public void shouldSeeWelcomeMessage() {
        String expectResult = "Welcome to Biblioteca";
        bibliotecaUtilityTestable.showWelcomeMessage();
        assertThat(outContent.toString(), is(expectResult));
    }

    @Test
    public void shouldSeeAllBooksName() {
        String expectResult = "Harry potter1\nHarry potter2\nHarry potter3\n";
        bibliotecaUtilityTestable.showListOfBooks();
        assertThat(outContent.toString(), is(expectResult));
    }

    @Test
    public void shouldSeeAllBooksDetails(){
        String expectResult = "Harry potter1 | J. K. Rowling | 1995\nHarry potter2 | J. K. Rowling | 1996\nHarry potter3 | J. K. Rowling | 1997\n";
        bibliotecaUtilityTestable.showAllBookDetails();
        assertThat(outContent.toString(), is(expectResult));
    }

    @Test
    public void shouldSeeMainMenu() {
        String expectResult = "List Books\n";
        bibliotecaUtilityTestable.showMainMenu();
        assertThat(outContent.toString(), is(expectResult));
    }

    @Test
    public void shouldSeeErrorMessage() {
        String expectResult = "Select a valid option!\n";
        bibliotecaUtilityTestable.showErrorMessage("testString");
        assertThat(outContent.toString(), is(expectResult));
    }

    @Test
    public void shouldRemoveThisBookAfterCheckout() {
        String bookname = "Harry potter1";
        bibliotecaUtilityTestable.checkout(bookname);
        ArrayList<Book> bookList = bibliotecaUtilityTestable.getBookList();
        assertThat(bookList.toString(), not(containsString("Harry potter1")));
    }

    @Test
    public void shouldShowSuccessfulMessageAfterCheckout() {
        String expectMessage = "Thank you! Enjoy the book";
        bibliotecaUtilityTestable.checkout("Harry potter1");
        assertThat(outContent.toString(), is(expectMessage));
    }

    @Test
    public void shouldPrintUnsuccessfulMessageAfterFailedCheckout() {
        String expectMessage = "That book is not available.";
        bibliotecaUtilityTestable.checkout("UnexsitBook");
        assertThat(outContent.toString(), is(expectMessage));
    }


}
