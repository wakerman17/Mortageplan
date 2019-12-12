package com.framtiden.domain;

public class MortageplanCalculation {
	
	/**
	 * Calculate the Fixed monthly payment
	 * 
	 * @param totalLoan The totalLoan the user have inserted
	 * @param interestPercent The interest in percent of one year
	 * @param numberOfYears The number of years to pay
	 * @return Fixed monthly payment in two decimals
	 */
	public static double mortageplanCalculation(double totalLoan, double interestPercent, int numberOfYears) {
  		double interest = interestPercent/12 * 0.01;
  		int numberOfPayments = numberOfYears * 12;
  		return round(totalLoan * interest * power(1 + interest, numberOfPayments)/(power(1 + interest, numberOfPayments) - 1));
  	}
  	
	private static double power(double base, int exponent) {
  		if(exponent == 0) {
  			return 1.0;
  		}
  		double currentPowerValue = 1.0;
  		for (int i = 0; i < exponent; i++) {
  			currentPowerValue *= base;
  		}
  		return currentPowerValue;
  	}
  	
  	private static double floor(double toFloor) {
  		int floored = (int)toFloor;
  		return (double)floored;
  	}
  	
  	private static double round(double toRound) {
  		return floor(toRound * 100 + 0.5)/100;
  	}
}
