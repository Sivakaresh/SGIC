package com.sgc.data;


import com.sgc.model.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookDao {
    Connection con = null;
    Statement stmt= null;
    
    public void saveBook(Book book){
        
        try {
            con = DatabaseConnection.getConnection();
            Statement statement=con.createStatement();
            statement.executeUpdate("insert into books_details values('"+book.getBookId()+"','"+book.getTitles()+"','"+book.getAuthor()+"','"+book.getMainclassification()+"','"+book.getSubclassification()+"','"+book.getYop()+"','"+book.getLpy()+"','"+book.getIsbn()+"','"+book.getNop()+"');");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateBook(Book book){
        try {
            con = DatabaseConnection.getConnection();
            Statement statement=con.createStatement();
            String sql="update books_details set bookid='"+book.getBookId()+"',titles='"+book.getTitles()+"',author='"+book.getAuthor()+"',mainclassification='"+book.getMainclassification()+"',subclassification='"+book.getSubclassification()+"',yearofpuclishing='"+book.getYop()+"',lastprintedyear='"+book.getLpy()+"',isbnno='"+book.getIsbn()+"',noofpages='"+book.getNop()+"' where bookid='"+book.getBookId()+"'";
            
             statement.executeUpdate(sql);
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList viewBook(){
        ArrayList<Book> bookList = new ArrayList<>();
        
        //String sql = "SELECT * FROM books_details";
        String sql = " SELECT * FROM books_details bd JOIN main_class mc ON mc.M_C_ID=bd.mainclassification JOIN sub_class sc ON sc.S_C_ID=bd.subclassification";
        
        try{
            con = DatabaseConnection.getConnection();
             stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Book book = new Book();
                book.setBookId(rs.getString("bookid"));
                book.setTitles(rs.getString("titles"));
                book.setAuthor(rs.getString("author"));
                book.setMainId(rs.getString("mainclassification"));
                book.setSubId(rs.getString("subclassification"));
                book.setMainclassification(rs.getString("M_C_name"));
                book.setSubclassification(rs.getString("S_C_name"));
                book.setYop(rs.getString("yearofpuclishing"));
                book.setLpy(rs.getString("lastprintedyear"));
                book.setIsbn(rs.getString("isbnno"));       
                book.setNop(rs.getString("noofpages"));
                
                bookList.add(book);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookList;
    }
    
    public ArrayList searchBook(Book book){
        
        ArrayList<Book> listBook = new ArrayList<>();
//        String sql = "SELECT * FROM books_details bd "
//                + "JOIN main_class mc ON mc.M_C_ID=bd.mainclassification "
//                + "JOIN sub_class sc ON sc.S_C_ID=bd.subclassification"
//                + "WHERE bookid='" + book.getBookId() + "' OR titles='" + book.getTitles() + "' OR author='" + book.getAuthor() + "'";
        String sql = " SELECT * FROM books_details bd JOIN main_class mc ON mc.M_C_ID=bd.mainclassification JOIN sub_class sc ON sc.S_C_ID=bd.subclassification WHERE bookid='" + book.getBookId() + "' OR titles='" + book.getTitles() + "' OR author='" + book.getAuthor() + "'";
        
        try{
            con = DatabaseConnection.getConnection();
            stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
//                book = new Book();
//                book.setBookId(rs.getString("bookId"));
//                book.setTitles(rs.getString("titles"));
//                book.setAuthor(rs.getString("author"));
//                book.setMainclassification(rs.getString("mainclassification"));
//                book.setSubclassification(rs.getString("subclassification"));
//                book.setYop(rs.getString("yop"));
//                book.setLpy(rs.getString("lpy"));
//                book.setIsbn(rs.getString("isbn"));
//                book.setNop(rs.getString("nop"));
//                
//                listBook.add(book);
                book = new Book();
                book.setBookId(rs.getString("bookid"));
                book.setTitles(rs.getString("titles"));
                book.setAuthor(rs.getString("author"));
                book.setMainId(rs.getString("mainclassification"));
                book.setSubId(rs.getString("subclassification"));
                book.setMainclassification(rs.getString("M_C_name"));
                book.setSubclassification(rs.getString("S_C_name"));             
                book.setYop(rs.getString("yearofpuclishing"));
                book.setLpy(rs.getString("lastprintedyear"));
                book.setIsbn(rs.getString("isbnno"));
                book.setNop(rs.getString("noofpages"));
                
                listBook.add(book);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBook;
    }
    
    public ArrayList ViewBookById(String bookid){
        Book book = new Book();
        Statement stmt = null;
        ArrayList<Book> listBook = new ArrayList<>();
        String sql = " SELECT * FROM books_details bd "
                + "JOIN main_class mc ON mc.M_C_ID=bd.mainclassification "
                + "JOIN sub_class sc ON sc.S_C_ID=bd.subclassification WHERE bookid='" + bookid + "'";
//        String sql = "SELECT * FROM books_details WHERE bookid='" + bookid + "'";
        
        try{
            con = DatabaseConnection.getConnection();
            stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                book = new Book();
                book.setBookId(rs.getString("bookId"));
                book.setTitles(rs.getString("titles"));
                book.setAuthor(rs.getString("author"));
                book.setMainId(rs.getString("mainclassification"));
                book.setSubId(rs.getString("subclassification"));
                book.setMainclassification(rs.getString("M_C_name"));
                book.setSubclassification(rs.getString("S_C_name"));
                book.setYop(rs.getString("yearofpuclishing"));
                book.setLpy(rs.getString("lastprintedyear"));
                book.setIsbn(rs.getString("isbnno"));
                book.setNop(rs.getString("noofpages"));
                
                listBook.add(book);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBook;
    }
    
    
    public void deleteBook(String bookid){
        try {
            con = DatabaseConnection.getConnection();
            Statement statement=con.createStatement();
            
            String sql = "DELETE FROM books_details WHERE bookid='" + bookid + "'";
            
            statement.executeUpdate(sql);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}


