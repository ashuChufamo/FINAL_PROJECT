package sample.connectivity;


import java.sql.Connection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connectionclass {
    public static Connection getconnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagementsystem", "root", "");

            return con;
    }
    public static void main(String[] args) {
        //new connectionclass();
        try {
//           Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagementsystem", "root", "");
            Statement st = connectionclass.getconnection().createStatement();
            st.execute("select * from user where uname='ashu'");
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        }

    public static void con(){
        new connectionclass();
        try {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagementsystem","root","");
            Statement st = con.createStatement();
            //st.execute("insert into user values('gfgd','dfd','ngf','gfd','bgf')");
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
