package com.ocbc.retirement;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import java.text.NumberFormat;

/**
 * The Response from the OCBC retirement api. Contains Results and disclaimer.
 */
@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("results")
	private Results results;

	@JsonProperty("disclaimer")
	private String disclaimer;

    /**
     * Set results.
     *
     * @param results the results
     */
    public void setResults(Results results){
		this.results = results;
	}

    /**
     * Get results results.
     *
     * @return the results
     */
    public Results getResults(){
		return results;
	}

    /**
     * Set disclaimer.
     *
     * @param disclaimer the disclaimer
     */
    public void setDisclaimer(String disclaimer){
		this.disclaimer = disclaimer;
	}

    /**
     * Get disclaimer string.
     *
     * @return the string
     */
    public String getDisclaimer(){
		return disclaimer;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"results = '" + results + '\'' + 
			",disclaimer = '" + disclaimer + '\'' + 
			"}";
		}
}