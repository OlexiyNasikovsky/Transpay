/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.service;

import com.google.gson.Gson;
import transpayv1.data.response.BanksBody;
import transpayv1.data.response.CitiesBody;
import transpayv1.data.response.CountriesBody;
import transpayv1.data.response.LimitsBody;
import transpayv1.data.ResponseObject;
import transpayv1.data.request.CalculatorRequest;
import transpayv1.data.request.CancelTransaction;  
import transpayv1.data.request.ReleaseTransaction;
import transpayv1.data.request.Transaction;
import transpayv1.data.response.AccountTypesBody;
import transpayv1.data.response.CalculatorResponse;
import transpayv1.data.response.CountriesBodyDB;
import transpayv1.data.response.CountryDB;
import transpayv1.data.response.CurrenciesBody;
import transpayv1.data.response.PayersBody;
import transpayv1.data.response.PaymentModesBody;
import transpayv1.data.response.Rate;
import transpayv1.data.response.RatesBody;
import transpayv1.data.response.RemittancePurposesBody;
import transpayv1.data.response.StatesBody;
import transpayv1.data.response.TownsBody;
import transpayv1.data.response.TransactionResponse;
import transpayv1.data.response.errors.GeneralError;
import transpayv1.data.response.fields.MandatoryFields;
import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 * @description each method make a request to special address and form a response from recieved iformation
 * @author Work
 */

public class RequestHandler {
    
    HttpsRequestHandler https = new HttpsRequestHandler();
    String address;
    Gson gson = new Gson();
    private ResponseObject responseObj = new ResponseObject();
    private Logger logger = Logger.getLogger(getClass().getName());
    private TransactionController transactionController = new TransactionController();
    private MessageBundlesController bundlesController = new MessageBundlesController();
    private CountriesController countriesController = new CountriesController();
    
    public RequestHandler() {
        address = "https://demo-api.transfast.net/api";
    }
    
    /**
     * 
     * @return string to return as response to global request
     */
    
    
//    extract countries from transpay, invoke deleting unfilled countries
//    extract "working" countries from DB and merge two lists
    
    public String getCountries() {
        String response = null;
        address += "/catalogs/countries";
        if((response = https.get(address))!=null) {
            CountriesBody countriesFromTranspay = new CountriesBody();
            countriesFromTranspay = gson.fromJson(response, countriesFromTranspay.getClass());
            countriesFromTranspay.delUnfilled();
            
//            CountriesBodyDB object = countriesController.
//                    mergeCountries(countriesFromTranspay.getCountries(), countriesController.getCountriesDB());
//            return responseObj.getJson(1, "You have got countries successfully",object,"");
            return responseObj.getJson(1, "You have got countries successfully",countriesFromTranspay,"");
        }
        return responseObj.getJson(-1, "Error of getting countries","");
    }
    
    public String getAllCountries() {
        String response = null;
        address += "/catalogs/countries";
        if((response = https.get(address))!=null) {
            CountriesBody countriesFromTranspay = new CountriesBody();
            countriesFromTranspay = gson.fromJson(response, countriesFromTranspay.getClass());
            countriesFromTranspay.delUnfilled();
//            CountriesBodyDB object = countriesController.
//                    mergeCountries(countriesFromTranspay.getCountries(), countriesController.getAllCountriesDB());
//            return responseObj.getJson(1, "You have got countries successfully",object,"");
            return responseObj.getJson(1, "You have got countries successfully",countriesFromTranspay,"");
        }
        return responseObj.getJson(-1, "Error of getting all countries","");
    }
    
    public String changeCountriesStatus(String countryIsoCode, int status) {
        if(countriesController.changeCountryStatus(countryIsoCode, status)) {
            return responseObj.getJson(1, "Status has been changed successfully","");
        }
        return responseObj.getJson(1, "Error of changing status","");
    }
    
    public String getMandatoryFields(String countryIsoCode, String locale){
        MandatoryFieldsController mfColntroller = new MandatoryFieldsController();
        MandatoryFields mandatoryFieldsData = mfColntroller.getMandatoryInfo(countryIsoCode, locale);
        if(mandatoryFieldsData != null && !mandatoryFieldsData.equals("") && mandatoryFieldsData.getCountries()!= null){
            Integer sSize = new Integer(mandatoryFieldsData.getCountries().size());
            if( sSize > 0){
                return responseObj.getJson(1, "Mandatory fields loaded successfully", mandatoryFieldsData,countryIsoCode);
            }else{
                 return responseObj.getJson(-1, "Mandatory fields list is empty","");
            }
        }
        return responseObj.getJson(-1, "Error of getting mandatory fields","");
    }
    
//    public String getRates(String SourceCurrencyIsoCode) {
//        String response = null;
//        address += "/rates/countryrates?receivecountryisocode=" + SourceCurrencyIsoCode;
//        if((response = https.get(address))!=null) {
//            RatesBody object = new RatesBody();
//            object = gson.fromJson(response, object.getClass());
//            return responseObj.getJson(1, "You have got rates successfully",object,"");
//        }
//        return responseObj.getJson(-1, "Error of getting rates","");
//    }
    
