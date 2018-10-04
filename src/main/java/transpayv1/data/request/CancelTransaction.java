/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.request;

/**
 *
 * @author Work
 */
public class CancelTransaction {
    private String TfPin;
    private String ReasonId;
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
     * @return the ReasonId
     */
    public String getReasonId() {
        return ReasonId;
    }

    /**
     * @param ReasonId the ReasonId to set
     */
    public void setReasonId(String ReasonId) {
        this.ReasonId = ReasonId;
    }
}
