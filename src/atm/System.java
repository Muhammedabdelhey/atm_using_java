package atm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

public class System {

    /**
     * @return the New_id
     */
    private static int user_id;
    private static int password;
    private static String user_name;
    private static double balance;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public static double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void login(int id, int password) throws SQLException {
        boolean flage = false;
        DataBase d = new DataBase();
        String sql = "select id,password from Users where id=" + id;
        ResultSet result = d.st.executeQuery(sql);
        while (result.next()) {
            if (result.getString("password").equals(String.valueOf(password))) {
                user_oprations view = new user_oprations();
                flage = true;
                view.setVisible(true);
                view.setLocation(300, 100);

            }
        }

        if (flage == false) {
            JOptionPane.showMessageDialog(null, "Card Number or Password not Correct");
        }

        d.Close();
    }

    public void Sign_Up() throws SQLException {
        DataBase d = new DataBase();
        String sql = "insert into Users values('" + getUser_name() + "'," + getPassword() + "," + getBalance() + ")";
        d.st.executeUpdate(sql);
        d.Close();
        VisaCard view = new VisaCard();
        view.setVisible(true);
        view.setLocation(520, 220);

    }

    public void getVise() throws SQLException {
        DataBase d = new DataBase();
        String sql = "SELECT TOP 1 * FROM Users ORDER BY id DESC ";
        ResultSet result = d.st.executeQuery(sql);
        while (result.next()) {
            setUser_id(Integer.parseInt(result.getString("id")));
            setUser_name(result.getString("name"));
            setPassword(Integer.parseInt(result.getString("password")));
        }
        d.Close();
    }

    public void withdraw(double amount, int id) throws SQLException {

        DataBase d = new DataBase();
        String sql_balance = "select balance from Users where id =" + id;
        ResultSet result = d.st.executeQuery(sql_balance);
        while (result.next()) {
            double current_balance = Double.parseDouble(result.getString("balance"));
            if (current_balance - amount != 0) {
                this.balance = current_balance - amount;
                String sql = "update Users set balance =" + getBalance()
                        + "where id = ? ";
                PreparedStatement pst = d.conn.prepareStatement(sql);
                pst.setString(1, id + "");
                pst.executeUpdate();
            }
        }
        d.Close();

    }

    public void deposit(double amount, int id) throws SQLException {
        DataBase d = new DataBase();
        String sql_balance = "select balance from Users where id =" + id;
        ResultSet result = d.st.executeQuery(sql_balance);
        while (result.next()) {
            double current_balance = Double.parseDouble(result.getString("balance"));
            this.balance = current_balance + amount;
            String sql = "update Users set balance =" + getBalance()
                    + "where id =?";
            PreparedStatement pst = d.conn.prepareStatement(sql);
            pst.setString(1, id + "");
            pst.executeUpdate();

        }
        d.Close();
    }

    public static void save_transaction(int id, String type, double amount,double Balance) throws SQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String time = String.valueOf(formatter.format(date));
        double Balance_befor;
        double Balance_after;
        Balance_after = Balance;
        if (type.equals("Transfer") || type.equals("Withdraw")) {
            Balance_befor = Balance_after + amount;
        } else {
            Balance_befor = Balance_after - amount;
        }
        DataBase d=new DataBase();
        String sql = "insert into Transactions_history values(" + id + ",'" + type + "','" + time + "'," + Balance_befor + "," + Balance_after + ")";
        d.st.executeUpdate(sql);
        d.Close();
    }

}
