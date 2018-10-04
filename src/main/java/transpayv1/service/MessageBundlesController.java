/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.service;

import transpayv1.util.DBConnectionManager;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 *
 * @author Moresise
 */
public class MessageBundlesController {
    
    private Logger logger = Logger.getLogger(getClass().getName());
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Charset win_1251 = Charset.forName("windows-1251");
    public static final Charset cp1251 = Charset.forName("cp1251");
    
    
    public String getTranslation(String code, String locale){
        
        String translation = "Undefined string:" + code;
        
        Connection connection = DBConnectionManager.getConnection();
        
        try {
            locale = locale.toLowerCase();
            String query = "select * from `site_transpay_bundles` where `code`='" + code +"'";
            logger.info(query);
            //statement= connection.prepareStatement("select * from `site_transpay_countries` where `country_code`=" + countryIsoCode);
            Statement statement = connection.createStatement();
            statement.execute("SET NAMES utf8");
            ResultSet rs = statement.executeQuery(query);
            
             while (rs.next()) {
                 if(locale == null || !locale.equals("en") && !locale.equals("ua") && !locale.equals("ru")){
                     locale = "ru";
                 }
                 String fieldName = "description_"+locale;
                 translation = rs.getString(fieldName);
             }
             
            logger.info(translation);
             
            statement.close();
            connection.close();
             
        } catch (SQLException e) {
            
                logger.info("MessageBundlesController error: " + e.getMessage());
                return null;
        }
        return translation;
    }
    
}
