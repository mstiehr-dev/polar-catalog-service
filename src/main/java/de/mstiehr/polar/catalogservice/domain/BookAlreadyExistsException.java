package de.mstiehr.polar.catalogservice.domain;

public class BookAlreadyExistsException extends RuntimeException {

    public BookAlreadyExistsException(String isbn) {
        super(String.format("The book with ISBN %s does already exist"));
    }
}
