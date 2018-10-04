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
public class CountryDB {
    private String Name;
    private String IsoCode;
    private String IsoCode_3;
    private String PayoutTime;
    private String PayoutCurrency;
    private BigDecimal FixedFee;
    private BigDecimal FixedFeeTransp;
    private BigDecimal PercFee;
    private BigDecimal FxPercFee;
    private BigDecimal MinSum;
    private BigDecimal MaxSum;
    private String FeeCurrency;
    private int status;

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

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
     * @return the PayoutTime
     */
    public String getPayoutTime() {
        return PayoutTime;
    }

    /**
     * @param PayoutTime the PayoutTime to set
     */
    public void setPayoutTime(String PayoutTime) {
        this.PayoutTime = PayoutTime;
    }

    /**
     * @return the PayoutCurrency
     */
    public String getPayoutCurrency() {
        return PayoutCurrency;
    }

    /**
     * @param PayoutCurrency the PayoutCurrency to set
     */
    public void setPayoutCurrency(String PayoutCurrency) {
        this.PayoutCurrency = PayoutCurrency;
    }

    /**
     * @return the FixedFee
     */
    public BigDecimal getFixedFee() {
        return FixedFee;
    }

    /**
     * @param FixedFee the FixedFee to set
     */
    public void setFixedFee(BigDecimal FixedFee) {
        this.FixedFee = FixedFee;
    }

    /**
     * @return the FixedFeeTransp
     */
    public BigDecimal getFixedFeeTransp() {
        return FixedFeeTransp;
    }

    /**
     * @param FixedFeeTransp the FixedFeeTransp to set
     */
    public void setFixedFeeTransp(BigDecimal FixedFeeTransp) {
        this.FixedFeeTransp = FixedFeeTransp;
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

    /**
     * @return the FxPercFee
     */
    public BigDecimal getFxPercFee() {
        return FxPercFee;
    }

    /**
     * @param FxPercFee the FxPercFee to set
     */
    public void setFxPercFee(BigDecimal FxPercFee) {
        this.FxPercFee = FxPercFee;
    }

    /**
     * @return the MinSum
     */
    public BigDecimal getMinSum() {
        return MinSum;
    }

    /**
     * @param MinSum the MinSum to set
     */
    public void setMinSum(BigDecimal MinSum) {
        this.MinSum = MinSum;
    }

    /**
     * @return the MaxSum
     */
    public BigDecimal getMaxSum() {
        return MaxSum;
    }

    /**
     * @param MaxSum the MaxSum to set
     */
    public void setMaxSum(BigDecimal MaxSum) {
        this.MaxSum = MaxSum;
    }

    /**
     * @return the FeeCurrency
     */
    public String getFeeCurrency() {
        return FeeCurrency;
    }

    /**
     * @param FeeCurrency the FeeCurrency to set
     */
    public void setFeeCurrency(String FeeCurrency) {
        this.FeeCurrency = FeeCurrency;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the IsoCode_3
     */
    public String getIsoCode_3() {
        return IsoCode_3;
    }

    /**
     * @param IsoCode_3 the IsoCode_3 to set
     */
    public void setIsoCode_3(String IsoCode_3) {
        this.IsoCode_3 = IsoCode_3;
    }

    }
