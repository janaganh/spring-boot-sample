package com.jan.recruitment.appliction.util;

import java.math.BigDecimal;

/**
 * Created by jhe on 4/23/2018.
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
