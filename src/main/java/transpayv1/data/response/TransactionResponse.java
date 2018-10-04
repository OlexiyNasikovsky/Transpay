/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.response;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 *
 * @author Work
 */
public class TransactionResponse extends AbstractResponse {
    
    private Integer status;
    private String TfPin;
    private String desc;
    private String addDesc;
    private Date date;
    private String sign;
    private TransInfoResponse TransactionInfo;
    
//    private Sender Sender;

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the TfPin
     */
    public String getTfPin() {
        return TfPin;
    }

    /**
     * @param TfPin the TfPin to set
     */
    public void setTfPin(String TfPin) {
        this.TfPin = TfPin;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the addDesc
     */
    public String getAddDesc() {
        return addDesc;
    }

    /**
     * @param addDesc the addDesc to set
     */
    public void setAddDesc(String addDesc) {
        this.addDesc = addDesc;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the sign
     */
    public String getSign() {
        return sign;
    }

    /**
     * @param sign the sign to set
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * @return the TransactionInfo
     */
    public TransInfoResponse getTransactionInfo() {
        return TransactionInfo;
    }

    /**
     * @param TransactionInfo the TransactionInfo to set
     */
    public void setTransactionInfo(TransInfoResponse TransactionInfo) {
        this.TransactionInfo = TransactionInfo;
    }


}
