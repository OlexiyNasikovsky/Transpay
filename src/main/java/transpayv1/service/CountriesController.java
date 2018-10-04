/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.service;

import transpayv1.data.response.CountriesBodyDB;
import transpayv1.data.response.CountryDB;
import transpayv1.data.response.Country;
import transpayv1.util.DBConnectionManager;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
/**
 *
 * @author user
 */
public class CountriesController {
    
    private Logger logger = Logger.getLogger(getClass().getName());
    
    public List<CountryDB> getCountriesDB() {
        
        Connection connection = DBConnectionManager.getConnection();
        List<CountryDB> countries = new ArrayList<>();
        
        try {
            String query = "select * from `site_transpay_commission` where `switch`= " + 1 + ";";
            logger.info(query);
            
            Statement statement = connection.createStatement();
            statement.execute("set character set utf8");
            statement.execute("set names utf8");
            
            ResultSet rs = statement.executeQuery(query);
             
            while (rs.next()) {
                CountryDB country = createCountry(rs);
                countries.add(fixedFeeCorrection(country));
            }
            
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.info("CountriesController error: " + e.getMessage());
            return null;
        }
        
        return countries;
    }
    
    public List<CountryDB> getAllCountriesDB() {
        Connection connection = DBConnectionManager.getConnection();
        List<CountryDB> countries = new ArrayList<>();
        
        try {
            String query = "select * from `site_transpay_commission`";
            logger.info(query);
            
            Statement statement = connection.createStatement();
            statement.execute("set character set utf8");
            statement.execute("set names utf8");
            
            ResultSet rs = statement.executeQuery(query);
             
            while (rs.next()) {
                CountryDB country = createCountry(rs);
                if(country.getIsoCode().equals("TG"))
                countries.add(fixedFeeCorrection(country));
            }
            
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.info("CountriesController error: " + e.getMessage());
            return null;
        }
        
        return countries;
    }
    
    public boolean changeCountryStatus(String countryIsoCode, int status) {
        Connection connection = DBConnectionManager.getConnection();
        List<CountryDB> countries = new ArrayList<>();
        
        try {
            String query = "update `site_transpay_commission` set `switch` = " + status + " where "
                            + "`country_iso_code` = '" + countryIsoCode + "' and `id` > 0;";
            logger.info(query);
            
            Statement statement = connection.createStatement();
            statement.execute("set character set utf8");
            statement.execute("set names utf8");
            
            statement.executeUpdate(query);
            
            statement.close();
            connection.close();
             
        } catch (SQLException e) {
            logger.info("CountriesController error: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    public CountriesBodyDB mergeCountries(List<Country> cnt, List<CountryDB> cntDB) {
        CountriesBodyDB countriesBody = new CountriesBodyDB();
        for(CountryDB countryDB : cntDB) {
            for(Country country : cnt) {
                if(countryDB.getIsoCode().toLowerCase().equals(country.getIsoCode().toLowerCase())) {
                    countriesBody.addCountry(countryDB);
                    break;
                }
            }
        }
        return countriesBody;
    }
    
    public CountryDB getCountryFromDB(String countryIsoCode) {
        CountryDB country = new CountryDB();
        Connection connection = DBConnectionManager.getConnection();
        try {
            String query = "select * from `site_transpay_commission` where `country_iso_code` = '" + countryIsoCode + "';";
            logger.info(query);
            
            Statement statement = connection.createStatement();
            statement.execute("set character set utf8");
            statement.execute("set names utf8");
            
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                country = createCountry(rs);
            }
        
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            logger.info("CountriesController error: " + e.getMessage());
            return null;
        }
        
        return country;
    }
    
    private CountryDB createCountry(ResultSet rs) throws SQLException {
        
        CountryDB country = new CountryDB();

        if(!rs.getString("country").equals("NULL")) {
            country.setName(rs.getString("country"));
        }
        if(!rs.getString("country_iso_code").equals("NULL")) {
            country.setIsoCode(rs.getString("country_iso_code"));
        }
        if(!rs.getString("payout_time").equals("NULL")) {
            country.setPayoutTime(rs.getString("payout_time"));
        }
        if(!rs.getString("payout_currency").equals("NULL")) {
            country.setPayoutCurrency(rs.getString("payout_currency"));
        }
        if(!rs.getString("fixed_fee_transp").equals("NULL")) {
            country.setFixedFeeTransp(new BigDecimal(rs.getString("fixed_fee_transp")));
        }
        if(!rs.getString("fixed_fee").equals("NULL")) {
            country.setFixedFee(new BigDecimal(rs.getString("fixed_fee")));
        }
        if(!rs.getString("perc_fee").equals("NULL")) {
            country.setPercFee(new BigDecimal(rs.getString("perc_fee")));
        }
        if(!rs.getString("min_summ").equals("NULL")) {
            country.setMinSum(new BigDecimal(rs.getString("min_summ")));
        }
        if(!rs.getString("max_summ").equals("NULL")) {
            country.setMaxSum(new BigDecimal(rs.getString("max_summ")));
        }
        if(country.getPayoutCurrency() != null) {
            if(country.getPayoutCurrency().equals("EUR")) {
                country.setFeeCurrency("EUR");
            } else {
                country.setFeeCurrency("USD");
            }
        }
        if(!rs.getString("switch").equals("NULL")) {
            country.setStatus(Integer.parseInt(rs.getString("switch")));
        }
        return country;
    }
    
    public CountryDB fixedFeeCorrection(CountryDB country) {
        if(country.getFixedFeeTransp()!=null) {
            country.setFixedFee(country.getFixedFee().add(country.getFixedFeeTransp()));
        } 
        return country;
    }
    
}
