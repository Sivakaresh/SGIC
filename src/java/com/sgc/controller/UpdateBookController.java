/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgc.controller;

import com.sgc.data.BookDao;
import com.sgc.model.Book;
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

/**
 *
 * @author Sivakaresh
 */
@WebServlet(name = "UpdateBookController", urlPatterns = {"/UpdateBookController"})
public class UpdateBookController extends HttpServlet {

    Book book =new Book();
  BookDao bookDao=new BookDao();
  
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
            book.setBookId(request.getParameter("bookId"));
            book.setTitles(request.getParameter("titles"));
            book.setAuthor(request.getParameter("author"));
            book.setMainclassification(request.getParameter("mainclassification"));
            book.setSubclassification(request.getParameter("subclassification"));
            book.setYop(request.getParameter("yop"));
            book.setLpy(request.getParameter("lpy"));
            book.setIsbn(request.getParameter("isbn"));
            book.setNop(request.getParameter("nop"));
            
            bookDao.updateBook(book);
            request.getRequestDispatcher("ViewBookController").forward(request, response);
         
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
