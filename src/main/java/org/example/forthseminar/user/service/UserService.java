package org.example.forthseminar.user.service;

import lombok.RequiredArgsConstructor;
import org.example.forthseminar.book.repo.BookRepo;
import org.example.forthseminar.user.dto.UserDTO;
import org.example.forthseminar.user.entity.User;
import org.example.forthseminar.user.entity.UserLoanHistory;
import org.example.forthseminar.user.repo.UserLoanHistoryRepo;
import org.example.forthseminar.user.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final BookRepo bookRepo;
    private final UserLoanHistoryRepo userLoanHistory;

    public void createUser(UserDTO.Create dto) {
        userRepo.save(User.toEntity(dto));
    }

    public void borrow(UserDTO.Loan dto) {
        userLoanHistory.save(UserLoanHistory.toEntity(
                userRepo.findById(dto.getUserId()).orElseThrow()
                , bookRepo.findById(dto.getBookId()).orElseThrow()));
    }



}
