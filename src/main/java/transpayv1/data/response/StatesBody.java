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
public class StatesBody extends AbstractResponse{
    
    private List<State> States = new ArrayList<State>();

    /**
     * @return the States
     */
    public List<State> getStates() {
        return States;
    }

    /**
     * @param States the States to set
     */
    public void setStates(List<State> States) {
        this.States = States;
    }
}
