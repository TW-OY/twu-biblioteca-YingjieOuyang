package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {
    BibliotecaApp BibliotecaAppTestable = new BibliotecaApp();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private BibliotecaApp bibliotecaAppTestable = new BibliotecaApp();

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
        bibliotecaAppTestable.showWelcomeMessage();
        assertThat(outContent.toString(), is(expectResult));
    }

}
