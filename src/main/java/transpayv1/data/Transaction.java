/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data;

/**
 * Transaction object
 * @author jk
 */
public class Transaction {
    
    public Transaction(){
        
    }
    //transaction identifier
    private String tfPin;   
    
    private Integer senderId;
    
    // Sender information
    private String sender_name;
    private String sender_nameOtherLanguage;
    private String sender_address;
    private String sender_addressOtherLanguage;
    private String sender_phoneMobile;
    private String sender_cityId;
    private String sender_stateId;
    private String sender_countryIsoCode;
    private String sender_typeOfId;
    private String sender_idNumber;
    private String sender_email;
    private String sender_isIndividual;
    
    //Receiver information
    private String receiver_firstName;
    private String receiver_firstNameOtherLanuage;
    private String receiver_secondName;
    private String receiver_secondNameOtherLanguage;
    private String receiver_lastName;
    private String receiver_lastNameOtherLanguage;
    private String receiver_completeAddress;
    private String receiver_completeAddressOtherLanguage;
    private String receiver_countryIsoCode;
    private String receiver_stateId;
    private String receiver_cityId;
    private String receiver_townId;
    private String receiver_mobilePhone;
    private String receiver_isIndividual;
    private String receiver_email;
    private String receiver_notes;
    private String receiver_notesOtherLanguage;
    
    //Transaction Info
    private String paymentModeId;
    private String receiveCurrencyIsoCode;
    private String sourceCurrencyIsoCode;
    private String bankId;

    private String account;
    private String payingBranchId;
    private String payerId;
    private String purposeOfRemittanceId;
    private Float rate;
    private Float totalSentAmount; //not required
    private Float sentAmount;
    private Float receiveAmount; //not required
    private Float serviceFee; //not required
    private Float payout; //not required
    private String formOfPaymentId; // ACH, CA for cash; CD for credit cards

    public String getTfPin() {
        return tfPin;
    }

