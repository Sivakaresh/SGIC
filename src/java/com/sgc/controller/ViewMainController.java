
package com.sgc.controller;

import com.sgc.data.MCDao;
import com.sgc.model.MC;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ViewMainController", urlPatterns = {"/ViewMainController"})
public class ViewMainController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MCDao mcDao = new MCDao();

            List<MC> mainList;
            if (request.getAttribute("mainListAtt") != null) {
                mainList = (List<MC>) request.getAttribute("mainListAtt");
            } else {
                mainList = mcDao.viewMain();
            }
            request.setAttribute("mainListAttribute", mainList);
            request.getRequestDispatcher("mainClassification.jsp").forward(request, response);
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
