/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampleapp;

import java.util.Scanner;
import DB.DatabaseConnection;
import java.sql.*;

/**
 *
 * @author midha
 */
public class ExampleApp {

    /**
     * @param args the command line arguments
     */
    static Connection conn;
    static Statement st;
    static String sql;

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukan id : ");
        String id = sc.next();
        System.out.print("Masukan nama : ");
        String nama = sc.next();
        System.out.print("Masukan password : ");
        String password = sc.next();
        System.out.print("Masukan Gender : ");
        String gender = sc.next();
        System.out.print("Masukan Tanggal lahir : ");
        String dob = sc.next();
        System.out.print("Masukan phone number : ");
        String phone_number = sc.next();
        System.out.print("Masukan email : ");
        String email = sc.next();
        System.out.print("Masukan alamat : ");
        String alamat = sc.next();
        System.out.print("Masukan role : ");
        String role = sc.next();

        conn = new DatabaseConnection().setConnection();
        try {
            sql = "INSERT INTO tbl_user VALUES ('" + id + "', '" + nama + "', '" + password + "', '" + gender + "', '" + dob + "',"
                    + "'" + phone_number + "', '" + email + "', '" + alamat + "', '" + role + "');";
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        st = conn.createStatement();
        st.executeUpdate(sql);
    }

}
