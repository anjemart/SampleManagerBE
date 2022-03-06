package com.inventory.SampleManager.repository;

import com.inventory.SampleManager.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
