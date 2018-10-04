/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.request;

import java.math.BigDecimal;


/**
 *
 * @author Work
 */
public class TransInfo{
    
    private String PaymentModeId = "C";
    private String ReceiveCurrencyIsoCode;
    private String PayerId; //v13 - not necessary
    private String PayingBranchId; //v13 - not necessary
    private String SourceCurrencyIsoCode;
    private BigDecimal  SentAmount;
    private String BankId;
    private String Account;
    private String AccountTypeId;
    private String BankRoutingNumber; //or bank_branch
    private String PurposeOfRemittanceId;
    private BigDecimal  Rate; //v13 - not necessary
    private BigDecimal  TotalSentAmount; //not required  //v13 - not necessary
    private BigDecimal  ServiceFee;      //not required //v13 - not necessary
    private BigDecimal  USDServiceFee;   //not required //v13 - not necessary
    private String FormOfPaymentId; // ACH, CA for cash; CD for credit cards //v13 - not necessary

    
    public String getPurposeOfRemittanceId() {
        return PurposeOfRemittanceId;
    }

    public void setPurposeOfRemittanceId(String PurposeOfRemittanceId) {
        this.PurposeOfRemittanceId = PurposeOfRemittanceId;
    }

    public BigDecimal getRate() {
        return Rate;
    }

    public void setRate(BigDecimal Rate) {
        this.Rate = Rate;
    }

    public BigDecimal getTotalSentAmount() {
        return TotalSentAmount;
    }

    public void setTotalSentAmount(BigDecimal TotalSentAmount) {
        this.TotalSentAmount = TotalSentAmount;
    }

    public BigDecimal getServiceFee() {
        return ServiceFee;
    }

    public void setServiceFee(BigDecimal ServiceFee) {
        this.ServiceFee = ServiceFee;
    }

    public BigDecimal getUSDServiceFee() {
        return USDServiceFee;
    }

    public void setUSDServiceFee(BigDecimal USDServiceFee) {
        this.USDServiceFee = USDServiceFee;
    }

    public String getFormOfPaymentId() {
        return FormOfPaymentId;
    }

    public void setFormOfPaymentId(String FormOfPaymentId) {
        this.FormOfPaymentId = FormOfPaymentId;
    }
    
    
    /**
     * @return the PaymentModeId
     */
    public String getPaymentModeId() {
        return PaymentModeId;
    }

    /**
     * @param PaymentModeId the PaymentModeId to set
     */
    public void setPaymentModeId(String PaymentModeId) {
        this.PaymentModeId = PaymentModeId;
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
     * @return the PayingBranchId
     */
    public String getPayingBranchId() {
        return PayingBranchId;
    }

    /**
     * @param PayingBranchId the PayingBranchId to set
     */
    public void setPayingBranchId(String PayingBranchId) {
        this.PayingBranchId = PayingBranchId;
    }

    /**
     * @return the SourceCurrencyIsoCode
     */
    public String getSourceCurrencyIsoCode() {
        return SourceCurrencyIsoCode;
    }

    /**
     * @param SourceCurrencyIsoCode the SourceCurrencyIsoCode to set
     */
    public void setSourceCurrencyIsoCode(String SourceCurrencyIsoCode) {
        this.SourceCurrencyIsoCode = SourceCurrencyIsoCode;
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
     * @return the BankId
     */
    public String getBankId() {
        return BankId;
    }

    /**
     * @param BankId the BankId to set
     */
    public void setBankId(String BankId) {
        this.BankId = BankId;
    }

    /**
     * @return the Account
     */
    public String getAccount() {
        return Account;
    }

    /**
     * @param Account the Account to set
     */
    public void setAccount(String Account) {
        this.Account = Account;
    }

    /**
     * @return the BankBranchId
     */
    public String getBankRoutingNumber() {
        return BankRoutingNumber;
    }

    /**
     * @param BankBranchId the BankBranchId to set
     */
    public void setBankRoutingNumber(String BankRoutingNumber) {
        this.BankRoutingNumber = BankRoutingNumber;
    }

    /**
     * @return the AccountTypeId
     */
    public String getAccountTypeId() {
        return AccountTypeId;
    }

    /**
     * @param AccountTypeId the AccountType to set
     */
    public void setAccountTypeId(String AccountType) {
        this.AccountTypeId = AccountType;
    }

}
