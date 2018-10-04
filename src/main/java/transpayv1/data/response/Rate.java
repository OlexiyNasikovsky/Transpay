/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.response;

import java.math.BigDecimal;

/**
 *
 * @author Work
 */
public class Rate  extends AbstractResponse {
    private String PayerName;
    private String ModeOfPaymentName;
    private BigDecimal StartRate;
    private BigDecimal EndRate;
    private String PayerId;
    private String ModeOfPaymentId;
    private String ReceiveCountryIsoCode;
    private String ReceiveCountryName;
    private String RateStartDate;
    private String RateExpiryDate;
    private String ReceiveCurrencyIsoCode;

    /**
     * @return the PayerName
     */
    public String getPayerName() {
        return PayerName;
    }

    /**
     * @param PayerName the PayerName to set
     */
    public void setPayerName(String PayerName) {
        this.PayerName = PayerName;
    }

    /**
     * @return the ModeOfPaymentName
     */
    public String getModeOfPaymentName() {
        return ModeOfPaymentName;
    }

    /**
     * @param ModeOfPaymentName the ModeOfPaymentName to set
     */
    public void setModeOfPaymentName(String ModeOfPaymentName) {
        this.ModeOfPaymentName = ModeOfPaymentName;
    }

    /**
     * @return the StartRate
     */
    public BigDecimal getStartRate() {
        return StartRate;
    }

    /**
     * @param StartRate the StartRate to set
     */
    public void setStartRate(BigDecimal StartRate) {
        this.StartRate = StartRate;
    }

    /**
     * @return the EndRate
     */
    public BigDecimal getEndRate() {
        return EndRate;
    }

    /**
     * @param EndRate the EndRate to set
     */
    public void setEndRate(BigDecimal EndRate) {
        this.EndRate = EndRate;
    }

    /**
     * @return the PayerId
     */
    public String getPayerId() {
        return PayerId;
    }

    /**
     * @param PayerId the PayerId to set
     */
    public void setPayerId(String PayerId) {
        this.PayerId = PayerId;
    }

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
     * @return the ReceiveCountryIsoCode
     */
    public String getReceiveCountryIsoCode() {
        return ReceiveCountryIsoCode;
    }

    /**
     * @param ReceiveCountryIsoCode the ReceiveCountryIsoCode to set
     */
    public void setReceiveCountryIsoCode(String ReceiveCountryIsoCode) {
        this.ReceiveCountryIsoCode = ReceiveCountryIsoCode;
    }

    /**
     * @return the ReceiveCountryName
     */
    public String getReceiveCountryName() {
        return ReceiveCountryName;
    }

    /**
     * @param ReceiveCountryName the ReceiveCountryName to set
     */
    public void setReceiveCountryName(String ReceiveCountryName) {
        this.ReceiveCountryName = ReceiveCountryName;
    }

    /**
     * @return the RateStartDate
     */
    public String getRateStartDate() {
        return RateStartDate;
    }

    /**
     * @param RateStartDate the RateStartDate to set
     */
    public void setRateStartDate(String RateStartDate) {
        this.RateStartDate = RateStartDate;
    }

    /**
     * @return the RateExpiryDate
     */
    public String getRateExpiryDate() {
        return RateExpiryDate;
    }

    /**
     * @param RateExpiryDate the RateExpiryDate to set
     */
    public void setRateExpiryDate(String RateExpiryDate) {
        this.RateExpiryDate = RateExpiryDate;
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
    
    
}
