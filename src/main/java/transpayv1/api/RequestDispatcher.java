/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import transpayv1.data.ResponseObject;
import transpayv1.data.request.CalculatorRequest;
import transpayv1.data.request.CancelTransaction;
import transpayv1.data.request.ReleaseTransaction;
import transpayv1.data.request.Transaction;
import transpayv1.data.response.CountryDB;
import transpayv1.data.response.errors.GeneralError;
import transpayv1.data.response.errors.TransPayError;
import transpayv1.service.CancelTransactionDeserializer;
import transpayv1.service.CountriesController;
import transpayv1.service.MandatoryFieldsController;
import transpayv1.service.MessageBundlesController;
import transpayv1.service.ReleaseTransactionDeserialiser;
import transpayv1.service.RequestHandler;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.apache.log4j.Logger;


/**
 * Main request method dispatcher class 
 * @author jk
 */
public class RequestDispatcher {
    
    // дописать инициализацию MandatoryFields при запуске
    // допилить методы на получение MandatoryFields по countryName
    // исправить Transaction + TransactionController
    // добавить обработку всех ошибок
    
    private final String key = "bc65e08beb56cbbfddeb0be7d6f1b440b6679faa174e83f5ad6d043a6fc171ad";
    private Logger logger = Logger.getLogger(getClass().getName());
    private ResponseObject response = new ResponseObject();
    private MessageBundlesController bundles = new MessageBundlesController();
    
    public RequestDispatcher(){
        
    }
    
    /**
     * 
     * @param request: Json string (received from InitTransactionServlet)
     * @return result of methods (getCountries and etc) processing 
     */
    public String generateResponse(String request) {

        String responseString = null;
        JsonParser parser = new JsonParser();   
        JsonObject mainObject = parser.parse(request).getAsJsonObject();
        RequestHandler requestHandler = new RequestHandler();
        Gson gson = new GsonBuilder()
                    .registerTypeAdapter(CancelTransaction.class, new CancelTransactionDeserializer())
                    .registerTypeAdapter(ReleaseTransaction.class, new ReleaseTransactionDeserialiser())
                    .create();
        
        logger.info("Incoming request: " + request);
        String locale = "en";
        if(mainObject.get("locale") != null)
            locale = mainObject.get("locale").toString().replace("\"", "");
        
        if(mainObject.get("method") == null) {
            return response.getJson(-1, bundles.getTranslation("TRANSPAY_METHOD_ABSENT", locale),"");
        }
       
        if(mainObject.get("sign") == null){
            return response.getJson(-1, bundles.getTranslation("TRANSPAY_SIGNATURE_ERROR", locale),"");
        }

        String signature = getSignature(mainObject);
        if(signature == null){
            return response.getJson(-1, bundles.getTranslation("TRANSPAY_SIGNATURE_ERROR", locale),"");
        }       
        
//        if(!mainObject.get("sign").toString().contains(signature)){
//            return response.getJson(-1, bundles.getTranslation("TRANSPAY_SIGNATURE_ERROR", locale),signature);
//        }

    
        if(mainObject.get("method").toString().contains("getRates")) {
            String SourceCurrencyIsoCode;
            String ReceiveCurrencyIsoCode;
           
            if(mainObject.get("sourceCurrencyIsoCode") != null) {
                SourceCurrencyIsoCode = mainObject.get("sourceCurrencyIsoCode").toString().replace("\"", "");
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": sourceCurrencyIsoCode","");
            }
            if(mainObject.get("receiveCountryIsoCode") != null) {
                    ReceiveCurrencyIsoCode = mainObject.get("receiveCountryIsoCode").toString().replace("\"", "");
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": receiveCountryIsoCode","");
            }
             
