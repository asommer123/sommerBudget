package com.ocbc.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Results {

	@JsonProperty("thereafterMonthlyPayment")
	private double thereafterMonthlyPayment;

	@JsonProperty("year2InterestRate")
	private double year2InterestRate;

	@JsonProperty("eligibleLoanAmount")
	private double eligibleLoanAmount;

	@JsonProperty("year1MonthlyPayment")
	private double year1MonthlyPayment;

	@JsonProperty("year2MonthlyPayment")
	private double year2MonthlyPayment;

	@JsonProperty("thereafterInterestRate")
	private double thereafterInterestRate;

	@JsonProperty("year1InterestRate")
	private double year1InterestRate;

	@JsonProperty("year3InterestRate")
	private double year3InterestRate;

	@JsonProperty("year3MonthlyPayment")
	private double year3MonthlyPayment;

	public void setThereafterMonthlyPayment(double thereafterMonthlyPayment){
		this.thereafterMonthlyPayment = thereafterMonthlyPayment;
	}

	public double getThereafterMonthlyPayment(){
		return thereafterMonthlyPayment;
	}

	public void setYear2InterestRate(double year2InterestRate){
		this.year2InterestRate = year2InterestRate;
	}

	public double getYear2InterestRate(){
		return year2InterestRate;
	}

	public void setEligibleLoanAmount(double eligibleLoanAmount){
		this.eligibleLoanAmount = eligibleLoanAmount;
	}

	public double getEligibleLoanAmount(){
		return eligibleLoanAmount;
	}

	public void setYear1MonthlyPayment(double year1MonthlyPayment){
		this.year1MonthlyPayment = year1MonthlyPayment;
	}

	public double getYear1MonthlyPayment(){
		return year1MonthlyPayment;
	}

	public void setYear2MonthlyPayment(double year2MonthlyPayment){
		this.year2MonthlyPayment = year2MonthlyPayment;
	}

	public double getYear2MonthlyPayment(){
		return year2MonthlyPayment;
	}

	public void setThereafterInterestRate(double thereafterInterestRate){
		this.thereafterInterestRate = thereafterInterestRate;
	}

	public double getThereafterInterestRate(){
		return thereafterInterestRate;
	}

	public void setYear1InterestRate(double year1InterestRate){
		this.year1InterestRate = year1InterestRate;
	}

	public double getYear1InterestRate(){
		return year1InterestRate;
	}

	public void setYear3InterestRate(double year3InterestRate){
		this.year3InterestRate = year3InterestRate;
	}

	public double getYear3InterestRate(){
		return year3InterestRate;
	}

	public void setYear3MonthlyPayment(double year3MonthlyPayment){
		this.year3MonthlyPayment = year3MonthlyPayment;
	}

	public double getYear3MonthlyPayment(){
		return year3MonthlyPayment;
	}

	@Override
 	public String toString(){
		return 
			"Results{" +
			"thereafterMonthlyPayment = '" + thereafterMonthlyPayment + '\'' + 
			",year2InterestRate = '" + year2InterestRate + '\'' + 
			",eligibleLoanAmount = '" + eligibleLoanAmount + '\'' + 
			",year1MonthlyPayment = '" + year1MonthlyPayment + '\'' + 
			",year2MonthlyPayment = '" + year2MonthlyPayment + '\'' + 
			",thereafterInterestRate = '" + thereafterInterestRate + '\'' + 
			",year1InterestRate = '" + year1InterestRate + '\'' + 
			",year3InterestRate = '" + year3InterestRate + '\'' + 
			",year3MonthlyPayment = '" + year3MonthlyPayment + '\'' + 
			"}";
		}
}