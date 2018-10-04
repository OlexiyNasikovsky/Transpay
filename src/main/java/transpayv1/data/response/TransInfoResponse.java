/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.response;

import java.math.BigDecimal;

/**
 *
 * @author user
 */
public class TransInfoResponse {
//    вместе со всем
    private BigDecimal TotalSentAmount;
//    комиссия
    private BigDecimal ServiceFee;               
    private BigDecimal HandlingAmount;
    private BigDecimal FeeRate;
    private BigDecimal CreditAmount;
//    сколько хочет отправить Sender
    private BigDecimal SentAmount;                        
    private BigDecimal Adjustment;
    private BigDecimal Tax;

    /**
     * @return the TotalSentAmount
     */
    public BigDecimal getTotalSentAmount() {
        return TotalSentAmount;
    }

    /**
     * @param TotalSentAmount the TotalSentAmount to set
     */
    public void setTotalSentAmount(BigDecimal TotalSentAmount) {
        this.TotalSentAmount = TotalSentAmount;
    }

    /**
     * @return the ServiceFee
     */
    public BigDecimal getServiceFee() {
        return ServiceFee;
    }

    /**
     * @param ServiceFee the ServiceFee to set
     */
    public void setServiceFee(BigDecimal ServiceFee) {
        this.ServiceFee = ServiceFee;
    }

    /**
     * @return the HandlingAmount
     */
    public BigDecimal getHandlingAmount() {
        return HandlingAmount;
    }

    /**
     * @param HandlingAmount the HandlingAmount to set
     */
    public void setHandlingAmount(BigDecimal HandlingAmount) {
        this.HandlingAmount = HandlingAmount;
    }

    /**
     * @return the FeeRate
     */
    public BigDecimal getFeeRate() {
        return FeeRate;
    }

    /**
     * @param FeeRate the FeeRate to set
     */
    public void setFeeRate(BigDecimal FeeRate) {
        this.FeeRate = FeeRate;
    }

    /**
     * @return the CreditAmount
     */
    public BigDecimal getCreditAmount() {
        return CreditAmount;
    }

    /**
     * @param CreditAmount the CreditAmount to set
     */
    public void setCreditAmount(BigDecimal CreditAmount) {
        this.CreditAmount = CreditAmount;
    }

    /**
     * @return the SentAmount
     */
    public BigDecimal getSentAmount() {
        return SentAmount;
    }

    /**
     * @param SentAmount the SentAmount to set
     */
    public void setSentAmount(BigDecimal SentAmount) {
        this.SentAmount = SentAmount;
    }

    /**
     * @return the Adjustment
     */
    public BigDecimal getAdjustment() {
        return Adjustment;
    }

    /**
     * @param Adjustment the Adjustment to set
     */
    public void setAdjustment(BigDecimal Adjustment) {
        this.Adjustment = Adjustment;
    }

    /**
     * @return the Tax
     */
    public BigDecimal getTax() {
        return Tax;
    }

    /**
     * @param Tax the Tax to set
     */
    public void setTax(BigDecimal Tax) {
        this.Tax = Tax;
    }
}
