package com.sgc.controller;

import com.sgc.data.MCDao;
import com.sgc.model.MC;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MCcontroller", urlPatterns = {"/MCcontroller"})
public class MCcontroller extends HttpServlet {
    MC mc =new MC();
MCDao mcDao=new MCDao();

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try{
                 
        mc.setMainClassificationId(request.getParameter("mcid"));
        mc.setMainClassificationName(request.getParameter("mcname"));
        
         MCDao.saveMC(mc);
         request.getRequestDispatcher("ViewMainController").forward(request, response);
         
        }catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //         mc.setMainClassificationId(request.getParameter("mcid"));
        mc.setMainClassificationName(request.getParameter("mcname"));
        request.getRequestDispatcher("/mainSearch.jsp").forward(request, response);
    }

}