    public String getRates(String sourceCurrencyIsoCode, String receiveCountryIsoCode) {
        String response = null;
        address += "/rates/countryrates?sourcecurrencyisocode=" + sourceCurrencyIsoCode +
                "&receivecountryisocode=" + receiveCountryIsoCode;
        if((response = https.get(address))!=null) {
            RatesBody object = new RatesBody();
            object = gson.fromJson(response, object.getClass());
            Rate outRate = new Rate();
            for(Rate rate: object.getRates()){
                if(rate.getModeOfPaymentId().equals("C")){
                    outRate = rate;
                    break;
                }
            }
            logger.info(outRate.getModeOfPaymentName());
            //outRate = gson.fromJson(response, outRate.getClass());
            return responseObj.getJson(1, "You have got rates successfully",outRate,"");
        }
        return responseObj.getJson(-1, "Error of getting rates","");
    }
    
    /**
     * @param contryIsoCode
     * @return string to return as response to global request
     */
    public String getStates(String contryIsoCode) {
        address += "/catalogs/States?CountryIsoCode=" + contryIsoCode;
        String response;
        if((response = https.get(address)) != null) {
            StatesBody object = new StatesBody();
            object = gson.fromJson(response, object.getClass());response = gson.toJson(object);
            return responseObj.getJson(1, "You have got states successfully",object,"");
        }
        return responseObj.getJson(-1, "Error of getting states","");
    }
     /**
     * @param contryIsoCode
     * @return string to return as response to global request
     */
    public String getRemittancePurposes(String contryIsoCode) {
        address += "/catalogs/remittancepurposes?CountryIsoCode=" + contryIsoCode;
        String response;
        if((response = https.get(address)) != null) {
            RemittancePurposesBody object = new RemittancePurposesBody(); 
            object = gson.fromJson(response, object.getClass());
            response = gson.toJson(object);
            return responseObj.getJson(1, "You have got remittance purposes successfully",object,"");
        }
        return responseObj.getJson(-1, "Error of getting remittance purposes","");
    }   
         /**
     * @param contryIsoCode
     * @return string to return as response to global request
     */
    public String getAccountTypes(String contryIsoCode) {
        address += "/catalogs/accounttypes?CountryIsoCode=" + contryIsoCode;
        String response;
        if((response = https.get(address)) != null) {
            AccountTypesBody object = new AccountTypesBody(); 
            object = gson.fromJson(response, object.getClass());
            response = gson.toJson(object);
            return responseObj.getJson(1, "You have got account types successfully",object,"");
        }
        return responseObj.getJson(-1, "Error of getting account types","");
    }  
      
    
    /**
     * @param contryIsoCode
     * @param stateId
     * @return string to return as response to global request
     */
    public String getCities(String contryIsoCode, String stateId) {
        address += "/catalogs/cities?CountryIsoCode=" + contryIsoCode + "&StateId=" + stateId;
        String response;
        if((response = https.get(address)) != null) {
            CitiesBody object = new CitiesBody();
            object = gson.fromJson(response, object.getClass());
            return responseObj.getJson(1, "You have got cities successfully", object,"");
        }
        return responseObj.getJson(-1, "Error of getting cities","");
    }
    
     /**
     * @param contryIsoCode
     * @return string to return as response to global request
     */
    public String getCities(String contryIsoCode) {
        address += "/catalogs/cities?CountryIsoCode=" + contryIsoCode;
        String response;
        if((response = https.get(address)) != null) {
            System.out.println("Point 4");
            CitiesBody object = new CitiesBody();
            object = gson.fromJson(response, object.getClass());
            return responseObj.getJson(1, "You have got cities successfully", object,"");
        }
        return responseObj.getJson(-1, "Error of getting cities","");
    }  
    
