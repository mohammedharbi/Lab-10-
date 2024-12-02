package com.example.jobseekingsystem.Repository;

import com.example.jobseekingsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
