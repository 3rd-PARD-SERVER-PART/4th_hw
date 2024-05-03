package org.example.forthseminar.user.repo;

import org.example.forthseminar.user.entity.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepo extends JpaRepository<UserLoanHistory, Long> {
}
