/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.service;

import transpayv1.data.request.Transaction;
import transpayv1.data.response.CountryDB;
import transpayv1.data.response.TransactionResponse;
import transpayv1.util.DBConnectionManager;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Transaction controller class
 * @author jk
 */
public class TransactionController {

    private Logger logger = Logger.getLogger(getClass().getName());
    
    public Boolean saveTransaction(Transaction transaction, String tfPin) {

        // Create a Database connection
        Connection connection = DBConnectionManager.getConnection();
        PreparedStatement statement = null ;
        
        // Create statement
        try {
//            statement= connection.prepareStatement("insert into `site_transactions` "
//                    + "(receiver_firstName,receiver_lastName,receiver_completeAddress,receiver_stateId,"
//                    + "receiver_countryIsoCode, receiver_cityId,receiver_mobilePhone,receiver_email,receiver_notes,receiver_notesOtherLanguage,"
//                    + "paymentModeId,sourceCurrencyIsoCode,receiveCurrencyIsoCode,account,payerId,"
//                    + "payingBranchId,rate,totalSentAmount,sentAmount,"
//                    + "serviceFee,formOfPaymentId,bankId,receiver_lastNameOtherLanguage, tfPin) "
//                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ;");

            statement = connection.prepareStatement("insert into `site_transactions` (tfPin) values(?)");
            statement.setString(1,tfPin);
                    
//            statement.setString(1,transaction.getReceiver().getReceiver_firstName());
//            statement.setString(2,transaction.getReceiver().getReceiver_lastName());
//            statement.setString(3,transaction.getReceiver().getReceiver_completeAddress());
//            statement.setString(4,transaction.getReceiver().getReceiver_stateId());
//            statement.setString(5,transaction.getReceiver().getReceiver_countryIsoCode()); 
//
//            if(transaction.getReceiver().getReceiver_cityId() != null){
//                statement.setString(6,transaction.getReceiver().getReceiver_cityId().toString());
//            }else{
//                statement.setString(6, null);
//            }
//
//            statement.setString(7,transaction.getReceiver().getReceiver_mobilePhone());
//            statement.setString(8,transaction.getReceiver().getReceiver_email());
//            statement.setString(9,transaction.getReceiver().getReceiver_notes());
//            statement.setString(10,transaction.getReceiver().getReceiver_notesOtherLanguage());   
//           ///  
//            statement.setString(11,transaction.getTransactionInfo().getPaymentModeId());
//            statement.setString(12,transaction.getTransactionInfo().getSourceCurrencyIsoCode());
//            statement.setString(13,transaction.getTransactionInfo().getReceiveCurrencyIsoCode());                
//            statement.setString(14,transaction.getTransactionInfo().getAccount());
//            statement.setString(15,transaction.getTransactionInfo().getPayerId());                
//            statement.setString(16,transaction.getTransactionInfo().getPayingBranchId());    
//            if(transaction.getTransactionInfo().getRate() != null){
//                statement.setBigDecimal(17,transaction.getTransactionInfo().getRate());
//            }else{
//                statement.setFloat(17, 0);
//            }
//            if(transaction.getTransactionInfo().getTotalSentAmount() != null){
//                statement.setBigDecimal(18,transaction.getTransactionInfo().getTotalSentAmount());
//            }else{
//                statement.setFloat(18, 0);
//            }
//            statement.setBigDecimal(19,transaction.getTransactionInfo().getSentAmount());     
//
//
//            if(transaction.getTransactionInfo().getServiceFee() != null){
//                statement.setBigDecimal(20,transaction.getTransactionInfo().getServiceFee());  
//            }else{
//                statement.setFloat(20,0);  
//            }
//
//            statement.setString(21,transaction.getTransactionInfo().getFormOfPaymentId());
//            statement.setString(22,transaction.getTransactionInfo().getBankId()); 
//            statement.setString(23,transaction.getReceiver().getReceiver_full_name_other_language()); 
//            statement.setString(24,tfPin); 

            logger.info(statement.toString());
            statement.executeUpdate();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            
                logger.info("TransactionController error: " + e.getMessage());
                return false;
        }
        return true;
    }
    
    public Boolean saveTransactionStatus(int status, String TfPin) {
        Connection connection = DBConnectionManager.getConnection();
        PreparedStatement statement = null ;
        try {
            statement= connection.prepareStatement("update `site_transactions` set `status` =" + status + " where `tfPin` = \"" + TfPin + "\";");
            
            logger.info(statement.toString());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
                logger.info("TransactionController error: " + e.getMessage());
                return false;
        }
        
        return true;
    }
    
    public TransactionResponse prepareFeeAndAmount(TransactionResponse response, CountryDB country) {
        
        BigDecimal sentAmount = response.getTransactionInfo().getSentAmount();
        BigDecimal totalSentAmount = response.getTransactionInfo().getTotalSentAmount();
        if(sentAmount == null || totalSentAmount == null) {
            return null;
        }
        
//        находим сумму комиссии moresise
        BigDecimal moresiseFeeAmount = new BigDecimal(0);
        if(country.getPercFee()!=null) {
            moresiseFeeAmount = sentAmount.multiply(country.getPercFee()
                                        .divide(new BigDecimal(100)));
        }
        moresiseFeeAmount = moresiseFeeAmount.add(country.getFixedFee());
        
//        добавляем к общей сумме с комиссией transpay еще и комиссию moresise
        response.getTransactionInfo().setTotalSentAmount(totalSentAmount.add(moresiseFeeAmount));
        
//        ServiceFee = FixedFee + FixedFeeTransp
//        response.getTransactionInfo().setServiceFee(country.getFixedFee().add(country.getFixedFeeTransp()));
        
//        изменить на нахождение фиксированной транспея из имеющихся данных, 
//        сравнение с имеющимися в БД и изменение в случае необходимости
        return response;
    }
    
    public TransactionController() {
    }
}