            return requestHandler.getRates(SourceCurrencyIsoCode, ReceiveCurrencyIsoCode);
        } 
        
        if(mainObject.get("method").toString().contains("getCountries")) {
            return requestHandler.getCountries();
        }
        
        if(mainObject.get("method").toString().contains("getAllCountries")) {
            return requestHandler.getAllCountries();
        }
        
        if(mainObject.get("method").toString().contains("changeCountriesStatus")) {
            String countryName;
            int changer;
            
            if(mainObject.get("countryIsoCode") != null) {
                countryName = mainObject.get("countryIsoCode").toString().replace("\"", "");
                if(Integer.parseInt(countryName)>1||Integer.parseInt(countryName)<0) {
                    return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": countryName","");
                }
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": countryName","");
            }
            
            if(mainObject.get("status") != null) {
                changer = mainObject.get("status").getAsInt();
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": status","");
            }
            
            return requestHandler.changeCountriesStatus(countryName, changer);
        }
        
        if(mainObject.get("method").toString().contains("getStates")) {
            if(mainObject.get("countryIsoCode") != null) {
                String countryIsoCode = mainObject.get("countryIsoCode").toString().replace("\"", "");
                return requestHandler.getStates(countryIsoCode);
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": countryIsoCode","");
            }
        }    
        if(mainObject.get("method").toString().contains("getAccountTypes")) {
            if(mainObject.get("countryIsoCode") != null) {
                String countryIsoCode = mainObject.get("countryIsoCode").toString().replace("\"", "");
                return requestHandler.getAccountTypes(countryIsoCode);
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": countryIsoCode","");
            }
        }       
         if(mainObject.get("method").toString().contains("getRemittancePurposes")) {
            if(mainObject.get("countryIsoCode") != null) {
                String countryIsoCode = mainObject.get("countryIsoCode").toString().replace("\"", "");
                return requestHandler.getRemittancePurposes(countryIsoCode);
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": countryIsoCode","");
            }
        }   
        if(mainObject.get("method").toString().contains("getCities")) {
            String countryIsoCode;
            String stateId = null;
            
            if(mainObject.get("countryIsoCode") != null) {
                countryIsoCode = mainObject.get("countryIsoCode").toString().replace("\"", "");
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": countryIsoCode","");
            }
            
            if(mainObject.get("stateId") != null) {
                stateId = mainObject.get("stateId").toString().replace("\"", "");
                return requestHandler.getCities(countryIsoCode, stateId);
            } 

            return requestHandler.getCities(countryIsoCode);
            
        } 

        if(mainObject.get("method").toString().contains("getTowns")) {
            String countryIsoCode;
            String stateId;
            int cityId;
            
            if(mainObject.get("countryIsoCode") != null) {
                countryIsoCode = mainObject.get("countryIsoCode").toString().replace("\"", "");
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": countryIsoCode","");
            }
            
            if(mainObject.get("stateId") != null) {
                stateId = mainObject.get("stateId").toString().replace("\"", "");
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": stateId","");
            }
            
            if(mainObject.get("cityId") != null) {
                cityId = mainObject.get("cityId").getAsInt();
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": cityId","");
            }
            
            return requestHandler.getTowns(countryIsoCode, stateId, cityId);
        }
        
        if(mainObject.get("method").toString().contains("getPaymentModes")) {
            String countryIsoCode;
            int cityId;
            
            if(mainObject.get("countryIsoCode") != null) {
                countryIsoCode = mainObject.get("countryIsoCode").toString().replace("\"", "");
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": countryIsoCode","");
            }
            
            if(mainObject.get("cityId") != null) {
                cityId = mainObject.get("cityId").getAsInt();
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": cityId","");
            }
            
            return requestHandler.getPaymentModes(countryIsoCode, cityId);
            
        } 
        
        if(mainObject.get("method").toString().contains("getReceiveCurrencies")) {
            String countryIsoCode;
            String stateId = "ST01"; // required, but it is not necessary to define correct value, it can be something like XX01 where XX - country iso code
            int cityId = 11111; // required, but it is not necessary to define correct value, it can be something like XXXXX where X - some digit
            String paymentModeId = "C";
           
            if(mainObject.get("countryIsoCode") != null) {
                countryIsoCode = mainObject.get("countryIsoCode").toString().replace("\"", "");
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": countryIsoCode","");
            }
            
