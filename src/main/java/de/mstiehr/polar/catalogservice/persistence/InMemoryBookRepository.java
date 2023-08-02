package de.mstiehr.polar.catalogservice.persistence;

import de.mstiehr.polar.catalogservice.domain.Book;
import de.mstiehr.polar.catalogservice.domain.BookRepository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryBookRepository implements BookRepository {

    private static final Map<String, Book> books = new ConcurrentHashMap<>();
    @Override
    public Iterable<Book> findAll() {
        return books.values();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        // implementation differs from the book
        return Optional.ofNullable(books.get(isbn));
    }

    @Override
    public boolean existsByIsbn(String isbn) {
        // implementation differs from the book
        return books.containsKey(isbn);
    }

    @Override
    public Book save(Book book) {
        // implementation differs from the book
        return books.put(book.isbn(), book);
    }

    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
    }
}
