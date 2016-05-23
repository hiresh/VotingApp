/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hiresh.database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class VoteDAO {
 static final  String DB_URI="jdbc:mysql://localhost:3306/votingApp";
 static final String DB_USERNAME="root";
    
public void submitVote(String vote){
     Connection conn=null;
     try{
     Class.forName("com.mysql.jdbc.Driver");
     conn=DriverManager.getConnection(DB_URI,DB_USERNAME,DB_USERNAME);
     PreparedStatement ps=null;
     double updatedData=0;
     updatedData=getData(vote)+1;
     String query="UPDATE votes SET "+vote+" = ?";
     ps=conn.prepareStatement(query);
     ps.setDouble(1,updatedData);
     
     ps.execute();
     conn.close();
     }
     catch(SQLException se){
         se.printStackTrace();
     }
     catch(Exception e){
         e.printStackTrace();
     }
}
public double getData(String v){
    double data=0;
    Connection conn=null;
    ResultSet rs=null;
    try{
      Class.forName("com.mysql.jdbc.Driver");
     conn=DriverManager.getConnection(DB_URI,DB_USERNAME,DB_USERNAME);
     PreparedStatement ps=null;
     String q="SELECT "+v+" FROM Votes";
     ps=conn.prepareStatement(q);
     rs=ps.executeQuery();
     while(rs.next()){
         data=rs.getDouble(v);
     }
    }
    catch(SQLException se){
         se.printStackTrace();
     }
     catch(Exception e){
         e.printStackTrace();
     }
    return data;
}
    public List<Double> getDataForChart(){
        List<Double> list=new ArrayList<Double>();
        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        try{
          Class.forName("com.mysql.jdbc.Driver");
          conn=DriverManager.getConnection(DB_URI,DB_USERNAME,DB_USERNAME);
          String s="SELECT Strawberry,Raspberry,Blueberry,Lemon FROM votes";
          ps=conn.prepareStatement(s);
          rs=ps.executeQuery();
          while(rs.next()){
              list.add(rs.getDouble("Strawberry"));
              list.add(rs.getDouble("Raspberry"));
              list.add(rs.getDouble("Blueberry"));
              list.add(rs.getDouble("Lemon"));
          }
        }
        catch(SQLException se){
            se.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
