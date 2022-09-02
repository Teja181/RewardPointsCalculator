package com.vendor.rewardpoints.service;

import com.vendor.rewardpoints.bean.Rewards;



public interface RewardsService {
    public Rewards getRewardsByCustomerId(int customerId);
}
