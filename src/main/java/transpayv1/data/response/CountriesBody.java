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
 * @author Work
 */
public class CountriesBody extends AbstractResponse {
    
    private List<Country> Countries = new ArrayList<Country>();

    /**
     * @return the Countries
     */
    public List<Country> getCountries() {
        return Countries;
    }

    /**
     * @param Countries the Countries to set
     */
    
    public void setCountries(ArrayList<Country> Countries) {
        this.Countries = Countries;
    }
    
    /**
     * delete Countries without isocode/name
     */
    public void delUnfilled() {
        List<Country> remooveList = new ArrayList<Country>();
        for(Country country : Countries) {
            if(country.getName().equals("ST. LUCIA")) {
                if(country.getIsoCode() == null ||
                        country.getName() == null) {
                    remooveList.add(country);
                }
            }
        }
        for(Country country : remooveList) {
            Countries.remove(country);
        }
    }
    
}
