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
public class TownsBody extends AbstractResponse {
    
    private List<Town> Towns = new ArrayList<Town>();

    /**
     * @return the Towns
     */
    public List<Town> getTowns() {
        return Towns;
    }

    /**
     * @param Towns the Towns to set
     */
    public void setTowns(List<Town> Towns) {
        this.Towns = Towns;
    }
}
