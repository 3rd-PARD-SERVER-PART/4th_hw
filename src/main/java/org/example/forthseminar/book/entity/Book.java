package org.example.forthseminar.book.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.forthseminar.book.dto.BookDTO;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String name;

    @ColumnDefault("0")
    private boolean isLoan;

    public static Book toEntity(BookDTO.Create dto) {
        return Book.builder()
                .name(dto.getName())
                .build();
    }

}
