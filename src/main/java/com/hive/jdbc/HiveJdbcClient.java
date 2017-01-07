package com.hive.jdbc;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
 
public class HiveJdbcClient {
  private static String driverName = "org.apache.hive.jdbc.HiveDriver";
 
  /**
   * @param args
   * @throws SQLException
   */
  public static void main(String[] args) throws SQLException {
      try {
      Class.forName(driverName);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      System.exit(1);
    }
    //replace "hive" here with the name of the user the queries should run as
    Connection con = DriverManager.getConnection("jdbc:hive2://localhost:10000/nivt", "abhinandan", "eminent");
    Statement stmt = con.createStatement();
   
 
    // select * query
    String sql = "select * from titanic limit 10";
    System.out.println("Running: " + sql);
    ResultSet res = stmt.executeQuery(sql);
    res = stmt.executeQuery(sql);
    while (res.next()) {
      System.out.println(res.getString(1) + "\t" + res.getString(2));
    }
 
    // regular hive query
    String sql1 = "select count(1) from titanic" ;
    System.out.println("Running: " + sql1);
    ResultSet res1 = stmt.executeQuery(sql1);
    res = stmt.executeQuery(sql1);
    while (res1.next()) {
      System.out.println(res1.getString(1));
    }
  }
}



