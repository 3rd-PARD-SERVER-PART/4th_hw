package org.example.forthseminar.book.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class BookDTO {
    @Getter
    @Setter
    public static class Create {
        private String name;
    }
    @Getter
    @Setter
    @Builder
    public static class Loan {
        private Long bookId;
        private String name;
        private boolean isLoan;
    }
}
