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
public class RatesBody {
    private List<Rate> Rates = new ArrayList<>();
    private int TotalCount;

    /**
     * @return the Rates
     */
    public List<Rate> getRates() {
        return Rates;
    }

    /**
     * @param Rates the Rates to set
     */
    public void setRates(List<Rate> Rates) {
        this.Rates = Rates;
    }

    /**
     * @return the TotalCount
     */
    public int getTotalCount() {
        return TotalCount;
    }

    /**
     * @param TotalCount the TotalCount to set
     */
    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }
}
