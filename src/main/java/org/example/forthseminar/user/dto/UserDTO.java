package org.example.forthseminar.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.forthseminar.book.dto.BookDTO;
import org.example.forthseminar.book.entity.Book;
import org.example.forthseminar.user.entity.User;

public class UserDTO {
    @Getter
    @Setter
    public static class Create{
        private String name;
        private String major;
        private Integer age;
    }
    @Getter
    @Setter
    @Builder
    public static class Loan{
        private Long userId;
        private Long bookId;
        public static UserDTO.Loan toDTO(User entity, Book book) {
            return Loan.builder()
                    .userId(entity.getUserId())
                    .bookId(book.getBookId())
                    .build();
        }
    }

}
