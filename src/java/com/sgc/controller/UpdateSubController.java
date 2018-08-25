
package com.sgc.controller;

import com.sgc.data.SCDao;
import com.sgc.model.SC;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UpdateSubController", urlPatterns = {"/UpdateSubController"})
public class UpdateSubController extends HttpServlet {
    
      SC sc =new SC();
  SCDao scDao=new SCDao();

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          try {
              //        processRequest(request, response);
              
              sc.setSubClassificationId(request.getParameter("scid"));
              sc.setSubClassificationName(request.getParameter("scname"));
              sc.setMainClassificationId(request.getParameter("mainclassification"));
              
              scDao.updateSub(sc);
              request.getRequestDispatcher("ViewSubController").forward(request, response);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(UpdateSubController.class.getName()).log(Level.SEVERE, null, ex);
          }
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
