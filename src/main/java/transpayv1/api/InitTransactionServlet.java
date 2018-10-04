/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.api;

import transpayv1.data.ResponseObject;
import transpayv1.service.MessageBundlesController;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * Main transpay API servlet which processes the input requests
 * @author jk
 */

@WebServlet(name = "InitTransactionServlet", urlPatterns = {"/api"})
public class InitTransactionServlet extends HttpServlet {

    private final RequestDispatcher requestDispatcher = new RequestDispatcher();
    private Logger logger = Logger.getLogger(getClass().getName());
    private MessageBundlesController bundles = new MessageBundlesController();
  
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("utf-8");
        
        String responseString = null;
        String params = "";
        
        InputStream in = request.getInputStream();
                
        int data = in.read();
        char content;
        while(data != -1) {
            content = (char) data;
            params += content;
            data = in.read();
        }
        
        System.out.println(params);
        
        try {
            System.out.println("Point 1");
            responseString = requestDispatcher.generateResponse(params);
            
        
            System.out.println("Point 2");
            BufferedOutputStream bs = null;

            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");

            logger.info("Response: " + responseString);
            bs = new BufferedOutputStream(response.getOutputStream());
            bs.write(responseString.getBytes());

            bs.flush();
            bs.close();
            in.close();
        
        } catch(Exception e) {
            ResponseObject ro = new ResponseObject();
            logger.info(e);
//            responseString = ro.getJson(-2, bundles.getTranslation("TRANSPAY_INTERNAL_ERROR", "en"),e.getMessage());
            responseString = ro.getJson(-2, "error", e.getMessage());
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
