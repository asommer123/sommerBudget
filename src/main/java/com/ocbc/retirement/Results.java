package com.ocbc.retirement;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import java.util.Currency;

/**
 * The Results from the OCBC retirement api. Contains the 'result' information for what was passed.
 */
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

    /**
     * Set future ls investment.
     *
     * @param futureLsInvestment the future ls investment
     */
    public void setFutureLsInvestment(double futureLsInvestment){
		this.futureLsInvestment = futureLsInvestment;
	}

    /**
     * Get future ls investment double.
     *
     * @return the double
     */
    public double getFutureLsInvestment(){
		return futureLsInvestment;
	}

    /**
     * Set after investing.
     *
     * @param afterInvesting the after investing
     */
    public void setAfterInvesting(double afterInvesting){
		this.afterInvesting = afterInvesting;
	}

    /**
     * Get after investing double.
     *
     * @return the double
     */
    public double getAfterInvesting(){
		return afterInvesting;
	}

    /**
     * Set final cost.
     *
     * @param finalCost the final cost
     */
    public void setFinalCost(double finalCost){
		this.finalCost = finalCost;
	}

    /**
     * Get final cost double.
     *
     * @return the double
     */
    public double getFinalCost(){
		return finalCost;
	}

    /**
     * Set total set aside.
     *
     * @param totalSetAside the total set aside
     */
    public void setTotalSetAside(double totalSetAside){
		this.totalSetAside = totalSetAside;
	}

    /**
     * Get total set aside double.
     *
     * @return the double
     */
    public double getTotalSetAside(){
		return totalSetAside;
	}

    /**
     * Set lump sum set aside.
     *
     * @param lumpSumSetAside the lump sum set aside
     */
    public void setLumpSumSetAside(double lumpSumSetAside){
		this.lumpSumSetAside = lumpSumSetAside;
	}

    /**
     * Get lump sum set aside double.
     *
     * @return the double
     */
    public double getLumpSumSetAside(){
		return lumpSumSetAside;
	}

    /**
     * Set before investing.
     *
     * @param beforeInvesting the before investing
     */
    public void setBeforeInvesting(double beforeInvesting){
		this.beforeInvesting = beforeInvesting;
	}

    /**
     * Get before investing double.
     *
     * @return the double
     */
    public double getBeforeInvesting(){
		return beforeInvesting;
	}

    /**
     * Set srs set aside.
     *
     * @param srsSetAside the srs set aside
     */
    public void setSrsSetAside(double srsSetAside){
		this.srsSetAside = srsSetAside;
	}

    /**
     * Get srs set aside double.
     *
     * @return the double
     */
    public double getSrsSetAside(){
		return srsSetAside;
	}

    /**
     * Set regular set aside.
     *
     * @param regularSetAside the regular set aside
     */
    public void setRegularSetAside(double regularSetAside){
		this.regularSetAside = regularSetAside;
	}

    /**
     * Get regular set aside double.
     *
     * @return the double
     */
    public double getRegularSetAside(){
		return regularSetAside;
	}

    /**
     * Set final surplus.
     *
     * @param finalSurplus the final surplus
     */
    public void setFinalSurplus(double finalSurplus){
		this.finalSurplus = finalSurplus;
	}

    /**
     * Get final surplus double.
     *
     * @return the double
     */
    public double getFinalSurplus(){
		return finalSurplus;
	}

    /**
     * Set cash deposit set aside.
     *
     * @param cashDepositSetAside the cash deposit set aside
     */
    public void setCashDepositSetAside(double cashDepositSetAside){
		this.cashDepositSetAside = cashDepositSetAside;
	}

    /**
     * Get cash deposit set aside double.
     *
     * @return the double
     */
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