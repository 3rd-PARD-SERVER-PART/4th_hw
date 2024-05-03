package org.example.forthseminar.book.repo;

import org.example.forthseminar.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
