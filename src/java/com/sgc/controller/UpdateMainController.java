/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgc.controller;

import com.sgc.data.MCDao;
import com.sgc.model.MC;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.kohsuke.rngom.digested.Main;

/**
 *
 * @author Sivakaresh
 */
@WebServlet(name = "UpdateMainController", urlPatterns = {"/UpdateMainController"})
public class UpdateMainController extends HttpServlet {

    MC mc =new MC();
  MCDao mcDao=new MCDao();
  
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
           
            String mcid = request.getParameter("mcid");

            mc.setMainClassificationId(request.getParameter("mcid"));
            mc.setMainClassificationName(request.getParameter("mcname"));
            
            mcDao.updateMain(mc);
            request.getRequestDispatcher("ViewMainController").forward(request, response);
      
    }

  
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
