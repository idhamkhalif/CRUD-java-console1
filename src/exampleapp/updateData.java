/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampleapp;

/**
 *
 * @author midha
 */
import DB.DatabaseConnection;
import static exampleapp.deleteData.conn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class updateData {

    static Connection conn;
    static Statement st;
    static String sql;
    static ResultSet rs;

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

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
                    + "Password : " + rs.getString(3) + "\n" + "Gender : " + rs.getString(4)
                    + "Tanggal lahir : " + rs.getDate(5) + "\n" + "Phone number : " + "Email : " + rs.getString(6) + "\n"
                    + "Addres : " + rs.getString(7) + "\n" + "Role : " + rs.getString(8));
            System.out.println("--------------------------------------------------------");
        }
        
        System.out.print("Masukan id yang akan diedit : ");
        int id = sc.nextInt();
        System.out.print("Masukan phone number :");
        String phone_number = sc.next();

        conn = new DatabaseConnection().setConnection();
        try {
            sql = "UPDATE TABLE tbl_user SET phone_number = "+phone_number
                    + " WHERE id_user = '"+id+";";
            System.out.println("Data berhasil diedit!");
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        st = conn.createStatement();
        st.executeUpdate(sql);
    }
}
