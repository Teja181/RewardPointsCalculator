package com.vendor.rewardpoints.repository;

import org.springframework.data.repository.CrudRepository;

import com.vendor.rewardpoints.entity.Customer;

public interface CustomerRepo extends CrudRepository<Customer,Integer> {
    public Customer findByCustomerId(int customerId);
}
