
package com.sgc.data;

import com.sgc.model.SC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SCDao {
    
    static Connection con = null;
    static Statement statement = null;
    static PreparedStatement pstmt = null;
     static DatabaseConnection dbConnection=new DatabaseConnection();
     
     public static void saveSC(SC sc){
       String sql = "insert into sub_class values('"+sc.getSubClassificationId()+"','"+sc.getSubClassificationName()+"','"+sc.getMainClassificationId()+"')";
        try {
            con=DatabaseConnection.getConnection();
            statement=con.createStatement();
            statement.executeUpdate(sql);
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SCDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SCDao.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
     public void deleteSub(String scid) throws ClassNotFoundException{
        try {
            con = DatabaseConnection.getConnection();
            statement=con.createStatement();
            
            String sql = "DELETE FROM sub_class WHERE S_C_ID='" + scid + "'";
            
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SCDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public List<SC> searchSub(String searchKey) throws SQLException, ClassNotFoundException{
       
        con = DatabaseConnection.getConnection();
        
        String sql = "SELECT * FROM sub_class s join main_class m on s.M_C_ID=m.M_C_ID WHERE S_C_name = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, searchKey);
        ResultSet rs = pstmt.executeQuery();
        
        List<SC> subList = new ArrayList<>();
        while(rs.next()){
         SC subClass = new SC();
         subClass.setSubClassificationId(rs.getString("S_C_ID"));
         subClass.setMainClassificationName(rs.getString("M_C_name"));
         subClass.setSubClassificationName(rs.getString("S_C_name"));
         subList.add(subClass);
        }
        con.close();
        return subList;                
    }
    
     public List<SC> viewSub() {
             
             List<SC> subList = new ArrayList<>();

        try {
             con = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM sub_class s join main_class m on s.M_C_ID=m.M_C_ID";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

           
            while (rs.next()) {
                SC subClass = new SC();
                subClass.setSubClassificationId(rs.getString("S_C_ID"));
                subClass.setSubClassificationName(rs.getString("S_C_name"));
                subClass.setMainClassificationId(rs.getString("M_C_ID"));
                subClass.setMainClassificationName(rs.getString("M_C_name"));
                subList.add(subClass);
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SCDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subList;
    }
     
       public List<SC> viewSub(String subId){
       
            List<SC> subList = new ArrayList<>();
        try {
            con = DatabaseConnection.getConnection();
            
            String sql = "SELECT * FROM sub_class WHERE S_C_ID='"+subId+"'";
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                SC subClass = new SC();
                subClass.setSubClassificationId(rs.getString("S_C_ID"));
                subClass.setSubClassificationName(rs.getString("S_C_name"));
                subClass.setMainClassificationId(rs.getString("M_C_ID"));
                subList.add(subClass);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MCDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MCDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            return subList;
    }
     
     public List S_C_name() throws ClassNotFoundException{
         List<String> sclassificationList=new ArrayList<>();
        try{    
        dbConnection=new DatabaseConnection();
        con =dbConnection.getConnection();
        
        String query="select S_C_name from sub_class";
        Statement stmt = con.createStatement();
       ResultSet rs= stmt.executeQuery(query);
       
            while (rs.next()) {
               sclassificationList.add(rs.getString("S_C_name"));
                System.out.println("test"+rs.getString("S_C_name"));
            }
            
        }
             
      catch(SQLException e)
       {
           System.out.println(e.toString());
       }
       
    return sclassificationList;
    }
    
     public ArrayList<SC> viewSubClassificationByMainClassficationId(String mainClassificationId){
         ArrayList<SC> subClassificationList = new ArrayList<>();
         
         String sql = "SELECT * FROM sub_class "
                 + "WHERE M_C_ID='" + mainClassificationId + "'";
         
         
         try{
            
         con =dbConnection.getConnection();
        
            statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next()){
                SC sc = new SC();
                sc.setSubClassificationId(rs.getString("S_C_ID"));
                sc.setSubClassificationName(rs.getString("S_C_name"));
                subClassificationList.add(sc);
            }
            
         } catch (SQLException ex) {
            Logger.getLogger(SCDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SCDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return subClassificationList;
     }
     
     public List<SC> viewSubByMainId(String mainId){
       
            List<SC> subList = new ArrayList<>();
        try {
            con = DatabaseConnection.getConnection();
            
            String sql = "SELECT * FROM sub_class WHERE M_C_ID=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, mainId);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                SC subClass = new SC();
                subClass.setSubClassificationId(rs.getString("S_C_ID"));
                subClass.setSubClassificationName(rs.getString("S_C_name"));
                subList.add(subClass);
            }
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SCDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SCDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            return subList;
    }
    
     public void updateSub(SC sc) throws ClassNotFoundException{
        try {
            con = DatabaseConnection.getConnection();
            statement=con.createStatement();
            String sql="update sub_class set S_C_ID='"+sc.getSubClassificationId()+"',S_C_name='"+sc.getSubClassificationName()+"',M_C_ID='"+sc.getMainClassificationId()+"' where S_C_ID='"+sc.getSubClassificationId()+"'";
            
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SCDao.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
