import java.sql.*;

public class Conn {
    public Connection c;
    public Statement s;

    public Conn() {
        try {
            // 1. Driver loading
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // 2. Connection string (Dhyan se dekhiye HotelManagementtDB likha hai)
            String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelManagementtDB;user=sa;password=admin;encrypt=false;trustServerCertificate=true;";
            c = DriverManager.getConnection(url);

            // 3. Statement initialization
            s = c.createStatement();
            
            // Ye line confirm karegi ki connection ho gaya
            System.out.println("Connection Successful! Statement ready. ✅");

        } catch (Exception e) {
            // Agar yahan error aaya toh popup batayega kyun aaya
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }
    }
}