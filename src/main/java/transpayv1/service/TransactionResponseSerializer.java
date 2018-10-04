/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import transpayv1.data.response.TransInfoResponse;
import transpayv1.data.response.TransactionResponse;
import java.lang.reflect.Type;

/**
 *
 * @author user
 */
public class TransactionResponseSerializer implements JsonSerializer<TransactionResponse>{

    @Override
    public JsonElement serialize(TransactionResponse t, Type type, JsonSerializationContext jsc) {
        
        TransInfoResponse ti = t.getTransactionInfo();
        
        JsonObject result = new JsonObject(); 
        if(t.getTfPin()!=null) {
            result.addProperty("status", t.getStatus());
        }
        if(t.getTfPin()!=null) {
            result.addProperty("transactionID", t.getTfPin());
        }
        if(ti!=null) {
            if(ti.getTotalSentAmount()!=null) {
                result.addProperty("amount", ti.getTotalSentAmount());
                if(ti.getSentAmount()!=null) {
                    result.addProperty("fee", ti.getTotalSentAmount().subtract(ti.getSentAmount()));
                }
            }
        }
        if(t.getDesc()!=null) {
            result.addProperty("desc", t.getDesc());
        }
        if(t.getAddDesc()!=null) {
            result.addProperty("addDesc", t.getAddDesc());
        }
        if(t.getDate()!=null) {
            result.addProperty("date", t.getDate().toString());
        }
        if(t.getSign()!=null) {
            result.addProperty("sign", t.getSign());
        }
        
        return result;
    }
    
}
