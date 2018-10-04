/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import transpayv1.data.request.Transaction;
import transpayv1.data.response.CountryDB;
import transpayv1.data.response.fields.CountryMandatoryFields;
import transpayv1.data.response.fields.Field;
import transpayv1.data.response.fields.MandatoryFields;
import transpayv1.util.DBConnectionManager;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


/**
 *
 * @author Moresise
 */
public class MandatoryFieldsController {
    
    private Logger logger = Logger.getLogger(getClass().getName());
    private MessageBundlesController bundlesController = new MessageBundlesController();
    
    
    public MandatoryFields getMandatoryInfo(String countryIsoCode, String locale){

        MandatoryFields mFields = new MandatoryFields();
        mFields.setCountries(this.getMandatoryFieldsByCountry(countryIsoCode, locale));
        
        return mFields;
    }
    
    private List<CountryMandatoryFields> getMandatoryFieldsByCountry(String countryIsoCode, String locale){
        
        Connection connection = DBConnectionManager.getConnection();
        
        List<CountryMandatoryFields> fields = new ArrayList<>();

        try {
            String query = "select * from `site_transpay_countries` where `country_code`='" + countryIsoCode +"'";
            logger.info(query);
            //statement= connection.prepareStatement("select * from `site_transpay_countries` where `country_code`=" + countryIsoCode);
            Statement statement = connection.createStatement();
            statement.execute("set character set utf8");
            statement.execute("set names utf8");
            
            ResultSet rs = statement.executeQuery(query);
             
            while (rs.next()) {

                fields.add(createCMF(rs, locale));
            }
            
            logger.info(statement.toString());
            
            statement.close();
            connection.close();

        } catch (SQLException e) {
            
                logger.info("MandatoryFieldsController error: " + e.getMessage());
                return null;
        }
        return fields;
    }
       
    private CountryMandatoryFields createCMF(ResultSet rs, String locale) throws SQLException {
  
        Gson gson = new Gson();
       
        CountryMandatoryFields cmf = new CountryMandatoryFields();
        
        cmf.setCountry_code(rs.getString("country_code"));
        cmf.setCountry_name(rs.getString("country_name"));
        
//        bnf_first_name
        if(rs.getInt("bnf_first_name") > 0)
        cmf.addCountryField(new Field()
                .setParent("Receiver")
                .setLabel(bundlesController.getTranslation(rs.getString("bnf_first_name_fieldlabel"), locale))
                .setRequired(rs.getInt("bnf_first_name"))               
                .setTo_send(rs.getString("bnf_first_name_fieldtosend"))
                .setInput_type(rs.getString("bnf_first_name_fieldtype")));
        
//        bnf_last_name
        if(rs.getInt("bnf_last_name") > 0)
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("bnf_last_name_fieldlabel"), locale))
                .setRequired(rs.getInt("bnf_last_name"))
                .setTo_send(rs.getString("bnf_last_name_fieldtosend"))
                .setParent("Receiver")
                .setInput_type(rs.getString("bnf_last_name_fieldtype")));
        
//        bnf_address
        if(rs.getInt("bnf_address") > 0)
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("bnf_address_fieldlabel"), locale))
                .setRequired(rs.getInt("bnf_address"))
                .setTo_send(rs.getString("bnf_address_fieldtosend"))
                .setParent("Receiver")
                .setInput_type(rs.getString("bnf_address_fieldtype")));
        
//        phone
        if(rs.getInt("phone") > 0)       
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("phone_fieldlabel"), locale))
                .setRequired(rs.getInt("phone"))
                .setTo_send(rs.getString("phone_fieldtosend"))
                .setInput_type(rs.getString("phone_fieldtype"))
                .setParent("Receiver")
                .setRegular(rs.getString("phone_fieldregular")) );          
        
//        bnf_DOB
        logger.info(new Integer(rs.getInt("bnf_DOB")).toString() + "=bnf_DOB");
        if(rs.getInt("bnf_DOB") > 0)        
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("bnf_DOB_fieldlabel"), locale))
                .setRequired(rs.getInt("bnf_DOB"))
                .setTo_send(rs.getString("bnf_DOB_fieldtosend"))
                .setParent("Receiver")
                .setInput_type(rs.getString("bnf_DOB_fieldtype")));

        
