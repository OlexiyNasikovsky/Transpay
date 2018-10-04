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
public class CitiesBody extends AbstractResponse {
    
    private List<City> Cities = new ArrayList<City>();

    /**
     * @return the Cities
     */
    public List<City> getCities() {
        return Cities;
    }

    /**
     * @param Cities the Cities to set
     */
    public void setCities(List<City> Cities) {
        this.Cities = Cities;
    }
    
    
}
