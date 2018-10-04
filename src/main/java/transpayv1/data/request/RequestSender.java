/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.request;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Work
 */
public class RequestSender { //v13 - not necessary
    
    private Integer SenderId;
    @SerializedName("Name")
    private String sender_name;
    @SerializedName("Address")
    private String sender_address;
    @SerializedName("PhoneMobile")
    private String sender_phoneMobile;
    @SerializedName("IsIndividual")
    private boolean IsIndividual;
    @SerializedName("CountryIsoCode")
    private String sender_countryIsoCode;
    @SerializedName("StateId")
    private String sender_stateId;
    @SerializedName("CityId")
    private Integer sender_cityId;
    @SerializedName("Email")
    private String sender_email; 

    public String getSender_email() {
        return sender_email;
    }

    public void setSender_email(String sender_email) {
        this.sender_email = sender_email;
    }
    
    private String DateOfBirth;

    /**
     * @return the sender_name
     */
    public String getSender_name() {
        return sender_name;
    }

    /**
     * @param sender_name the sender_name to set
     */
    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    /**
     * @return the sender_address
     */
    public String getSender_address() {
        return sender_address;
    }

    /**
     * @param sender_address the sender_address to set
     */
    public void setSender_address(String sender_address) {
        this.sender_address = sender_address;
    }

    /**
     * @return the sender_phoneMobile
     */
    public String getSender_phoneMobile() {
        return sender_phoneMobile;
    }

    /**
     * @param sender_phoneMobile the sender_phoneMobile to set
     */
    public void setSender_phoneMobile(String sender_phoneMobile) {
        this.sender_phoneMobile = sender_phoneMobile;
    }

    /**
     * @return the IsIndividual
     */
    public boolean isIsIndividual() {
        return IsIndividual;
    }

    /**
     * @param IsIndividual the IsIndividual to set
     */
    public void setIsIndividual(boolean IsIndividual) {
        this.IsIndividual = IsIndividual;
    }

    /**
     * @return the sender_countryIsoCode
     */
    public String getSender_countryIsoCode() {
        return sender_countryIsoCode;
    }

    /**
     * @param sender_countryIsoCode the sender_countryIsoCode to set
     */
    public void setSender_countryIsoCode(String sender_countryIsoCode) {
        this.sender_countryIsoCode = sender_countryIsoCode;
    }

    /**
     * @return the sender_stateId
     */
    public String getSender_stateId() {
        return sender_stateId;
    }

    /**
     * @param sender_stateId the sender_stateId to set
     */
    public void setSender_stateId(String sender_stateId) {
        this.sender_stateId = sender_stateId;
    }

    /**
     * @return the sender_cityId
     */
    public Integer getSender_cityId() {
        return sender_cityId;
    }

    /**
     * @param sender_cityId the sender_cityId to set
     */
    public void setSender_cityId(Integer sender_cityId) {
        this.sender_cityId = sender_cityId;
    }

    /**
     * @return the DateOfBirth
     */
    public String getDateOfBirth() {
        return DateOfBirth;
    }

    /**
     * @param DateOfBirth the DateOfBirth to set
     */
    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    /**
     * @return the SenderId
     */
    public Integer getSenderId() {
        return SenderId;
    }

    /**
     * @param SenderId the SenderId to set
     */
    public void setSenderId(Integer SenderId) {
        this.SenderId = SenderId;
    }
}
