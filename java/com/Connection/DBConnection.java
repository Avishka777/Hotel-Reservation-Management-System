package com.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class DBConnection
{
    String url;
    String user;
    String pwd;
    
    public Connection getConnetion() {
        System.out.println("\n\n<<-- DBConnection class is running -->>\n\n");
        try {
            this.url = "jdbc:mysql://localhost:3306/hotel";
            this.user = "root";
            this.pwd = "";
            final Connection con = DriverManager.getConnection(this.url, this.user, this.pwd);
            System.out.println("Connection Created......!!!!!!");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver LOADED......!!!!!!");
            return con;
        }
        catch (SQLException | ClassNotFoundException ex2) {
                ex2.printStackTrace();
            return null;
        }
    }
}
