/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.request;

/**
 *
 * @author Work
 */

public class Transaction {
    private String locale;
    //private RequestSender Sender;
    private DefaultReceiver Receiver;
    private TransInfo TransactionInfo;
    //private Compliance TCompliance;

//    /**
//     * @return the Sender
//     */
//    public RequestSender getSender() {
//        return Sender;
//    }
//
//    /**
//     * @param Sender the Sender to set
//     */
//    public void setSender(RequestSender Sender) {
//        this.Sender = Sender;
//    }

    /**
     * @return the Receiver
     */
    public DefaultReceiver getReceiver() {
        return Receiver;
    }

    /**
     * @param Receiver the Receiver to set
     */
    public void setReceiver(DefaultReceiver Receiver) {
        this.Receiver = Receiver;
    }

    /**
     * @return the TransactionInfo
     */
    public TransInfo getTransactionInfo() {
        return TransactionInfo;
    }

    /**
     * @param TransactionInfo the TransactionInfo to set
     */
    public void setTransactionInfo(TransInfo TransactionInfo) {
        this.TransactionInfo = TransactionInfo;
    }

//    /**
//     * @return the TCompliance
//     */
//    public Compliance getTCompliance() {
//        return TCompliance;
//    }
//
//    /**
//     * @param TCompliance the TCompliance to set
//     */
//    public void setTCompliance(Compliance TCompliance) {
//        this.TCompliance = TCompliance;
//    }

    /**
     * @return the locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     * @param locale the locale to set
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }
}
