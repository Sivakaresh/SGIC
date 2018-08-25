/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgc.controller;

import com.sgc.data.BookDao;
import com.sgc.data.MCDao;
import com.sgc.data.SCDao;
import com.sgc.model.Book;
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

/**
 *
 * @author Administrator
 */
@WebServlet(name = "EditBookController", urlPatterns = {"/EditBookController"})
public class EditBookController extends HttpServlet {

  
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

        String bookId = request.getParameter("bookId");
        String mainId = request.getParameter("mainId");
        String subId =request.getParameter("subId");
        
        BookDao bookDao = new BookDao();
        MCDao mcDao = new MCDao();
        SCDao subDao = new SCDao();
        
        List<Book> bookList = new ArrayList<>();
        List<MC> mainClassificationList = new ArrayList<>();
        List<SC> subClassificationList = new ArrayList<>();

        bookList = bookDao.ViewBookById(bookId);
        mainClassificationList = mcDao.viewMain();
        subClassificationList = subDao.viewSubByMainId(mainId);

        request.setAttribute("mainListAttribute", mainClassificationList);
        request.setAttribute("subListAttribute", subClassificationList);
        request.setAttribute("bookListAttribute", bookList);

        request.getRequestDispatcher("Editbook.jsp").forward(request, response);

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
