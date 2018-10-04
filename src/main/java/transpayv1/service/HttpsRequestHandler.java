/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.service;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;

/**
 *
 * @author Work
 */
public class HttpsRequestHandler {
    
    CloseableHttpClient httpclient;
    private String authorization = "Credentials PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxBdXRoZW50aWNhdGlvbj4NCiAgPElkPjIyZGEzY2MyLWViYzMtNDRkZS05Y2MzLTc1NjUyMjU4NjcyMzwvSWQ+DQogIDxVc2VyTmFtZT5SeEhsNDZuUHJpNFBPalhjWTZsK3VQZEYxWGJIamsrcVFYNDJzWjROSUZSUHJEeDlRMlBCQ3BNYnp4TEJNd0ZFQkRqTmM0S25QREpqSDRWMVR0SFd3U3B6dGMxZkZnWi9ndkt5SFhFT2M4T2JhbVkvZStJaE8zRGdieFo4UzVCeHdlOW40NWJSWU1DVk8zQjF4V29VUHNhUVZCWTlRNlRUOXlDUHc2RExiTzQ9PC9Vc2VyTmFtZT4NCiAgPFBhc3N3b3JkPm5rM2xlREh2aUdFc0JFVlFucGZ2V3hZUVA5MnVNWXA3SEU3eDJrbnFSTWxwdVhBOVE1NjlVOWJYZm1hclM4YnJia2lHcko3NnpQU1hqQmJwazc0ekYzK3BCaCtvNU9nQU05bzBaVDdmcHZhL2xZTjFaK20rWWh4MXVadnZBMmJkdXdtYmdDQUJBczZ2WW15YUx2UDNIdUkyNzlXVm5KaTNSZC8zMTJuKzQ4TT08L1Bhc3N3b3JkPg0KICA8QnJhbmNoSWQ+VnJSZW1hZ0hSeStFb0NSaUQ2VjQ5azVKd3BocDBvSlhMbXZGQ1F0ZkpsbHRwbWJQaGU0bmpXbmRybHluNDJwbXU3VXhQLzFNYnE4QzZCWThzV3ErV0tLOHJWOWpSaWV2REwwQ2R4ZTl2UkV5VFVacVJXY2haOFNCRHBzS2g5Nzd4TDdsZjB2Tm9ndDNhb2hFbm1SUlhrL2p2cWROQ2lYVU0wRUo2ZmZDMWp3PTwvQnJhbmNoSWQ+DQo8L0F1dGhlbnRpY2F0aW9uPg==";
    private Logger logger = Logger.getLogger(getClass().getName());
    
    public String get(String address) {
        
        String response = "";
        
        logger.info("get: " + address);
        
        try {
            URL obj = new URL(address);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", authorization);

            con.setDoOutput(true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                    response += inputLine;
            }
            in.close();
            
            logger.info("response:  " + response);
            
        } catch (IOException e) {
            //TODO: отловить ошибки типа "Bad request - 400"
            System.out.println(e);
            logger.error("HttpsRequestHandler error: " + e.getMessage());
            return null;
        }  
        return response;
    }
    
    public String post(String address, String request) {
        String response = "";
        logger.info("post: " + address);
        try {
            
            URL obj = new URL(address);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", authorization);
            con.setRequestProperty("Content-Type", "application/json");
            
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(request);
		wr.flush();
		wr.close();
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                    String line;
                    while ((line = in.readLine()) != null) {
                            response += line;
                    }
                in.close();
            } catch (IOException e) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getErrorStream()));
                String line;
                while ((line = in.readLine()) != null) {
                        response += line;
                }
                if(response.equals("")) {
                    return null;
                }
                return response;
            }
            
        } catch (IOException e) {
            logger.error("HttpsRequestHandler error: " + e.getMessage());
            
            return null;
        }
        return response;
    }
    
    public String put(String address, String request) {
        String response = null;
        
        try {
            
            URL obj = new URL(address);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            con.setRequestMethod("PUT");
            con.setRequestProperty("Authorization", authorization);
            con.setRequestProperty("Content-Type", "application/json");
            
            con.setDoOutput(true);
            
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(request);
		wr.flush();
		wr.close();
                
            Integer responseCode = con.getResponseCode();
            
            if(responseCode != 204)
                response = new String();
            else 
                throw new IOException("Code: " + responseCode);
          
        } catch (IOException e) {
            logger.error("HttpsRequestHandler error: " + e.getMessage());
            return null;
        }
        return response;
    }
}
