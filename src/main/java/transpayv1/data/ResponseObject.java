/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import transpayv1.data.response.AbstractResponse;
import transpayv1.data.response.TransactionResponse;
import transpayv1.data.response.errors.GeneralError;
import transpayv1.data.response.errors.TransPayError;
import transpayv1.service.TransactionResponseSerializer;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class for working with servlet responses
 * @author jk
 */
public class ResponseObject {
    
    Integer status;
    AbstractResponse data;
    String desc;
    String addDesc;
    Date date;
    String sign;
    List<String> errorFields = new ArrayList<>();
    //private Logger logger = Logger.getLogger(getClass().getName());
    
    public ResponseObject(){
        this.status = -1;
        this.desc = "Unknown response";
        this.addDesc = "";
        this.date = new java.util.Date();
        this.sign = composeSignature();
    }
    
    public ResponseObject(Integer status, String desc, AbstractResponse data, String addDesc){
        this.status = status;
        this.data = data;
        this.desc = desc;
        this.addDesc = addDesc;
        this.date = new java.util.Date();
        this.sign = composeSignature();
    }    
    
    /**
     * Responce object initialization
     * @param status
     * @param desc
     * @param data
     * @param addDesc
     * @return JSON String
     */
    public String getJson(Integer status, String desc, AbstractResponse data, String addDesc){        
        Gson gson = new Gson();
        this.status = status;
        this.data = data;
        this.desc = desc;
        this.addDesc = addDesc;
        this.date = new java.util.Date();
        this.sign = composeSignature();   
        return gson.toJson(this);
    }
    
    public String getTransactionJson(Integer status, String desc, TransactionResponse transaction, String addDesc){        
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(TransactionResponse.class, new TransactionResponseSerializer())
                .create();
        transaction.setStatus(status);
        transaction.setDesc(desc);
        transaction.setAddDesc(addDesc);
        transaction.setDate(new java.util.Date());
        transaction.setSign(composeSignature());
        return gson.toJson(transaction);
    }
    
    public String getJson(Integer status, String desc, GeneralError err){        
        Gson gson = new Gson();
        this.status = status;
        
        if(!err.getBusinessErrors().isEmpty())
            for(TransPayError e : err.getBusinessErrors()) {
                 this.errorFields.add(e.getFieldName().replace("Receiver.", "").replace("TransactionInfo.", ""));
                if(addDesc.isEmpty()) {
                    addDesc += e.getMessage();
                } else {
                    addDesc += ", " + e.getMessage();
                }
            }
        
        if(!err.getDataValidationErrors().isEmpty())
            
            for(TransPayError e : err.getDataValidationErrors()) {
           //     logger.info(e.getMessage());
                this.errorFields.add(e.getFieldName().replace("Receiver.", "").replace("TransactionInfo.", ""));
                if(this.addDesc.isEmpty()) {
                    this.addDesc += e.getMessage();
                } else {
                    this.addDesc += " " + e.getMessage();
                }
            }
         //   logger.info(this.addDesc);
        
//        if(!err.getErrorCode().equals(null) || !err.getMessage().equals(null)) {
//            this.data = err;
//        }
        
        this.desc = desc;
        this.date = new java.util.Date();
        this.sign = composeSignature();   
      //  logger.info(this.desc);
        
       // logger.info(gson.toJson(this));
        return gson.toJson(this);
    }
    
    public String getJson(Integer status, String desc, String addDesc){        
        Gson gson = new Gson();
        this.status = status;
        this.desc = desc;
        this.addDesc = addDesc;
        this.date = new java.util.Date();
        this.sign = composeSignature();   
        return gson.toJson(this);
    }
    
    private String composeSignature(){
        String signature = this.status.toString() + this.desc + this.data + this.addDesc + this.date.toString();     
        return ResponseObject.md5Custom(signature);
    }

    
    /**
    * 
    * @param st - string which is decoded into md5 format
    * @return md5 hash string
    */
    
    public static String md5Custom(String st) {
       MessageDigest messageDigest = null;
       byte[] digest = new byte[0];

       try {
           messageDigest = MessageDigest.getInstance("MD5");
           messageDigest.reset();
           messageDigest.update(st.getBytes());
           digest = messageDigest.digest();
       } catch (NoSuchAlgorithmException e) {
           return null;
       }

       BigInteger bigInt = new BigInteger(1, digest);
       String md5Hex = bigInt.toString(16);

       while( md5Hex.length() < 32 ){
           md5Hex = "0" + md5Hex;
       }

       return md5Hex;
    }
    
}