//        amount
        if(rs.getInt("amount") > 0)        
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("amount_fieldlabel"), locale))
                .setRequired(rs.getInt("amount"))
                .setTo_send(rs.getString("amount_fieldtosend"))
                .setParent("TransactionInfo")
                .setInput_type(rs.getString("amount_fieldtype")));
        
//        source_currency
        List<String> scurrencies = new ArrayList<>();
        scurrencies.add("EUR");
        scurrencies.add("USD");
        if(rs.getInt("source_currency") > 0)        
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("source_currency_fieldlabel"), locale))
                .setRequired(rs.getInt("source_currency"))
                .setTo_send(rs.getString("source_currency_fieldtosend"))
                .setParent("TransactionInfo")
                .setInput_type(rs.getString("source_currency_fieldtype"))
                .setValues(scurrencies)
                );
        
//        pay_out_currency
        if(rs.getInt("pay_out_currency") > 0)        
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("pay_out_currency_fieldlabel"), locale))
                .setRequired(rs.getInt("pay_out_currency"))
                .setParent("TransactionInfo")
                .setTo_send(rs.getString("pay_out_currency_fieldtosend"))
                .setInput_type(rs.getString("pay_out_currency_fieldtype"))
                .setData_source(rs.getString("pay_out_currency_data_source"))
                );
        
//        registration_or_id
        if(rs.getInt("registration_or_id") > 0)        
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("registration_or_id_fieldlabel"), locale))
                .setRequired(rs.getInt("registration_or_id"))
                .setTo_send(rs.getString("registration_or_id_fieldtosend"))
                .setInput_type(rs.getString("registration_or_id_fieldtype"))
                .setParent("Receiver")
                .setRegular(rs.getString("registration_or_id_fieldregular")) );          
               
        
//        bank_name
        if(rs.getInt("bank_name") > 0)        
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("bank_name_fieldlabel"), locale))
                .setRequired(rs.getInt("bank_name"))
                .setTo_send(rs.getString("bank_name_fieldtosend"))
                .setParent("TransactionInfo")
                .setInput_type(rs.getString("bank_name_fieldtype"))
                .setData_source(rs.getString("bank_name_data_source"))
                );

        
//        account
        if(rs.getInt("account") > 0)        
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("account_fieldlabel"), locale))
                .setRequired(rs.getInt("account"))
                .setTo_send(rs.getString("account_fieldtosend"))
                .setInput_type(rs.getString("account_fieldtype"))
                .setParent("TransactionInfo")
                .setRegular(rs.getString("account_fieldregular")) );              
        
//        bank_branch
        if(rs.getInt("bank_branch") > 0)        
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("bank_branch_fieldlabel"), locale))
                .setRequired(rs.getInt("bank_branch"))
                .setTo_send(rs.getString("bank_branch_fieldtosend"))
                .setInput_type(rs.getString("bank_branch_fieldtype"))
                .setParent("TransactionInfo")
                .setRegular(rs.getString("bank_branch_fieldregular"))
                );
        
//        account_type
        if(rs.getInt("account_type") > 0)
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("account_type_fieldlabel"), locale))
                .setRequired(rs.getInt("account_type"))
                .setParent("TransactionInfo")
                .setTo_send(rs.getString("account_type_fieldtosend"))
                .setInput_type(rs.getString("account_type_fieldtype")));
       
//        purpose_of_remittance
        if(rs.getInt("purpose_of_remittance") > 0)
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("purpose_of_remittance_fieldlabel"), locale))
                .setRequired(1)
                .setParent("TransactionInfo")
                .setTo_send(rs.getString("purpose_of_remittance_fieldtosend"))
                .setInput_type(rs.getString("purpose_of_remittance_fieldtype")));
        
//        city
        if(rs.getInt("city") > 0)
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("city_fieldlabel"), locale))
                .setRequired(rs.getInt("city"))
                .setParent("Receiver")
                .setTo_send(rs.getString("city_fieldtosend"))
                .setInput_type(rs.getString("city_fieldtype")));
                
        //if(rs.getInt("notes_other_language") > 0)
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("notes_other_language_fieldlabel"), locale))
                .setRequired(rs.getInt("notes_other_language"))
                .setParent("Receiver")
                .setTo_send(rs.getString("notes_other_language_fieldtosend"))
                .setInput_type(rs.getString("notes_other_language_fieldtype")));

        if(rs.getInt("fullname_other_language") > 0)
        cmf.addCountryField(new Field()
                .setLabel(bundlesController.getTranslation(rs.getString("fullname_other_language_fieldlabel"), locale))
                .setRequired(rs.getInt("fullname_other_language"))
                .setParent("Receiver")
                .setTo_send(rs.getString("fullname_other_language_fieldtosend"))
                .setInput_type(rs.getString("fullname_other_language_fieldtype")));
        
