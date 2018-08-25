
package com.sgc.controller;

import com.sgc.data.MCDao;
import com.sgc.data.SCDao;
import com.sgc.model.MC;
import com.sgc.model.SC;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EditSubController", urlPatterns = {"/EditSubController"})
public class EditSubController extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    
        String subId = request.getParameter("subId");

        SCDao scDao = new SCDao();
        MCDao mcDao = new MCDao();
   
        List<SC> subClassificationList = new ArrayList<>();
        List<MC> mainClassificationList = new ArrayList<>();
        
        subClassificationList = scDao.viewSub(subId);
        mainClassificationList = mcDao.viewMain();

        request.setAttribute("subListAttribute", subClassificationList);
        request.setAttribute("mainListAttribute", mainClassificationList);
        
        request.getRequestDispatcher("EditSC.jsp").forward(request, response);
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
