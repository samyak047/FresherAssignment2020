package assignment4;

import java.sql.*;
import java.util.LinkedList;

public class Operation {
    Connection con;
    ResultSet rs;
    public Operation() throws RuntimeException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment4","root","password");
            Statement stmt=con.createStatement();
            rs=stmt.executeQuery("select * from ITEM_DETAILS");

        }catch(Exception e){
            System.out.println(e);
            throw new RuntimeException();
        }

    }
    public Item getNextItemFromDB() throws RuntimeException{
        try{
            if(rs.next()){
                Item item = new Item(rs.getString(2), rs.getString(5), rs.getFloat(4), rs.getInt(3));
                return item;
            }
            else{
                con.close();
                throw new RuntimeException("All records fetched");
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