    /**
     * @param contryIsoCode
     * @param stateId
     * @param cityId
     * @return string to return as response to global request
     */
    public String getTowns(String contryIsoCode, String stateId, int cityId) {
        address += "/catalogs/towns?CountryIsoCode=" + contryIsoCode + "&State=" + stateId + "&City=" + cityId;
        
        String response;
        if((response = https.get(address)) != null) {
            TownsBody object = new TownsBody();
            object = gson.fromJson(response, object.getClass());
            return responseObj.getJson(1, "You have got towns successfully", object,"");
        }
        return responseObj.getJson(-1, "Error of getting towns","");
    }
    
    /**
     * @param contryIsoCode
     * @param cityId
     * @return string to return as response to global request
     */
    public String getPaymentModes(String contryIsoCode, int cityId) {
        address += "/catalogs/paymentmodes?CountryIsoCode=" + contryIsoCode + "&CityId=" + cityId;
        
        String response;
        if((response = https.get(address)) != null) {
            PaymentModesBody object = new PaymentModesBody();
            object = gson.fromJson(response, object.getClass());
            return responseObj.getJson(1, "You have got PaymentModes successfully", object,"");
        }
        return responseObj.getJson(-1, "Error of getting PaymentModes","");
    }
    
    /**
     * @param contryIsoCode
     * @param stateId
     * @param cityId
     * @param PaymentModeId
     * @return string to return as response to global request
     */
    public String getReceiveCurrencies(String contryIsoCode, String stateId, int cityId, String PaymentModeId) {

        address += "/transaction/receivercurrencies?CountryIsoCode=" + contryIsoCode + "&StateId=" + stateId
                + "&CityId=" +cityId + "&PaymentModeId=" +PaymentModeId;
       
        String response;
        if((response = https.get(address)) != null) {
            CurrenciesBody object = new CurrenciesBody();
            object = gson.fromJson(response, object.getClass());
            return responseObj.getJson(1, "You have got Currencies successfully", object,"");
        }
        return responseObj.getJson(-1, "Error of getting Currencies","");
    }
    
    
    /**
     * @param contryIsoCode
     * @return string to return as response to global request
     */
    public String getBanks(String contryIsoCode) {
        address += "/catalogs/banks?CountryIsoCode=" + contryIsoCode;
        
        String response;
        if((response = https.get(address)) != null) {
            BanksBody object = new BanksBody();
            object = gson.fromJson(response, object.getClass());
            return responseObj.getJson(1, "You have got Banks successfully", object,"");
        }
        return responseObj.getJson(-1, "Error of getting Banks","");
    }
    
    public String getPayoutLimits(String ReceiverCountryIsoCode) {
        address += "/catalogs/payoutlimits?ReceiverCountryIsoCode=" + ReceiverCountryIsoCode;
        
        String response;
        if((response = https.get(address)) != null) {
            LimitsBody object = new LimitsBody();
            object = gson.fromJson(response, object.getClass());
            return responseObj.getJson(1, "You have got Payout Limits successfully", object,"");
        }
        return responseObj.getJson(-1, "Error of getting Payout Limits","");
    }
    
    public String getPayers(String contryIsoCode, int cityId, String PaymentModeId, 
                    String ReceiveCurrencyIsoCode, String SourceCurrencyIsoCode) {
        
        address += "/catalogs/payers?CountryIsoCode=" + contryIsoCode + "&CityId=" + cityId
                + "&PaymentModeId=" + PaymentModeId + "&ReceiveCurrencyIsoCode=" + ReceiveCurrencyIsoCode
                + "&SourceCurrencyIsoCode=" + SourceCurrencyIsoCode;
        
        String response;
        if((response = https.get(address)) != null) {
           PayersBody object = new PayersBody();
           object = gson.fromJson(response, object.getClass());
           return responseObj.getJson(1, "You have got Payers successfully",object,"");
        }
        return responseObj.getJson(-1, "Error of getting Payers","");
    }
    
