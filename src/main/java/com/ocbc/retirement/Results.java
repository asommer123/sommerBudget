package com.ocbc.retirement;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import java.util.Currency;

@Generated("com.robohorse.robopojogenerator")
public class Results{

	@JsonProperty("futureLsInvestment")
	private double futureLsInvestment;

	@JsonProperty("afterInvesting")
	private double afterInvesting;

	@JsonProperty("finalCost")
	private double finalCost;

	@JsonProperty("totalSetAside")
	private double totalSetAside;

	@JsonProperty("lumpSumSetAside")
	private double lumpSumSetAside;

	@JsonProperty("beforeInvesting")
	private double beforeInvesting;

	@JsonProperty("srsSetAside")
	private double srsSetAside;

	@JsonProperty("regularSetAside")
	private double regularSetAside;

	@JsonProperty("finalSurplus")
	private double finalSurplus;

	@JsonProperty("cashDepositSetAside")
	private double cashDepositSetAside;

	public void setFutureLsInvestment(double futureLsInvestment){
		this.futureLsInvestment = futureLsInvestment;
	}

	public double getFutureLsInvestment(){
		return futureLsInvestment;
	}

	public void setAfterInvesting(double afterInvesting){
		this.afterInvesting = afterInvesting;
	}

	public double getAfterInvesting(){
		return afterInvesting;
	}

	public void setFinalCost(double finalCost){
		this.finalCost = finalCost;
	}

	public double getFinalCost(){
		return finalCost;
	}

	public void setTotalSetAside(double totalSetAside){
		this.totalSetAside = totalSetAside;
	}

	public double getTotalSetAside(){
		return totalSetAside;
	}

	public void setLumpSumSetAside(double lumpSumSetAside){
		this.lumpSumSetAside = lumpSumSetAside;
	}

	public double getLumpSumSetAside(){
		return lumpSumSetAside;
	}

	public void setBeforeInvesting(double beforeInvesting){
		this.beforeInvesting = beforeInvesting;
	}

	public double getBeforeInvesting(){
		return beforeInvesting;
	}

	public void setSrsSetAside(double srsSetAside){
		this.srsSetAside = srsSetAside;
	}

	public double getSrsSetAside(){
		return srsSetAside;
	}

	public void setRegularSetAside(double regularSetAside){
		this.regularSetAside = regularSetAside;
	}

	public double getRegularSetAside(){
		return regularSetAside;
	}

	public void setFinalSurplus(double finalSurplus){
		this.finalSurplus = finalSurplus;
	}

	public double getFinalSurplus(){
		return finalSurplus;
	}

	public void setCashDepositSetAside(double cashDepositSetAside){
		this.cashDepositSetAside = cashDepositSetAside;
	}

	public double getCashDepositSetAside(){
		return cashDepositSetAside;
	}

	@Override
 	public String toString(){
		return 
			"Results{" + 
			"futureLsInvestment = '" + futureLsInvestment + '\'' + 
			",afterInvesting = '" + afterInvesting + '\'' + 
			",finalCost = '" + finalCost + '\'' + 
			",totalSetAside = '" + totalSetAside + '\'' + 
			",lumpSumSetAside = '" + lumpSumSetAside + '\'' + 
			",beforeInvesting = '" + beforeInvesting + '\'' + 
			",srsSetAside = '" + srsSetAside + '\'' + 
			",regularSetAside = '" + regularSetAside + '\'' + 
			",finalSurplus = '" + finalSurplus + '\'' + 
			",cashDepositSetAside = '" + cashDepositSetAside + '\'' + 
			"}";
		}
}