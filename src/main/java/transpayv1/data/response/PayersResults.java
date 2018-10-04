/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.response;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Work
 */
public class PayersResults {
    private List<Payer> PayerDetailsResults = new ArrayList<Payer>();

    /**
     * @return the PayerDetailsResults
     */
    public List<Payer> getPayerDetailsResults() {
        return PayerDetailsResults;
    }

    /**
     * @param PayerDetailsResults the PayerDetailsResults to set
     */
    public void setPayerDetailsResults(List<Payer> PayerDetailsResults) {
        this.PayerDetailsResults = PayerDetailsResults;
    }
}
