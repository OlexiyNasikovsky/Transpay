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
 * @author Moresise
 */
public class RemittancePurposesBody  extends AbstractResponse{
    
    private List<RemittancePurpose> RemittancePurposes = new ArrayList<RemittancePurpose>();

    /**
     * @return the RemittancePurposes
     */
    public List<RemittancePurpose> getRemittancePurposes() {
        return RemittancePurposes;
    }

    /**
     * @param RemittancePurposes the RemittancePurposes to set
     */
    public void setRemittancePurposes(List<RemittancePurpose> RemittancePurposes) {
        this.RemittancePurposes = RemittancePurposes;
    }
}
