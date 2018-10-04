/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.response;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class CountriesBodyDB extends AbstractResponse {
    
    private List<CountryDB> Countries = new ArrayList<CountryDB>();

    /**
     * @return the Countries
     */
    public List<CountryDB> getCountries() {
        return Countries;
    }

    /**
     * @param Countries the Countries to set
     */
    public void setCountries(List<CountryDB> Countries) {
        this.Countries = Countries;
    }
    
    public void addCountry(CountryDB country) {
        Countries.add(country);
    }
    
}
