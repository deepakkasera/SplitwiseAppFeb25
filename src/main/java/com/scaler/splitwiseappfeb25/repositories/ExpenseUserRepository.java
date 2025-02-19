package com.scaler.splitwiseappfeb25.repositories;

import com.scaler.splitwiseappfeb25.models.ExpenseUser;
import com.scaler.splitwiseappfeb25.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
    List<ExpenseUser> findByUser(User user);
}
