package edu.matc.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ocbc.retirement.Response;
import com.ocbc.retirement.Results;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;

import static org.junit.Assert.*;

public class ApiTest {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Api test.
     *
     * @throws Exception the exception
     */
    @Test
    public void apiTest() throws Exception {

        //curl -X GET --header "Accept: application/json"
        // --header "Authorization: Bearer c3c34e2d512dfded5c252469d4fdc747"
        // "https://api.ocbc.com:8243/Home_Loan/1.0?currentAge1=30&totalMonthlyIncome1=5000&totalMonthlyDebt1=200&outstandingLoans1=0&repaymentPeriod=30"

        // curl -X GET --header "Accept: application/json"
        // --header "Authorization: Bearer c3c34e2d512dfded5c252469d4fdc747"
        // "https://api.ocbc.com:8243/Lifegoals_Retirement/1.0?currentAge=30&retirementAge=65&yearsAfterRetirement=15&supplementaryAllowance=10&monthlySpending=10&srsValue=10&propertySaleValue=10®ularInvestments=10&lumpSumInvestments=10&cashAndDeposits=10&growthOpt=5"

        //URL url = new URL("https://api.ocbc.com:8243/Home_Loan/1.0?currentAge1=30&totalMonthlyIncome1=5000&totalMonthlyDebt1=200&outstandingLoans1=0&repaymentPeriod=30");
        URL url = new URL("https://api.ocbc.com:8243/Lifegoals_Retirement/1.0?currentAge=30&retirementAge=65&yearsAfterRetirement=15&supplementaryAllowance=10&monthlySpending=10&srsValue=10&propertySaleValue=10&regularInvestments=10&lumpSumInvestments=10&cashAndDeposits=10&growthOpt=5");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty  ("Accept", "application/json");
        connection.setRequestProperty  ("Authorization", "Bearer 5ab5e72042372bee67301ffa57930646");
        int responseCode = connection.getResponseCode();

        if (responseCode != 200) {
            log.error("Error encounted while calling API. Response code = " + responseCode
                    + ". Response message = " + connection.getResponseMessage());
        }

        InputStream content = (InputStream)connection.getInputStream();

        BufferedReader in = new BufferedReader (new InputStreamReader(content));
        String jsonResponse="";
        String line;
        while ((line = in.readLine()) != null) {
            jsonResponse = jsonResponse + line;
        }
        log.info("Response: " + jsonResponse);
        ObjectMapper mapper = new ObjectMapper();
        Response response = mapper.readValue(jsonResponse, Response.class);

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        Double finalCostDb = response.getResults().getFinalCost();
        String finalCost = numberFormat.format(finalCostDb);
        log.info("   Final Cost Double: " + finalCostDb);
        log.info("Final Cost Formatted: " + finalCost);

        log.info(response.toString());
        Results results = response.getResults();
        log.info(results.toString());

        assertTrue(finalCost.equals("$2,364.00"));

    }
}
