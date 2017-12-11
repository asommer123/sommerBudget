package edu.matc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ocbc.retirement.Response;
import edu.matc.util.ConvertToCurrencyString;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Calls the OCBC retirement api with the information passed in the request parameters.
 */
@WebServlet(
        name = "getRetirementNumbers",
        urlPatterns = {"/getRetirementNumbers"}
)
public class GetRetirementNumbers extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Calls the OCBC retirement api with the information passed in the request parameters.
     *
     * @param request the request
     * @param response the response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Response retirement = null;

        try {
            retirement = calculateRetirement(request.getParameter("currentAge"),
                    request.getParameter("retirementAge"),
                    request.getParameter("yearsAfterRetirement"),
                    request.getParameter("supplementaryAllowance"),
                    request.getParameter("monthlySpending"),
                    request.getParameter("srsValue"),
                    request.getParameter("propertySaleValue"),
                    request.getParameter("regularInvestments"),
                    request.getParameter("lumpSumInvestments"),
                    request.getParameter("cashAndDeposits"),
                    request.getParameter("growthOpt"));
        } catch (Exception e) {
            log.error("Error calculating retirement numbers.", e);
        }

        request.setAttribute("retirement", retirement);
        request.setAttribute("currencyFormat", new ConvertToCurrencyString());

        // Create the url
        String url = "/showRetirementNumbers.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    /**
     * Call the OCBC retirement api and returns the Response json.
     *
     * @param currentAge the current age
     * @param retirementAge the retirement age
     * @param yearsAfterRetirement the years after retirement
     * @param supplementaryAllowance the supplementary allowance
     * @param monthlySpending the monthly spending
     * @param srsValue the srs value
     * @param propertySaleValue the property sale value
     * @param regularInvestments the regular investments
     * @param lumpSumInvestments the lump sum investments
     * @param cashAndDeposits the cash and deposits
     * @param growthOpt the growth option
     * @return the Response on the api call
     * @throws Exception
     */
    private Response calculateRetirement(String currentAge, String retirementAge, String yearsAfterRetirement,
                                         String supplementaryAllowance, String monthlySpending, String srsValue,
                                         String propertySaleValue, String regularInvestments, String lumpSumInvestments,
                                         String cashAndDeposits, String growthOpt) throws Exception {

        //curl -X GET --header "Accept: application/json"
        // --header "Authorization: Bearer c3c34e2d512dfded5c252469d4fdc747"
        // "https://api.ocbc.com:8243/Home_Loan/1.0?currentAge1=30&totalMonthlyIncome1=5000&totalMonthlyDebt1=200&outstandingLoans1=0&repaymentPeriod=30"

        URL url = new URL("https://api.ocbc.com:8243/Lifegoals_Retirement/1.0?"
                + "currentAge=" + currentAge
                + "&retirementAge=" + retirementAge
                + "&yearsAfterRetirement=" + yearsAfterRetirement
                + "&supplementaryAllowance=" + supplementaryAllowance
                + "&monthlySpending=" + monthlySpending
                + "&srsValue=" + srsValue
                + "&propertySaleValue=" + propertySaleValue
                + "&regularInvestments=" + regularInvestments
                + "&lumpSumInvestments=" + lumpSumInvestments
                + "&cashAndDeposits=" + cashAndDeposits
                + "&growthOpt=" + growthOpt);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty  ("Accept", "application/json");
        connection.setRequestProperty  ("Authorization", "Bearer 5ab5e72042372bee67301ffa57930646");
        int responseCode = connection.getResponseCode();

        if (responseCode != 200) {
            log.error("Error encounted while calling OCBC API. Response code = " + responseCode
                    + ". Response message = " + connection.getResponseMessage());
            return null;
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

        return mapper.readValue(jsonResponse, Response.class);
    }
}