    public String calculator(CalculatorRequest calcRequest) {
        address += "/transaction/transactioninfo?receivercountryisocode=" + calcRequest.getReceiverCountryIsoCode()
                + "&receivercityid=" + calcRequest.getReceiverCityId() 
                + "&payerid=" + calcRequest.getPayerId() 
                + "&paymentmodeid=" + calcRequest.getPaymentModeId()
                + "&bankid=" + calcRequest.getBankId()
                + "&receivecurrencyisocode=" + calcRequest.getReceiveCurrencyIsoCode()
                + "&sourcecurrencyisocode=" + calcRequest.getSourceCurrencyIsoCode()
                + "&payingagentid=" + calcRequest.getPayingAgentId() 
                + "&sentamount=" + calcRequest.getSentAmount();
        
        String response;
        if((response = https.get(address)) != null) {
            CalculatorResponse object = new CalculatorResponse();
            object = gson.fromJson(response, object.getClass());
            
            CountryDB country = countriesController.getCountryFromDB(calcRequest.getReceiverCountryIsoCode());
            object.setPercFee(country.getPercFee());
            object.setServiceFee(object.getServiceFee().add(country.getFixedFee()));
            
            BigDecimal totalFxFee = object.getTotalSentAmount().subtract(object.getSentAmount())
                                    .add(country.getFixedFee());
            BigDecimal totalSentAmount = new BigDecimal(0);
            
            if(country.getPercFee()!=null) {
            totalSentAmount = object.getSentAmount()
                                        .multiply(object.getPercFee().divide(new BigDecimal(100))
                                        .add(new BigDecimal(1)));
            }
            totalSentAmount = totalSentAmount.add(totalFxFee);
            object.setTotalSentAmount(totalSentAmount);
            
            return responseObj.getJson(1, "You have got result successfully", object,"");
        }
        return responseObj.getJson(-1, "Error of getting result","");
    }
   
    
    /**
     * @param request
     * @return string to return as response to global request
     */
    public String createTransaction(Transaction transaction, /*CountryDB country,*/ String locale) {
        String request = gson.toJson(transaction);
        
        logger.info("Request:" + request);
        String url = address + "/transaction/invoice";
        logger.info("url:" + url);
        String response;
        if((response = https.post(url, request)) != null) {
            GeneralError err = this.handleTransPayError(response);
            if(err == null) {
                TransactionResponse obj = new TransactionResponse();
                obj = gson.fromJson(response, obj.getClass());
                if(obj.getTfPin()!= null) {
//                    if((obj = transactionController.prepareFeeAndAmount(obj, country)) == null) {
//                        return responseObj.getJson(-1, bundlesController.getTranslation("TRANSPAY_CONNECTION_ERROR", locale),"");
//                    }
//                    transaction.getTransactionInfo().setTotalSentAmount(obj.getTransactionInfo().getTotalSentAmount());
                    
                    if(!transactionController.saveTransaction(transaction, obj.getTfPin())){
                        return responseObj.getJson(-1, bundlesController.getTranslation("TRANSPAY_CREATION_ERROR", locale),"");
                    }
                    return responseObj.getTransactionJson(1, bundlesController.getTranslation("TRANSPAY_CREATION_SUCCESS", locale), obj,"");
                }
            } else {                
                return responseObj.getJson(-1, bundlesController.getTranslation("TRANSPAY_PARAMETERS_ERROR", locale), err);
            }
        }
        return responseObj.getJson(-1, bundlesController.getTranslation("TRANSPAY_CONNECTION_ERROR", locale),"");
    }
    
    public String releaseTransaction(ReleaseTransaction transaction, String locale) {

        address += "/transaction/release";
        String response;
        String request = gson.toJson(transaction);
        if((response = https.put(address, request)) != null) {
            
            if(!transactionController.saveTransactionStatus(1, transaction.getTfPin())){
                return responseObj.getJson(-1, bundlesController.getTranslation("TRANSPAY_RELEASING_ERROR", locale),"");
            }
            
            return responseObj.getJson(1,  bundlesController.getTranslation("TRANSPAY_RELEASE_SUCCESSFUL", locale),"");
        }
        return responseObj.getJson(-1, bundlesController.getTranslation("TRANSPAY_CONNECTION_ERROR", locale),"");
    }
    
    public String cancelTransaction(CancelTransaction transaction, String locale) {

        address += "/transaction/cancel";
        String request = gson.toJson(transaction);
        String response;
        if((response = https.put(address, request)) != null) {
            
            if(!transactionController.saveTransactionStatus(-1, transaction.getTfPin())){
                return responseObj.getJson(-1, bundlesController.getTranslation("TRANSPAY_CANCELLING_ERROR", locale), "");
            }
            
            return responseObj.getJson(1, bundlesController.getTranslation("TRANSPAY_CANCELLING_SUCCESSFUL", locale), "");
        }
        return responseObj.getJson(-1, bundlesController.getTranslation("TRANSPAY_CONNECTION_ERROR", locale),"");
    }
    
    private GeneralError handleTransPayError(String response) {
        GeneralError err = gson.fromJson(response, GeneralError.class);
        logger.info(response);
        if(err != null) {
            if(err.getErrorCode() != null || err.getMessage() != null
                    || !err.getBusinessErrors().isEmpty() || !err.getDataValidationErrors().isEmpty()) {
                //logger.info(err.getDataValidationErrors()[0].);
                return err;
            }
        }
        return null;
    }
}
