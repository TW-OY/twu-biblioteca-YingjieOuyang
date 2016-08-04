package com.twu.biblioteca;

import com.sun.org.apache.xerces.internal.util.PropertyState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BibliotecaUtilityTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    BibliotecaUtility bibliotecaUtilityTestable = new BibliotecaUtility();

    @Before
    public void setUpOutStream(){
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void clearUpOutStream(){
        System.setOut(null);
    }

    @Test
    public void showWelcomeMessageTest() throws Exception {
        String expectResult = "Welcome to Biblioteca";
        bibliotecaUtilityTestable.showWelcomeMessage();
        assertThat(outContent.toString(), is(expectResult));
    }

    @Test
    public void showListofBooksTest() {
        String expectResult = "Harry potter1\nHarry potter2\nHarry potter3\n";
        bibliotecaUtilityTestable.showListOfBooks();
        assertThat(outContent.toString(), is(expectResult));
    }

}
