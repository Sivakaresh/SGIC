package com.sgc.controller;

import com.sgc.data.BookDao;
import com.sgc.data.MCDao;
import com.sgc.data.SCDao;
import com.sgc.model.Book;
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


@WebServlet(name = "BookController", urlPatterns = {"/BookController"})
public class BookController extends HttpServlet {
    
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
       
//    try {
//        MCDao mc1 = new MCDao();
//        SCDao sc1 = new SCDao();
//        
//        List x = null;   
//        x = mc1.M_C_name();
//   
//        List y = null; 
//        y = sc1.S_C_name();
//     
//        request.setAttribute("mainClassificationList", x);
//        request.setAttribute("subClassificationList", y);
//
//        request.getRequestDispatcher("book.jsp").forward(request, response);
//    } catch (ClassNotFoundException ex) {
//        Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
//    } catch (SQLException ex) {
//        Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
//    }

    }
   
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        book.setBookId(request.getParameter("bookId"));
        book.setTitles(request.getParameter("titles"));
        book.setAuthor(request.getParameter("author"));
        book.setMainclassification(request.getParameter("mainclassification"));
        book.setSubclassification(request.getParameter("subclassification"));
        book.setYop(request.getParameter("yop"));
        book.setLpy(request.getParameter("lpy"));
        book.setIsbn(request.getParameter("isbn"));
        book.setNop(request.getParameter("nop"));
       
        bookDao.saveBook(book);
        request.getRequestDispatcher("ViewBookController").forward(request, response);

    }

 

}
