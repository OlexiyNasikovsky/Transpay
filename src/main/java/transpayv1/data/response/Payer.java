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
public class Payer {
    private String PayerId;
    private String BranchId;

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
     * @return the BranchId
     */
    public String getBranchId() {
        return BranchId;
    }

    /**
     * @param BranchId the BranchId to set
     */
    public void setBranchId(String BranchId) {
        this.BranchId = BranchId;
    }
    
    
}
