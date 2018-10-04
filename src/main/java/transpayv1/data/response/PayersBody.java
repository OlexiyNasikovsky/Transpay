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
public class PayersBody extends AbstractResponse {
    private List<PayersResults> MasterPayerResults = new ArrayList<PayersResults>();

    /**
     * @return the MasterPayerResults
     */
    public List<PayersResults> getMasterPayerResults() {
        return MasterPayerResults;
    }

    /**
     * @param MasterPayerResults the MasterPayerResults to set
     */
    public void setMasterPayerResults(List<PayersResults> MasterPayerResults) {
        this.MasterPayerResults = MasterPayerResults;
    }
}
