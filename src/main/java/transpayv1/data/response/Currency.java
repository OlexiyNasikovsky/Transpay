/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.response;

/**
 *
 * @author Work
 */
public class Currency {
    private String IsoCode;
    private String IsPaymentCurrency;

    /**
     * @return the IsoCode
     */
    public String getIsoCode() {
        return IsoCode;
    }

    /**
     * @param IsoCode the IsoCode to set
     */
    public void setIsoCode(String IsoCode) {
        this.IsoCode = IsoCode;
    }

    /**
     * @return the IsPaymentCurrency
     */
    public String getIsPaymentCurrency() {
        return IsPaymentCurrency;
    }

    /**
     * @param IsPaymentCurrency the IsPaymentCurrency to set
     */
    public void setIsPaymentCurrency(String IsPaymentCurrency) {
        this.IsPaymentCurrency = IsPaymentCurrency;
    }
}
