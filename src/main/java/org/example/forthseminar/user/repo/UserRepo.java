package org.example.forthseminar.user.repo;

import org.example.forthseminar.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
