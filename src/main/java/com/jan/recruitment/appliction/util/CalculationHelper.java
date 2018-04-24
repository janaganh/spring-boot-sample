package com.jan.recruitment.appliction.util;

import java.math.BigDecimal;

/*
  helper class for handling decimals
 */

public final class CalculationHelper {
	double amount = 0;

	public void addAmount(double amount) {
		this.amount += amount;
	}

	public double getAmount() {
		return this.amount;
	}

	public double getFinalAmount(){
		return new BigDecimal(this.amount).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
