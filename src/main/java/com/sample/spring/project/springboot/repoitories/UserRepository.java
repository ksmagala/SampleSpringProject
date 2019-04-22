package com.sample.spring.project.springboot.repoitories;

import com.sample.spring.project.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
