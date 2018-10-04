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
public class CalculatorResponse extends AbstractResponse{
    private BigDecimal TotalSentAmount;
    private BigDecimal ServiceFee;
    private BigDecimal PercFee;
    private BigDecimal USDServiceFee;
    private BigDecimal HandlingAmount;
    private BigDecimal FeeRate;
    private BigDecimal CashAmount;
    private BigDecimal Payout;
    private BigDecimal CreditAmount;
    private BigDecimal SentAmount;
    private BigDecimal ReceiveAmount;
    private BigDecimal TransactionRate;
    private BigDecimal SettlementRate;

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
     * @return the USDServiceFee
     */
    public BigDecimal getUSDServiceFee() {
        return USDServiceFee;
    }

    /**
     * @param USDServiceFee the USDServiceFee to set
     */
    public void setUSDServiceFee(BigDecimal USDServiceFee) {
        this.USDServiceFee = USDServiceFee;
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
     * @return the CashAmount
     */
    public BigDecimal getCashAmount() {
        return CashAmount;
    }

    /**
     * @param CashAmount the CashAmount to set
     */
    public void setCashAmount(BigDecimal CashAmount) {
        this.CashAmount = CashAmount;
    }

    /**
     * @return the Payout
     */
    public BigDecimal getPayout() {
        return Payout;
    }

    /**
     * @param Payout the Payout to set
     */
    public void setPayout(BigDecimal Payout) {
        this.Payout = Payout;
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
     * @return the ReceiveAmount
     */
    public BigDecimal getReceiveAmount() {
        return ReceiveAmount;
    }

    /**
     * @param ReceiveAmount the ReceiveAmount to set
     */
    public void setReceiveAmount(BigDecimal ReceiveAmount) {
        this.ReceiveAmount = ReceiveAmount;
    }

    /**
     * @return the TransactionRate
     */
    public BigDecimal getTransactionRate() {
        return TransactionRate;
    }

    /**
     * @param TransactionRate the TransactionRate to set
     */
    public void setTransactionRate(BigDecimal TransactionRate) {
        this.TransactionRate = TransactionRate;
    }

    /**
     * @return the SettlementRate
     */
    public BigDecimal getSettlementRate() {
        return SettlementRate;
    }

    /**
     * @param SettlementRate the SettlementRate to set
     */
    public void setSettlementRate(BigDecimal SettlementRate) {
        this.SettlementRate = SettlementRate;
    }

    /**
     * @return the PercFee
     */
    public BigDecimal getPercFee() {
        return PercFee;
    }

    /**
     * @param PercFee the PercFee to set
     */
    public void setPercFee(BigDecimal PercFee) {
        this.PercFee = PercFee;
    }
}
