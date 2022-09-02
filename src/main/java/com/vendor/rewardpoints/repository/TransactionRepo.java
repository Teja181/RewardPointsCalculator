package com.vendor.rewardpoints.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vendor.rewardpoints.entity.Transaction;

@Repository
@Transactional
public interface TransactionRepo extends CrudRepository<Transaction,Integer> {
    public List<Transaction> findAllByCustomerIdAndTransactionDateBetween(int customerId, Timestamp from,Timestamp to);
}
