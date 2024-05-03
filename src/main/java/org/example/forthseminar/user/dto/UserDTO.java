package org.example.forthseminar.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.forthseminar.book.dto.BookDTO;
import org.example.forthseminar.book.entity.Book;
import org.example.forthseminar.user.entity.User;
import org.example.forthseminar.user.entity.UserLoanHistory;

import java.util.List;

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
        public static UserDTO.Loan toDTO(UserLoanHistory entity) {
            return Loan.builder()
                    .userId(entity.getUser().getUserId())
                    .bookId(entity.getBook().getBookId())
                    .build();
        }
    }

    @Getter
    @Setter
    @Builder
    public static class LoanRead{
        private String userName;
        private String bookName;
        private boolean isLoan;
        public static UserDTO.LoanRead toDTO(UserLoanHistory entity) {
            return LoanRead.builder()
                    .userName(entity.getUser().getName())
                    .bookName(entity.getBook().getName())
                    .isLoan(entity.getBook().isLoan())
                    .build();
        }
    }

    @Getter
    @Setter
    @Builder
    public static class Read{
        private Long userId;

        private String name;

        private String major;

        private Integer age;

        private List<LoanRead> userLoanHistories;
        public static UserDTO.Read toDTO(User entity, List<LoanRead> history) {
            return Read.builder()
                    .userId(entity.getUserId())
                    .name(entity.getName())
                    .major(entity.getMajor())
                    .age(entity.getAge())
                    .userLoanHistories(history)
                    .build();
        }
    }

}
