package org.example.forthseminar.user.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.forthseminar.user.dto.UserDTO;
import org.example.forthseminar.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public String createUser(@RequestBody UserDTO.Create dto) {
        userService.createUser(dto);
        return "추가됨";
    }

    @GetMapping("/user")
    public List<UserDTO.Read> readAll() {
        return userService.readAll();
    }


    @PostMapping("/loan")
    public String loan(@RequestBody UserDTO.Loan dto) {
        return userService.borrow(dto);
    }


    @PostMapping("/return")
    public String returnBook(@RequestBody UserDTO.Loan dto) {
        return userService.returnBook(dto);
    }

    @GetMapping("/user/{userId}")
    public UserDTO.Read readById(@PathVariable Long userId) {
        return userService.readById(userId);
    }

}
