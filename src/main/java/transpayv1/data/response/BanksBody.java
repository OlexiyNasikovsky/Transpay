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
public class BanksBody extends AbstractResponse {
    private List<Bank> Banks = new ArrayList<Bank>();

    /**
     * @return the Banks
     */
    public List<Bank> getBanks() {
        return Banks;
    }

    /**
     * @param Banks the Banks to set
     */
    public void setBanks(List<Bank> Banks) {
        this.Banks = Banks;
    }
}
