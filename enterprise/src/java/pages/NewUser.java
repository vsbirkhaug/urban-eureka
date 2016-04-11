/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Jdbc;
import utils.RandomPasswordGen;

/**
 *
 * @author me-aydin
 */
public class NewUser extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
             
        
        String [] query = new String[4];
        query[0] = (String)request.getParameter("name");
        //query[1] = RandomPasswordGen.generateRandomPassword();
        query[1] = (String)request.getParameter("address");
        query[2] = (String)request.getParameter("dob");
        query[3] = (String)request.getParameter("registrationdate");
           
        
        Jdbc jdbc = (Jdbc)session.getAttribute("dbbean"); 
        if(jdbc == null) {                   
            jdbc = new Jdbc();    
            session.setAttribute("dbbean", jdbc);
        }
        Connection connection = (Connection)request.getServletContext().getAttribute("connection");
        jdbc.connect(connection);
        
        if (jdbc == null)
            request.getRequestDispatcher("/WEB-INF/conErr.jsp").forward(request, response);
        
        for(String q : query) {
            if(q.length()==0) {
                request.setAttribute("registrationState", "true");
                request.setAttribute("message", "Fields cannot be empty");
                request.getRequestDispatcher("index_user_login.jsp").forward(request, response);         
            }
        }
        
        if(query[0]==null) {
            request.setAttribute("registrationState", "true");
            request.setAttribute("message", "Name cannot be empty");
            request.getRequestDispatcher("index_user_login.jsp").forward(request, response);         
        } 
        else {
            String[] userDetails = jdbc.insertUser(query);
            if(userDetails != null) {
                request.setAttribute("username", userDetails[0]);
                request.setAttribute("password", userDetails[1]);
                request.getRequestDispatcher("/WEB-INF/userRegConf.jsp").forward(request, response);
            } else {
                request.setAttribute("registrationState", "true");
                request.setAttribute("message", "An error occured whilst creating user, please try register again.");
                request.getRequestDispatcher("index_user_login.jsp").forward(request, response);  
            }
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
