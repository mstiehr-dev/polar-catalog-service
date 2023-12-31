package de.mstiehr.polar.catalogservice;

import de.mstiehr.polar.catalogservice.domain.Book;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CatalogServiceApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void contextLoads() {
	}

	@Test
	void whenPostRequestThenBookCreated() {
		var expectedBook = new Book("1231231231", "Title", "Author", 9.90);

		webTestClient
				.post()
				.uri("/books")
				.bodyValue(expectedBook)
				.exchange()
				.expectStatus().isCreated()
				.expectBody(Book.class).value(actualbook -> {
					assertThat(actualbook).isNotNull();
					assertThat(actualbook.isbn()).isEqualTo(expectedBook.isbn());
					assertThat(actualbook.title()).isEqualTo(expectedBook.title());
					assertThat(actualbook.author()).isEqualTo(expectedBook.author());
					assertThat(actualbook.price()).isEqualTo(expectedBook.price());
				});
	}

}
