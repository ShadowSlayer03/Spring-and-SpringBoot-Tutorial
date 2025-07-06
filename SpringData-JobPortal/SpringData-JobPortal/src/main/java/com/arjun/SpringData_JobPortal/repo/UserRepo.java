package com.arjun.SpringData_JobPortal.repo;

import com.arjun.SpringData_JobPortal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
