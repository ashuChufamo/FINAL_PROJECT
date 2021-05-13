package sample.databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class
Connections {
    public static void main(String [] args)
    {


        try {
        // TODO code application logic here
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager
                .getConnection("jdbc:mysql://localhost:3306/storemanagementsystem","-uroot-p","");
        Statement statement= connection.createStatement();


         statement.execute("insert into user values('solell','gechp','123','123','student')");
        statement.execute("insert into brand values('sumsung',null,'tebikew','techinology campany')");
        statement.execute(("insert into brand values('huai',,'tebikew','techinology campany')"));
         statement.execute("insert into brand values('apple',null,'tebikew','techinology campany')");



    } catch (Exception ex) {

        System.err.println(ex.getMessage());

    }
    }

}
