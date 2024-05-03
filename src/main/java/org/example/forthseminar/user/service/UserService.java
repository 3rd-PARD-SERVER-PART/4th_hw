package org.example.forthseminar.user.service;

import lombok.RequiredArgsConstructor;
import org.example.forthseminar.book.entity.Book;
import org.example.forthseminar.book.repo.BookRepo;
import org.example.forthseminar.user.dto.UserDTO;
import org.example.forthseminar.user.entity.User;
import org.example.forthseminar.user.entity.UserLoanHistory;
import org.example.forthseminar.user.repo.UserLoanHistoryRepo;
import org.example.forthseminar.user.repo.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final BookRepo bookRepo;
    private final UserLoanHistoryRepo userLoanHistory;

    public void createUser(UserDTO.Create dto) {
        userRepo.save(User.toEntity(dto));
    }

    @Transactional
    public String borrow(UserDTO.Loan dto) {
        Book book = bookRepo.findById(dto.getBookId()).orElseThrow();
        if (!book.isLoan()) {
            userLoanHistory.save(UserLoanHistory.toEntity(
                    userRepo.findById(dto.getUserId()).orElseThrow()
                    , bookRepo.findById(dto.getBookId()).orElseThrow()));
            book.isReturn();
            return "빌림";
        }
        return "빌릴 수 없음";
    }

    public List<UserDTO.Read> readAll() {
       return userRepo.findAll().stream()
                .map(user -> UserDTO.Read.toDTO(user
                        ,user.getUserLoanHistories()
                                .stream()
                                .map(UserDTO.LoanRead::toDTO).
                                collect(Collectors.toList())

                        ))
                .collect(Collectors.toList());
    }

    public UserDTO.Read readById(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return UserDTO.Read.toDTO(user,user.getUserLoanHistories().stream().map(UserDTO.LoanRead::toDTO).collect(Collectors.toList()));
    }
    @Transactional
    public String returnBook(UserDTO.Loan dto) {
        Book book = bookRepo.findById(dto.getBookId()).orElseThrow();
        User user = userRepo.findById(dto.getUserId()).orElseThrow();
        UserLoanHistory userLoanHistory2 = userLoanHistory.findByUserAndBookAndIsReturn(user, book, false);
        if (!userLoanHistory2.isReturn()) {
            userLoanHistory2.isLoan();
            book.isReturn();
            return "반납함";
        }
        return "이미 반납된 책";
    }



}
