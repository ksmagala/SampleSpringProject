package com.sample.spring.project.springboot.repoitories;

import com.sample.spring.project.springboot.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
