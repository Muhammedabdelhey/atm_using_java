package atm;

import java.sql.*;

public class DataBase {

    Connection conn;
    Statement st;

    public DataBase() throws SQLException {
        String ConnectionUrl = "jdbc:sqlserver://localhost\\MUHAMMED\\SQLEXPRESS:1433;databaseName=ATM" + ";username=sa" + ";password=12345";
        conn = DriverManager.getConnection(ConnectionUrl);
        st = conn.createStatement();
    }

    public void Close() throws SQLException {
        st.close();
        conn.close();
    }
}
