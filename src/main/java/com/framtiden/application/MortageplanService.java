package com.framtiden.application;

import com.framtiden.domain.MortageplanCalculation;

public class MortageplanService {
	
	/**
	 * Sends the function to the domain 
	 * 
	 * @param totalLoan The totalLoan the user have inserted
	 * @param interestPercent The interest in percent of one year
	 * @param numberOfYears The number of years to pay
	 * @return Fixed monthly payment in two decimals
	 */
	public static double mortageplanCalculation(double totalLoan, double interestPercent, int numberOfYears) {
		return MortageplanCalculation.mortageplanCalculation(totalLoan, interestPercent, numberOfYears);
	}
}
