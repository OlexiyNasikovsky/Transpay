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
public class Limit {
    private String ModeOfPaymentId;
    private String ReceiveCurrencyIsoCode;
    private float AmountLimit;

    /**
     * @return the ModeOfPaymentId
     */
    public String getModeOfPaymentId() {
        return ModeOfPaymentId;
    }

    /**
     * @param ModeOfPaymentId the ModeOfPaymentId to set
     */
    public void setModeOfPaymentId(String ModeOfPaymentId) {
        this.ModeOfPaymentId = ModeOfPaymentId;
    }

    /**
     * @return the ReceiveCurrencyIsoCode
     */
    public String getReceiveCurrencyIsoCode() {
        return ReceiveCurrencyIsoCode;
    }

    /**
     * @param ReceiveCurrencyIsoCode the ReceiveCurrencyIsoCode to set
     */
    public void setReceiveCurrencyIsoCode(String ReceiveCurrencyIsoCode) {
        this.ReceiveCurrencyIsoCode = ReceiveCurrencyIsoCode;
    }

    /**
     * @return the AmountLimit
     */
    public float getAmountLimit() {
        return AmountLimit;
    }

    /**
     * @param AmountLimit the AmountLimit to set
     */
    public void setAmountLimit(float AmountLimit) {
        this.AmountLimit = AmountLimit;
    }
}
