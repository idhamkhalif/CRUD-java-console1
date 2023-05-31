/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampleapp;
import DB.DatabaseConnection;
import java.sql.*;

/**
 *
 * @author midha
 */
public class showData {

    static Connection conn;
    static Statement st;
    static ResultSet rs;
    static String sql;
    

    public static void main(String[] args) throws SQLException {
        conn = new DatabaseConnection().setConnection();
        try {
            sql = "SELECT * FROM tbl_user";
        } catch (Exception e) {
            System.out.println("Error Coy " + e.getMessage());
        }
        st = conn.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println("Id : " + rs.getString(1) + "\n" + "Nama : " + rs.getString(2) + "\n"
                    + "Password : " + rs.getString(3) + "\n" + "Gender : "+rs.getString(4)
                    + "Tanggal lahir : " + rs.getDate(5) + "\n" + "Phone number : " +"Email : " + rs.getString(6) + "\n"
                    + "Addres : " + rs.getString(7) + "\n" + "Role : " + rs.getString(8));
            System.out.println("--------------------------------------------------------");
        }
    }

}
