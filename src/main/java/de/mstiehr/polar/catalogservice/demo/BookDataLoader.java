package de.mstiehr.polar.catalogservice.demo;

import de.mstiehr.polar.catalogservice.domain.Book;
import de.mstiehr.polar.catalogservice.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        var book1 = new Book("1234567891", "Northern Lights", "Lyra Silverstar", 9.90);
        var book2 = new Book("1122334455", "180 Grad Meer", "Sarah Kuttner", 19.90);

        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}
