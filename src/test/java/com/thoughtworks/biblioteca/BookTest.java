package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eleones on 9/23/15.
 */
public class BookTest {

    PrintStream printStream;
    Book book;

    @Before
    public void init(){
        printStream = mock(PrintStream.class);
        book = new Book("The Hungry Caterpillar", "Eric Carle", "1969", printStream);
    }

    @Test
    public void shouldFormatDetailsIntoColumnsWhenPrintingDetails() {
        book.printDetails();

        verify(printStream).println("The Hungry Caterpillar        | Eric Carle                    | 1969");
    }

    @Test
    public void shouldMarkBookAsCheckedOutAfterCheckingBookOut(){
        book.checkOut();

        assertTrue(book.isCheckedOut());
    }
}