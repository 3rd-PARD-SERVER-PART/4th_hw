package org.example.forthseminar.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.forthseminar.book.entity.Book;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false, name = "user_id")
    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false ,name = "book_id")
    private Book book;

    @ColumnDefault("0")
    private boolean isReturn;

}
