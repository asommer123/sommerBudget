package com.ocbc.retirement;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("results")
	private Results results;

	@JsonProperty("disclaimer")
	private String disclaimer;

	public void setResults(Results results){
		this.results = results;
	}

	public Results getResults(){
		return results;
	}

	public void setDisclaimer(String disclaimer){
		this.disclaimer = disclaimer;
	}

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