/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.request;

import java.math.BigDecimal;

/**
 *
 * @author user
 */
public class CalculatorRequest {
    
    private String receiverCountryIsoCode;
    private Integer receiverCityId;
    private String payerId;
    private String paymentModeId;
    private String bankId;
    private String receiveCurrencyIsoCode;
    private BigDecimal sentAmount;
    private String sourceCurrencyIsoCode;
//    Payout location identifier; same as Paying Branch ID
    private String payingAgentId;
    
    public String checkFields() {
        if(receiverCountryIsoCode==null) {
            return ": receiverCountryIsoCode";
        }
        if(receiverCityId==null) {
            return ": receiverCityId";
        }
        if(payerId==null) {
            return ": payerId";
        }
        if(paymentModeId==null) {
            return ": paymentModeId";
        }
        if(bankId==null) {
            return ": bankId";
        }
        if(receiveCurrencyIsoCode==null) {
            return ": receiveCurrencyIsoCode";
        }
        if(sentAmount==null) {
            return ": sentAmount";
        }
        if(sourceCurrencyIsoCode==null) {
            return ": sourceCurrencyIsoCode";
        }
        if(payingAgentId==null) {
            return ": payingAgentId";
        }
        return null;
    }

    /**
     * @return the receiverCountryIsoCode
     */
    public String getReceiverCountryIsoCode() {
        return receiverCountryIsoCode;
    }

    /**
     * @param receiverCountryIsoCode the receiverCountryIsoCode to set
     */
    public void setReceiverCountryIsoCode(String receiverCountryIsoCode) {
        this.receiverCountryIsoCode = receiverCountryIsoCode;
    }

    /**
     * @return the receiverCityId
     */
    public Integer getReceiverCityId() {
        return receiverCityId;
    }

    /**
     * @param receiverCityId the receiverCityId to set
     */
    public void setReceiverCityId(Integer receiverCityId) {
        this.receiverCityId = receiverCityId;
    }

    /**
     * @return the payerId
     */
    public String getPayerId() {
        return payerId;
    }

    /**
     * @param payerId the payerId to set
     */
    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    /**
     * @return the paymentModeId
     */
    public String getPaymentModeId() {
        return paymentModeId;
    }

    /**
     * @param paymentModeId the paymentModeId to set
     */
    public void setPaymentModeId(String paymentModeId) {
        this.paymentModeId = paymentModeId;
    }

    /**
     * @return the receiveCurrency
     */
    public String getReceiveCurrencyIsoCode() {
        return receiveCurrencyIsoCode;
    }

    /**
     * @param receiveCurrency the receiveCurrency to set
     */
    public void setReceiveCurrencyIsoCode(String receiveCurrencyIsoCode) {
        this.receiveCurrencyIsoCode = receiveCurrencyIsoCode;
    }

    /**
     * @return the sentAmount
     */
    public BigDecimal getSentAmount() {
        return sentAmount;
    }

    /**
     * @param sentAmount the sentAmount to set
     */
    public void setSentAmount(BigDecimal sentAmount) {
        this.sentAmount = sentAmount;
    }

    /**
     * @return the sourceCurrencyIsoCode
     */
    public String getSourceCurrencyIsoCode() {
        return sourceCurrencyIsoCode;
    }

    /**
     * @param sourceCurrencyIsoCode the sourceCurrencyIsoCode to set
     */
    public void setSourceCurrencyIsoCode(String sourceCurrencyIsoCode) {
        this.sourceCurrencyIsoCode = sourceCurrencyIsoCode;
    }

    /**
     * @return the payingAgentId
     */
    public String getPayingAgentId() {
        return payingAgentId;
    }

    /**
     * @param payingAgentId the payingAgentId to set
     */
    public void setPayingAgentId(String payingAgentId) {
        this.payingAgentId = payingAgentId;
    }

    /**
     * @return the bankId
     */
    public String getBankId() {
        return bankId;
    }

    /**
     * @param bankId the bankId to set
     */
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }
    
}
