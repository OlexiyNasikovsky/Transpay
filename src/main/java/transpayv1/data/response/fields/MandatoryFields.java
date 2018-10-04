/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.response.fields;

import transpayv1.data.response.AbstractResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Work
 */
public class MandatoryFields  extends AbstractResponse {
    
    private List<CountryMandatoryFields> countries = new ArrayList<>();
    
    public MandatoryFields() {
    }
    
    public CountryMandatoryFields getFields(String countryCode){
        
        for(CountryMandatoryFields country : getCountries()) {
            if(country.getCountry_code().equals(countryCode)) {
                return country;
            }
        }
        return null; // no such country ERROR
    }
    
    public void addCountryFiels(CountryMandatoryFields cmf) {
        countries.add(cmf);
    }

    /**
     * @return the countries
     */
    public List<CountryMandatoryFields> getCountries() {
        return countries;
    }

    /**
     * @param countries the countries to set
     */
    public void setCountries(List<CountryMandatoryFields> countries) {
        this.countries = countries;
    }
    
    
}
