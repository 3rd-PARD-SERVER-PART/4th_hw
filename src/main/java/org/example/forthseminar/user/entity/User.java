package org.example.forthseminar.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.forthseminar.book.dto.BookDTO;
import org.example.forthseminar.book.entity.Book;
import org.example.forthseminar.user.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String major;

    private Integer age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();

    public static User toEntity(UserDTO.Create dto) {
        return User.builder()
                .name(dto.getName())
                .major(dto.getMajor())
                .age(dto.getAge())
                .build();
    }
}
