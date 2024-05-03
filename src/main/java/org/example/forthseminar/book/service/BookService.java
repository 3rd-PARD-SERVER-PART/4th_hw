package org.example.forthseminar.book.service;

import lombok.RequiredArgsConstructor;
import org.example.forthseminar.book.dto.BookDTO;
import org.example.forthseminar.book.entity.Book;
import org.example.forthseminar.book.repo.BookRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepo bookRepo;

    public void createBook(BookDTO.Create dto) {
        bookRepo.save(Book.toEntity(dto));
    }
}
