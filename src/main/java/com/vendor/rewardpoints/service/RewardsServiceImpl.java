package com.vendor.rewardpoints.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendor.rewardpoints.constants.Constants;
import com.vendor.rewardpoints.entity.Transaction;
import com.vendor.rewardpoints.bean.Rewards;
import com.vendor.rewardpoints.repository.TransactionRepo;

@Service
public class RewardsServiceImpl implements RewardsService {
	@Autowired
	TransactionRepo transactionRepository;
	public Rewards getRewardsByCustomerId(int customerId) {

		Timestamp previousMonthTimestamp = getDateBasedOnOffSetDays(30);
		Timestamp previousSecondMonthTimestamp = getDateBasedOnOffSetDays(2*30);
		Timestamp previousThirdMonthTimestamp = getDateBasedOnOffSetDays(3*30);

		List<Transaction> previousMonthTransactionList = transactionRepository.findAllByCustomerIdAndTransactionDateBetween(
				customerId, previousMonthTimestamp, Timestamp.from(Instant.now()));
		List<Transaction> previousSecondMonthTransactionList = transactionRepository
				.findAllByCustomerIdAndTransactionDateBetween(customerId, previousSecondMonthTimestamp, previousMonthTimestamp);
		List<Transaction> previousThirdMonthTransList = transactionRepository
				.findAllByCustomerIdAndTransactionDateBetween(customerId, previousThirdMonthTimestamp,
						previousSecondMonthTimestamp);

		int lastMonthRewardPoints = getRewardsPerMonth(previousMonthTransactionList);
		int lastSecondMonthRewardPoints = getRewardsPerMonth(previousSecondMonthTransactionList);
		int lastThirdMonthRewardPoints = getRewardsPerMonth(previousThirdMonthTransList);

		Rewards customerRewards = new Rewards();
		customerRewards.setCustomerId(customerId);
		customerRewards.setPreviousMonthRewards(lastMonthRewardPoints);
		customerRewards.setPreviousSecondMonthRewards(lastSecondMonthRewardPoints);
		customerRewards.setPreviousThirdMonthRewards(lastThirdMonthRewardPoints);
		customerRewards.setRewardsSum(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

		return customerRewards;

	}

	private int getRewardsPerMonth(List<Transaction> transactions) {
		return transactions.stream().map(transaction -> calculateRewards(transaction))
				.collect(Collectors.summingInt(r -> r.intValue()));
	}

	private int calculateRewards(Transaction t) {
		if (t.getTransactionAmount() > Constants.rewardLimit1 && t.getTransactionAmount() <= Constants.rewardLimit2) {
			return Math.round(t.getTransactionAmount() - Constants.rewardLimit1);
		} else if (t.getTransactionAmount() > Constants.rewardLimit2) {
			return Math.round(t.getTransactionAmount() - Constants.rewardLimit2) * 2
					+ (Constants.rewardLimit2 - Constants.rewardLimit1);
		} else
			return 0;

	}

	public Timestamp getDateBasedOnOffSetDays(int days) {
		return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
	}

}
