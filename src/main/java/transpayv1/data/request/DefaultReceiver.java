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
public class DefaultReceiver{
    @SerializedName("FirstName")
    private String receiver_firstName;
    @SerializedName("LastName")
    private String receiver_lastName;
    @SerializedName("ReceiverIdNumber")
    private String receiver_idnumber;
    @SerializedName("MobilePhone")
    private String receiver_mobilePhone;
    @SerializedName("CountryIsoCode") 
    private String receiver_countryIsoCode; //v13 - not necessary
    @SerializedName("StateId")
    private String receiver_stateId; //v13 - not necessary
    @SerializedName("CityId")
    private String receiver_cityId;
    @SerializedName("CompleteAddress")
    private String receiver_completeAddress;
    @SerializedName("Email")
    private String receiver_email;     //v13 - not necessary
    @SerializedName("Notes")
    private String receiver_notes;      //v13 - not necessary 
    @SerializedName("NotesOtherLanguage")
    private String receiver_notesOtherLanguage; //v13 - not necessary
    @SerializedName("Birthday")
    private String receiver_birthday;
    @SerializedName("FullNameOtherLanguage")
    private String receiver_full_name_other_language;
    
    public String getReceiver_email() {
        return receiver_email;
    }

    public void setReceiver_email(String receiver_email) {
        this.receiver_email = receiver_email;
    }

    public String getReceiver_notes() {
        return receiver_notes;
    }

    public void setReceiver_notes(String receiver_notes) {
        this.receiver_notes = receiver_notes;
    }

    public String getReceiver_notesOtherLanguage() {
        return receiver_notesOtherLanguage;
    }

    public void setReceiver_notesOtherLanguage(String receiver_notesOtherLanguage) {
        this.receiver_notesOtherLanguage = receiver_notesOtherLanguage;
    }

    
    public String getReceiver_completeAddress() {
        return receiver_completeAddress;
    }

    public void setReceiver_completeAddress(String receiver_completeAddress) {
        this.receiver_completeAddress = receiver_completeAddress;
    }
    /**
     * @return the receiver_firstName
     */
    public String getReceiver_firstName() {
        return receiver_firstName;
    }

    /**
     * @param receiver_firstName the receiver_firstName to set
     */
    public void setReceiver_firstName(String receiver_firstName) {
        this.receiver_firstName = receiver_firstName;
    }

    /**
     * @return the receiver_lastName
     */
    public String getReceiver_lastName() {
        return receiver_lastName;
    }

    /**
     * @param receiver_lastName the receiver_lastName to set
     */
    public void setReceiver_lastName(String receiver_lastName) {
        this.receiver_lastName = receiver_lastName;
    }

    /**
     * @return the receiver_mobilePhone
     */
    public String getReceiver_mobilePhone() {
        return receiver_mobilePhone;
    }

    /**
     * @param receiver_mobilePhone the receiver_mobilePhone to set
     */
    public void setReceiver_mobilePhone(String receiver_mobilePhone) {
        this.receiver_mobilePhone = receiver_mobilePhone;
    }

    /**
     * @return the receiver_countryIsoCode
     */
    public String getReceiver_countryIsoCode() {
        return receiver_countryIsoCode;
    }

    /**
     * @param receiver_countryIsoCode the receiver_countryIsoCode to set
     */
    public void setReceiver_countryIsoCode(String receiver_countryIsoCode) {
        this.receiver_countryIsoCode = receiver_countryIsoCode;
    }

    /**
     * @return the receiver_stateId
     */
    public String getReceiver_stateId() {
        return receiver_stateId;
    }

    /**
     * @param receiver_stateId the receiver_stateId to set
     */
    public void setReceiver_stateId(String receiver_stateId) {
        this.receiver_stateId = receiver_stateId;
    }

    /**
     * @return the receiver_cityId
     */
    public String getReceiver_cityId() {
        return receiver_cityId;
    }

    /**
     * @param receiver_cityId the receiver_cityId to set
     */
    public void setReceiver_cityId(String receiver_cityId) {
        this.receiver_cityId = receiver_cityId;
    }

    /**
     * @return the receiver_idnumber
     */
    public String getReceiver_idnumber() {
        return receiver_idnumber;
    }

    /**
     * @param receiver_idnumber the receiver_idnumber to set
     */
    public void setReceiver_idnumber(String receiver_idnumber) {
        this.receiver_idnumber = receiver_idnumber;
    }

    /**
     * @return the receiver_birthday
     */
    public String getReceiver_birthday() {
        return receiver_birthday;
    }

    /**
     * @param receiver_birthday the receiver_birthday to set
     */
    public void setReceiver_birthday(String receiver_birthday) {
        this.receiver_birthday = receiver_birthday;
    }

    /**
     * @return the receiver_full_name_other_language
     */
    public String getReceiver_full_name_other_language() {
        return receiver_full_name_other_language;
    }

    /**
     * @param receiver_full_name_other_language the receiver_full_name_other_language to set
     */
    public void setReceiver_full_name_other_language(String receiver_full_name_other_language) {
        this.receiver_full_name_other_language = receiver_full_name_other_language;
    }

    
}