//            if(mainObject.get("stateId") != null) {
//                stateId = mainObject.get("stateId").toString().replace("\"", "");
//            }else {
//                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": stateId","");
//            }
//            
//            if(mainObject.get("cityId") != null) {
//                cityId = mainObject.get("cityId").getAsInt();
//            } else {
//                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": cityId","");
//            }
            
            return requestHandler.getReceiveCurrencies(countryIsoCode, stateId, cityId, paymentModeId);
            
        } 
        
        if(mainObject.get("method").toString().contains("getBanks")) {
            String countryIsoCode;
            
            if(mainObject.get("countryIsoCode") != null) {
                countryIsoCode = mainObject.get("countryIsoCode").toString().replace("\"", "");
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": countryIsoCode","");
            }
            
            return requestHandler.getBanks(countryIsoCode);
            
        } 
        
        if(mainObject.get("method").toString().contains("getPayoutLimits")) {
            String receiverCountryIsoCode;
            
            if(mainObject.get("receiverCountryIsoCode") != null) {
                receiverCountryIsoCode = mainObject.get("receiverCountryIsoCode").toString().replace("\"", "");
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": receiverCountryIsoCode","");
            }
            
            return requestHandler.getPayoutLimits(receiverCountryIsoCode);
        } 
        
        if(mainObject.get("method").toString().contains("getPayers")) {
            String countryIsoCode;
            int cityId;
            String paymentModeId;
            String receiveCurrencyIsoCode;
            String sourceCurrencyIsoCode;
            if(mainObject.get("countryIsoCode") != null) {
                countryIsoCode = mainObject.get("countryIsoCode").toString().replace("\"", "");
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": countryIsoCode","");
            }
            
            if(mainObject.get("cityId") != null) {
                cityId = mainObject.get("cityId").getAsInt();
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": cityId","");
            }
            
            if(mainObject.get("paymentModeId") != null) {
                paymentModeId = mainObject.get("paymentModeId").toString().replace("\"", "");
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": paymentModeId","");
            }
            
            if(mainObject.get("receiveCurrencyIsoCode") != null) {
                receiveCurrencyIsoCode = mainObject.get("receiveCurrencyIsoCode").toString().replace("\"", "");
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": receiveCurrencyIsoCode","");
            }
            
            if(mainObject.get("sourceCurrencyIsoCode") != null) {
                sourceCurrencyIsoCode = mainObject.get("sourceCurrencyIsoCode").toString().replace("\"", "");
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": sourceCurrencyIsoCode","");
            }
            
            return requestHandler.getPayers(countryIsoCode, cityId, paymentModeId, receiveCurrencyIsoCode, sourceCurrencyIsoCode);
        }
        
        if(mainObject.get("method").toString().contains("getMandatoryFields")) {
            String countryIsoCode;//, locale = null;
            if(mainObject.get("countryIsoCode") != null) {
                countryIsoCode = mainObject.get("countryIsoCode").toString().replace("\"", "");
                if(mainObject.get("locale") != null)
                    locale = mainObject.get("locale").toString().replace("\"", "");
                else
                    locale = "ru";
            } else {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": countryIsoCode","");
            }
            return requestHandler.getMandatoryFields(countryIsoCode, locale);
        }
        
        if(mainObject.get("method").toString().contains("createTransaction")) {
           // String locale = null;
//            CountriesController countriesController = new CountriesController();
            this.response = new ResponseObject();
            System.out.println("Point 5");
            Transaction transaction = new Transaction();
            transaction = gson.fromJson(request, transaction.getClass());
//            MandatoryFieldsController mfcontroller = new MandatoryFieldsController();
//            List<String> validationResult = mfcontroller.validation(transaction);
            
//            CountryDB country = countriesController.getCountryFromDB(transaction.getReceiver().getReceiver_countryIsoCode());
//            int comOfMin = transaction.getTransactionInfo().getSentAmount().compareTo(country.getMinSum());
//            int comOfMax = transaction.getTransactionInfo().getSentAmount().compareTo(country.getMaxSum());
//            if(comOfMin == -1) {
//                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": sentAmount is less than \"min\" possible","");
//            }
//            if(comOfMax == 1) {
//                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": sentAmount is more then \"max\" possible","");
//            }
            
//            if(validationResult != null && validationResult.size() > 0 && validationResult.get(0).equals("TRANSPAY_SUCCESS")){
                
                transaction.getTransactionInfo().setPaymentModeId("C");
                responseString = requestHandler.createTransaction(transaction, /*country,*/ locale);
//            }else{
//                GeneralError err = new GeneralError();
//                TransPayError tperror = new TransPayError();
//                List<TransPayError> lerror =  new ArrayList<>();
//                int index = 0;
//                for (String item : validationResult) {
//                    logger.info(item); 
//                    if((index++%2)==0){
//                        logger.info(locale); 
//                        tperror.setMessage(bundles.getTranslation(item, locale));
//                    }else{
//                        tperror.setFieldName(item);
//                        lerror.add(tperror);
//                        tperror = new TransPayError();
//                    }
//                }
//                err.setDataValidationErrors(lerror);
//                
//                //return response.getJson(-1, bundles.getTranslation(validationResult, "en"),"");
//                return response.getJson(-1, bundles.getTranslation("TRANSPAY_PARAMETERS_ERROR", locale), err);
//            }
        }
        
        if(mainObject.get("method").toString().contains("cancelTransaction")) {
            CancelTransaction transaction = new CancelTransaction();
            transaction = gson.fromJson(request, transaction.getClass());
            
            if(transaction.getTfPin() == null)
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": transactionId","");
            
            if(transaction.getReasonId() == null)
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": ReasonId","");
            
            responseString = requestHandler.cancelTransaction(transaction, locale);
            // cancel Transaction
        }
        
        if(mainObject.get("method").toString().contains("releaseTransaction")) {
            ReleaseTransaction transaction = new ReleaseTransaction();
            transaction = gson.fromJson(request, transaction.getClass());
            
            if(transaction.getTfPin() == null)
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+": transactionId","");
            
            responseString = requestHandler.releaseTransaction(transaction, locale);
        }   
        
        if(mainObject.get("method").toString().contains("calculator")) {
            CalculatorRequest calcRequest = new CalculatorRequest();
            calcRequest = gson.fromJson(mainObject, calcRequest.getClass());
            String rez = calcRequest.checkFields();
            if(rez!=null) {
                return response.getJson(-1, bundles.getTranslation("TRANSPAY_INCORRECT_INFO", locale)+rez,"");
            }
            responseString = requestHandler.calculator(calcRequest);
        }

        return responseString;
    }
    
    /**
     * 
     * @param mainObject - param for which md5 hash string is constructed
     * @return signature for request
     */
    
    private String getSignature(JsonObject mainObject){
        
       String signature = "";
        
       for(Entry<String,JsonElement> entry: mainObject.entrySet()){
            if(!entry.getKey().equals("sign"))
            signature += entry.getValue().toString().replace("\"", "");
       }
       System.out.println(signature);
       signature = ResponseObject.md5Custom(signature + key);
        
       return signature;
    }
    
//    private String getSignature(JsonObject mainObject){
//        
//        String signature = "";
//        
//        for(Entry<String,JsonElement> entry: mainObject.entrySet()){
//            if(!entry.getKey().equals("sign"))
//            signature += entry.getValue().toString();
//        }
//       
//        signature = ResponseObject.md5Custom(signature + key);
//        
//        return signature;
//    }
    
 }