//        cmf.addCountryField(new Field()
//                .setLabel(bundlesController.getTranslation(rs.getString("country_code_fieldlabel"), locale))
//                .setRequired(1)
//                .setParent("Receiver")
//                .setTo_send(rs.getString("country_code_fieldtosend"))
//                .setRegular(rs.getString("country_code_fieldregular"))
//                .setInput_type(rs.getString("country_code_fieldtype")));        
        
        return cmf;
    }
    
    
    public List <String> validation(Transaction transaction){
        
       String retVal = "TRANSPAY_SUCCESS";
       List <String> retList = new ArrayList<>();
        if(transaction == null){
            //retVal = "TRANSPAY_BAD_REQUEST";
            retList.add("TRANSPAY_BAD_REQUEST");
        }else{
            
            String countryIsoCode = transaction.getReceiver().getReceiver_countryIsoCode();
            
            if(countryIsoCode != null){
            // Create statement
                try { 
                    Connection connection = DBConnectionManager.getConnection();
                    String query = "select * from `site_transpay_countries` where `country_code`='" + countryIsoCode +"'";
                    logger.info(query);
                    Statement statement = connection.createStatement();

                    ResultSet rs = statement.executeQuery(query);
                    if (rs.next()) {
                        if(rs.getInt("bnf_first_name") > 0){
                            if(transaction.getReceiver().getReceiver_firstName() == null){
                                //retVal = "TRANSPAY_FIRSTNAME_REQUIRED";
                                retList.add("TRANSPAY_FIRSTNAME_REQUIRED");
                                retList.add(rs.getString("bnf_first_name_fieldtosend"));
                                       
                            }
                        }
                        if(rs.getInt("bnf_last_name") > 0){
                            if(transaction.getReceiver().getReceiver_lastName() == null){
                                //retVal = "TRANSPAY_LASTNAME_REQUIRED";
                                retList.add("TRANSPAY_LASTNAME_REQUIRED");
                                retList.add(rs.getString("bnf_last_name_fieldtosend"));
                            }
                        }
                        if(rs.getInt("bnf_address") > 0){
                            if(transaction.getReceiver().getReceiver_completeAddress()== null){
                                //retVal = "TRANSPAY_ADDRESS_REQUIRED";
                                retList.add("TRANSPAY_ADDRESS_REQUIRED");
                                retList.add(rs.getString("bnf_address_fieldtosend"));
                            }
                        }
                        if(rs.getInt("phone") > 0){
                            if(transaction.getReceiver().getReceiver_mobilePhone() == null){
                                retList.add("TRANSPAY_MOBILE_PHONE_REQUIRED");
                                retList.add(rs.getString("phone_fieldtosend"));
                                //retVal = "TRANSPAY_MOBILE_PHONE_REQUIRED";
                            }
                        }
                        
                        if(rs.getInt("bnf_DOB") > 0){
                            if(transaction.getReceiver().getReceiver_birthday() == null){
                                //retVal = "TRANSPAY_RECEIVER_DOB_REQUIRED";
                                retList.add("TRANSPAY_RECEIVER_DOB_REQUIRED");
                                retList.add(rs.getString("bnf_DOB_fieldtosend"));
                            }
                        } 
                        if(rs.getInt("amount") > 0){
                            if(transaction.getTransactionInfo().getSentAmount() == null){
                                //retVal = "TRANSPAY_AMOUNT_REQUIRED";
                                retList.add("TRANSPAY_AMOUNT_REQUIRED");
                                retList.add(rs.getString("amount_fieldtosend"));
                            }
                        } 
                        if(rs.getInt("source_currency") > 0){
                            if(transaction.getTransactionInfo().getSourceCurrencyIsoCode() == null){
                                //retVal = "TRANSPAY_SCURRENCY_REQUIRED";
                                retList.add("TRANSPAY_SCURRENCY_REQUIRED");
                                retList.add(rs.getString("source_currency_fieldtosend"));
                            }else if(!transaction.getTransactionInfo().getSourceCurrencyIsoCode().equals("EUR") &&
                                    !transaction.getTransactionInfo().getSourceCurrencyIsoCode().equals("USD")){
                                retList.add("TRANSPAY_SCURRENCY_INCORRECT");
                                retList.add(rs.getString("source_currency_fieldtosend"));                           
                            }
                        }
                        if(rs.getInt("pay_out_currency") > 0){
                            if(transaction.getTransactionInfo().getReceiveCurrencyIsoCode() == null){
                                //retVal = "TRANSPAY_RCURRENCY_REQUIRED";
                                retList.add("TRANSPAY_RCURRENCY_REQUIRED");
                                retList.add(rs.getString("pay_out_currency_fieldtosend"));
                            }
                        }                
                        if(rs.getInt("registration_or_id") > 0){
                            if(transaction.getReceiver().getReceiver_idnumber() == null){
                                //retVal = "TRANSPAY_REGISTRATION_REQUIRED";
                                retList.add("TRANSPAY_REGISTRATION_REQUIRED");
                                retList.add(rs.getString("registration_or_id_fieldtosend"));
                            }
                        } 
                       if(rs.getInt("bank_name") > 0){
                            if(transaction.getTransactionInfo().getBankId() == null){
                                //retVal = "TRANSPAY_BANK_NAME_REQUIRED";
                                retList.add("TRANSPAY_BANK_NAME_REQUIRED");
                                retList.add(rs.getString("bank_name_fieldtosend"));
                            }
                        }      
                       if(rs.getInt("account") > 0){
                            if(transaction.getTransactionInfo().getAccount() == null){
                                //retVal = "TRANSPAY_ACCOUNT_REQUIRED";
                                retList.add("TRANSPAY_ACCOUNT_REQUIRED");
                                retList.add(rs.getString("account_fieldtosend"));
                            }
                        }        
                       if(rs.getInt("bank_branch") > 0){
                            if(transaction.getTransactionInfo().getBankRoutingNumber() == null){
                                //retVal = "TRANSPAY_BANK_BRANCH_REQUIRED";
                                retList.add("TRANSPAY_BANK_BRANCH_REQUIRED");
                                retList.add(rs.getString("bank_branch_fieldtosend"));
                            }
                        }                

                       if(rs.getInt("account_type") > 0){
                            if(transaction.getTransactionInfo().getAccountTypeId() == null){
                                //retVal = "TRANSPAY_TACCOUNT_REQUIRED";
                                retList.add("TRANSPAY_TACCOUNT_REQUIRED");
                                retList.add(rs.getString("account_type_fieldtosend"));
                            }
                        }  
                        if(rs.getInt("purpose_of_remittance") > 0){
                            if(transaction.getTransactionInfo().getPurposeOfRemittanceId() == null){
                                //retVal = "TRANSPAY_PURPOSE_REQUIRED";
                                retList.add("TRANSPAY_PURPOSE_REQUIRED");
                                retList.add(rs.getString("purpose_of_remittance_fieldtosend"));
                            }
                        }
                        if(rs.getInt("city") > 0){
                            if(transaction.getReceiver().getReceiver_cityId() == null){
                             //   retVal = "TRANSPAY_CITY_REQUIRED";
                                retList.add("TRANSPAY_CITY_REQUIRED");
                                retList.add(rs.getString("city_fieldtosend"));
                            }
                        } 
                        if(transaction.getReceiver().getReceiver_notesOtherLanguage() == null){
                                //retVal = "TRANSPAY_PURPOSE_REQUIRED";
                                retList.add("TRANSPAY_NOTES_REQUIRED");
                                retList.add(rs.getString("notes_other_language_fieldtosend"));
                        }
                      
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    //retVal = "TRANSPAY_ERROR";
                    retList.add("TRANSPAY_ERROR");
                }
            }else{
                
                retList.add("TRANSPAY_COUNTRY_REQUIRED");
               
            }
        }
        if(retList.size() == 0){
            retList.add(retVal);
        }
        return retList;
    }
}
