package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.connectivity.connectionclass;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class databasewrite {
    @FXML
    TextField supplier_name;
    @FXML
    TextField supplier_number;
    @FXML
    TextField supplier_Address;
    @FXML
    TextField supplier_addedby;
    @FXML
    DatePicker supplier_date;
    @FXML
    TextArea supplier_description;

    public void add_supplier() {

        try {
            System.out.println(supplier_number.getText());
            System.out.println(supplier_name.getText());
            System.out.println(supplier_number.getText());
            System.out.println(supplier_Address.getText());
            System.out.println(supplier_addedby.getText());
//            System.out.println(supplier_date.getText());
            System.out.println(supplier_description.getText());
//           Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagementsystem", "root", "");
            Statement st = connectionclass.getconnection().createStatement();
            supplier_number.getText();
            st.execute("insert into supplier values(supplier_name.getText(),Integersupplier_number.getText(),supplier_Address.getText(),supplier_addedby.getText(), supplier_date.getText(),supplier_description.getText())");
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void supplierclass(ActionEvent actionEvent) {

        try {

            System.out.println(supplier_name.getText());
            System.out.println(supplier_number.getText());

            System.out.println(supplier_number.getText());
            System.out.println(supplier_Address.getText());
            System.out.println(supplier_addedby.getText());
//            System.out.println(supplier_date.getText());
            System.out.println(supplier_description.getText());
            System.out.println(supplier_name.getText());
            LocalDate date=supplier_date.getValue();
//           Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagementsystem", "root", "");

            Statement st = connectionclass.getconnection().createStatement();
            int a= Integer.parseInt(supplier_number.getText());
            st.execute("insert into supplier values('"+supplier_name.getText()+"','"+a+"','"+supplier_Address.getText()+"','"+supplier_addedby.getText()+"','"+date+"','"+supplier_description.getText()+"')");
           // st.execute("insert into supplier values('gfgd',23456789,'gshjhhjhj','ashu',null,'bgf')");
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
