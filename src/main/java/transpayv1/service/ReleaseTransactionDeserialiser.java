/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.service;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import transpayv1.data.request.ReleaseTransaction;
import java.lang.reflect.Type;

/**
 *
 * @author user
 */
public class ReleaseTransactionDeserialiser implements JsonDeserializer<ReleaseTransaction> {
    
    

    @Override
    public ReleaseTransaction deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonObject jsonObject = je.getAsJsonObject();
        
        ReleaseTransaction rt = new ReleaseTransaction();
        
        rt.setTfPin(jsonObject.get("transactionId").getAsString().replace("\"", ""));
        
        return rt;
    }
}
