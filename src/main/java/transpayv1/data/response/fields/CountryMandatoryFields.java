/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.response.fields;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Work
 */
public class CountryMandatoryFields {
    private String country_name;
    private String country_code;
    private List<Field> fields = new ArrayList<>();
    
    public void check(JsonObject request) {
        String param;
        for(Field f : fields) {
            if(f.isRequired()) {
                if(request.get(f.getTo_send())!=null) {
                    if((param = request.get(f.getTo_send()).toString()).equals("")) {
//                        if(!f.check(param)) {
////                          mandatory field incorrect ERROR
//                        }
                    } else {
//                      mandatory field is empty ERROR
                    }
                } else {
//                  mandatory field missed ERROR
                }
            }
        }
    }
    
    public void addCountryField(Field f) {
        fields.add(f);
    }

    /**
     * @return the country_name
     */
    public String getCountry_name() {
        return country_name;
    }

    /**
     * @param country_name the country_name to set
     */
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    /**
     * @return the country_code
     */
    public String getCountry_code() {
        return country_code;
    }

    /**
     * @param country_code the country_code to set
     */
    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    /**
     * @return the fields
     */
    public List<Field> getFields() {
        return fields;
    }

    /**
     * @param fields the fields to set
     */
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
