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
public class AccountTypesBody extends AbstractResponse {
    private List<AccountType> AccountTypes = new ArrayList<AccountType>();

    /**
     * @return the AccountTypes
     */
    public List<AccountType> getAccountTypes() {
        return AccountTypes;
    }

    /**
     * @param AccountTypes the AccountTypes to set
     */
    public void setAccountTypes(List<AccountType> AccountTypes) {
        this.AccountTypes = AccountTypes;
    }
}
