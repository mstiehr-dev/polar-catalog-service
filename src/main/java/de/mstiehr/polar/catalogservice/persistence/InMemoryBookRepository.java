package de.mstiehr.polar.catalogservice.persistence;

import de.mstiehr.polar.catalogservice.domain.Book;
import de.mstiehr.polar.catalogservice.domain.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;



@Repository
public class InMemoryBookRepository implements BookRepository {

    private final static Logger log = LoggerFactory.getLogger(InMemoryBookRepository.class);

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
        books.put(book.isbn(), book);

        return book;
    }

    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
    }
}
