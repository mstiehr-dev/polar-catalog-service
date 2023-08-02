package de.mstiehr.polar.catalogservice.domain;

public record Book (
    String isbn,
    String title,
    String author,
    Double price
){}
