package com.vendor.rewardpoints.bean;

public class Rewards {
    private int customerId;
	private int previousMonthRewards;
    private int previousSecondMonthRewards;
    private int previousThirdMonthRewards;
    private int rewardsSum;

    public int getCustomerId() {
        return customerId;
    }

    public int getPreviousMonthRewards() {
		return previousMonthRewards;
	}

	public void setPreviousMonthRewards(int previousMonthRewards) {
		this.previousMonthRewards = previousMonthRewards;
	}

	public int getPreviousSecondMonthRewards() {
		return previousSecondMonthRewards;
	}

	public void setPreviousSecondMonthRewards(int previousSecondMonthRewards) {
		this.previousSecondMonthRewards = previousSecondMonthRewards;
	}

	public int getPreviousThirdMonthRewards() {
		return previousThirdMonthRewards;
	}

	public void setPreviousThirdMonthRewards(int previousThirdMonthRewards) {
		this.previousThirdMonthRewards = previousThirdMonthRewards;
	}

	public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    

    public int getRewardsSum() {
        return rewardsSum;
    }

    public void setRewardsSum(int rewardsSum) {
        this.rewardsSum = rewardsSum;
    }
}
