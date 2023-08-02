package de.mstiehr.polar.catalogservice.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookNotFoundExceptionTest {

    @Test
    public void testConstructor() {
        var e = new BookNotFoundException("1234");
        assertEquals("The book with ISBN 1234 was not found", e.getMessage());
    }
}