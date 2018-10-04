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
public class PaymentMode {
    private String Id;
    private String Name;
    private String Status;
    private String RequieresBank;
    private String RequieresAccount;

    /**
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.Id = Id;
    }

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
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * @return the RequieresBank
     */
    public String getRequieresBank() {
        return RequieresBank;
    }

    /**
     * @param RequieresBank the RequieresBank to set
     */
    public void setRequieresBank(String RequieresBank) {
        this.RequieresBank = RequieresBank;
    }

    /**
     * @return the RequieresAccount
     */
    public String getRequieresAccount() {
        return RequieresAccount;
    }

    /**
     * @param RequieresAccount the RequieresAccount to set
     */
    public void setRequieresAccount(String RequieresAccount) {
        this.RequieresAccount = RequieresAccount;
    }
}
