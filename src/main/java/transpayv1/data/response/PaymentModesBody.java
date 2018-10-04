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
public class PaymentModesBody extends AbstractResponse {
    private List<PaymentMode> PaymentModes = new ArrayList<PaymentMode>();

    /**
     * @return the PaymentModes
     */
    public List<PaymentMode> getPaymentModes() {
        return PaymentModes;
    }

    /**
     * @param PaymentModes the PaymentModes to set
     */
    public void setPaymentModes(List<PaymentMode> PaymentModes) {
        this.PaymentModes = PaymentModes;
    }
}