    public void setTfPin(String tfPin) {
        this.tfPin = tfPin;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getSender_nameOtherLanguage() {
        return sender_nameOtherLanguage;
    }

    public void setSender_nameOtherLanguage(String sender_nameOtherLanguage) {
        this.sender_nameOtherLanguage = sender_nameOtherLanguage;
    }

    public String getSender_address() {
        return sender_address;
    }

    public void setSender_address(String sender_address) {
        this.sender_address = sender_address;
    }

    public String getSender_addressOtherLanguage() {
        return sender_addressOtherLanguage;
    }

    public void setSender_addressOtherLanguage(String sender_addressOtherLanguage) {
        this.sender_addressOtherLanguage = sender_addressOtherLanguage;
    }

    public String getSender_phoneMobile() {
        return sender_phoneMobile;
    }

    public void setSender_phoneMobile(String sender_phoneMobile) {
        this.sender_phoneMobile = sender_phoneMobile;
    }

    public String getSender_cityId() {
        return sender_cityId;
    }

    public void setSender_cityId(String sender_cityId) {
        this.sender_cityId = sender_cityId;
    }

    public String getSender_stateId() {
        return sender_stateId;
    }

    public void setSender_stateId(String sender_stateId) {
        this.sender_stateId = sender_stateId;
    }

    public String getSender_countryIsoCode() {
        return sender_countryIsoCode;
    }

    public void setSender_countryIsoCode(String sender_countryIsoCode) {
        this.sender_countryIsoCode = sender_countryIsoCode;
    }

    public String getSender_typeOfId() {
        return sender_typeOfId;
    }

    public void setSender_typeOfId(String sender_typeOfId) {
        this.sender_typeOfId = sender_typeOfId;
    }

    public String getSender_idNumber() {
        return sender_idNumber;
    }

    public void setSender_idNumber(String sender_idNumber) {
        this.sender_idNumber = sender_idNumber;
    }

    public String getSender_email() {
        return sender_email;
    }

    public void setSender_email(String sender_email) {
        this.sender_email = sender_email;
    }

    public String getSender_isIndividual() {
        return sender_isIndividual;
    }

    public void setSender_isIndividual(String sender_isIndividual) {
        this.sender_isIndividual = sender_isIndividual;
    }

    public String getReceiver_firstName() {
        return receiver_firstName;
    }

    public void setReceiver_firstName(String receiver_firstName) {
        this.receiver_firstName = receiver_firstName;
    }

    public String getReceiver_firstNameOtherLanuage() {
        return receiver_firstNameOtherLanuage;
    }

    public void setReceiver_firstNameOtherLanuage(String receiver_firstNameOtherLanuage) {
        this.receiver_firstNameOtherLanuage = receiver_firstNameOtherLanuage;
    }

    public String getReceiver_secondName() {
        return receiver_secondName;
    }

    public void setReceiver_secondName(String receiver_secondName) {
        this.receiver_secondName = receiver_secondName;
    }

    public String getReceiver_secondNameOtherLanguage() {
        return receiver_secondNameOtherLanguage;
    }

    public void setReceiver_secondNameOtherLanguage(String receiver_secondNameOtherLanguage) {
        this.receiver_secondNameOtherLanguage = receiver_secondNameOtherLanguage;
    }

    public String getReceiver_lastName() {
        return receiver_lastName;
    }

    public void setReceiver_lastName(String receiver_lastName) {
        this.receiver_lastName = receiver_lastName;
    }

    public String getReceiver_lastNameOtherLanguage() {
        return receiver_lastNameOtherLanguage;
    }

    public void setReceiver_lastNameOtherLanguage(String receiver_lastNameOtherLanguage) {
        this.receiver_lastNameOtherLanguage = receiver_lastNameOtherLanguage;
    }

    public String getReceiver_completeAddress() {
        return receiver_completeAddress;
    }

    public void setReceiver_completeAddress(String receiver_completeAddress) {
        this.receiver_completeAddress = receiver_completeAddress;
    }

    public String getReceiver_completeAddressOtherLanguage() {
        return receiver_completeAddressOtherLanguage;
    }

    public void setReceiver_completeAddressOtherLanguage(String receiver_completeAddressOtherLanguage) {
        this.receiver_completeAddressOtherLanguage = receiver_completeAddressOtherLanguage;
    }

    public String getReceiver_countryIsoCode() {
        return receiver_countryIsoCode;
    }

    public void setReceiver_countryIsoCode(String receiver_countryIsoCode) {
        this.receiver_countryIsoCode = receiver_countryIsoCode;
    }

    public String getReceiver_stateId() {
        return receiver_stateId;
    }

    public void setReceiver_stateId(String receiver_stateId) {
        this.receiver_stateId = receiver_stateId;
    }

    public String getReceiver_cityId() {
        return receiver_cityId;
    }

    public void setReceiver_cityId(String receiver_cityId) {
        this.receiver_cityId = receiver_cityId;
    }

    public String getReceiver_townId() {
        return receiver_townId;
    }

    public void setReceiver_townId(String receiver_townId) {
        this.receiver_townId = receiver_townId;
    }

    public String getReceiver_mobilePhone() {
        return receiver_mobilePhone;
    }

    public void setReceiver_mobilePhone(String receiver_mobilePhone) {
        this.receiver_mobilePhone = receiver_mobilePhone;
    }

    public String getReceiver_isIndividual() {
        return receiver_isIndividual;
    }

    public void setReceiver_isIndividual(String receiver_isIndividual) {
        this.receiver_isIndividual = receiver_isIndividual;
    }

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

    public String getPaymentModeId() {
        return paymentModeId;
    }

    public void setPaymentModeId(String paymentModeId) {
        this.paymentModeId = paymentModeId;
    }

    public String getReceiveCurrencyIsoCode() {
        return receiveCurrencyIsoCode;
    }

    public void setReceiveCurrencyIsoCode(String receiveCurrencyIsoCode) {
        this.receiveCurrencyIsoCode = receiveCurrencyIsoCode;
    }

    public String getSourceCurrencyIsoCode() {
        return sourceCurrencyIsoCode;
    }

    public void setSourceCurrencyIsoCode(String sourceCurrencyIsoCode) {
        this.sourceCurrencyIsoCode = sourceCurrencyIsoCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPayingBranchId() {
        return payingBranchId;
    }

    public void setPayingBranchId(String payingBranchId) {
        this.payingBranchId = payingBranchId;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Float getTotalSentAmount() {
        return totalSentAmount;
    }

    public void setTotalSentAmount(Float totalSentAmount) {
        this.totalSentAmount = totalSentAmount;
    }

    public Float getSentAmount() {
        return sentAmount;
    }

    public void setSentAmount(Float sentAmount) {
        this.sentAmount = sentAmount;
    }

    public Float getReceiveAmount() {
        return receiveAmount;
    }

    public void setReceiveAmount(Float receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    public Float getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Float serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Float getPayout() {
        return payout;
    }

    public void setPayout(Float payout) {
        this.payout = payout;
    }

    public String getFormOfPaymentId() {
        return formOfPaymentId;
    }

    public void setFormOfPaymentId(String formOfPaymentId) {
        this.formOfPaymentId = formOfPaymentId;
    }
    
    
    public String getPurposeOfRemittanceId() {
        return purposeOfRemittanceId;
    }

    public void setPurposeOfRemittanceId(String purposeOfRemittanceId) {
        this.purposeOfRemittanceId = purposeOfRemittanceId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }    
}
