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
public class CurrenciesBody extends AbstractResponse{
    private List<Currency> Currencies = new ArrayList<Currency>();

    /**
     * @return the Currencies
     */
    public List<Currency> getCurrencies() {
        return Currencies;
    }

    /**
     * @param Currencies the Currencies to set
     */
    public void setCurrencies(List<Currency> Currencies) {
        this.Currencies = Currencies;
    }
}
