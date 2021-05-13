package sample;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.connectivity.connectionclass;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public  class add_brand_from_client extends client {
    databasewrite d = new databasewrite();


    @FXML
    TextField supplier_name;
    @FXML


    TextField supplier_addedby;
    @FXML
    DatePicker supplier_date;
    @FXML
    TextArea supplier_description;

    @FXML


//    @Override
//    public void add(ActionEvent event) throws SQLException, ClassNotFoundException {
//        try {
//            System.out.println(supplier_name.getText());
//
//            System.out.println(supplier_addedby.getText());
////            System.out.println(supplier_date.getText());
//            System.out.println(supplier_description.getText());
//            System.out.println(supplier_name.getText());
//            LocalDate date = supplier_date.getValue();
////           Class.forName("com.mysql.cj.jdbc.Driver");
////            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagementsystem", "root", "");
//
//            Statement st = (Statement) connectionclass.getconnection().createStatement();
//            st.execute("insert into brand values('" + supplier_name.getText() + "','" + supplier_addedby.getText() + "','" + date + "','" + supplier_description.getText() + "')");
//            // st.execute("insert into supplier values('gfgd',23456789,'gshjhhjhj','ashu',null,'bgf')");
//            System.out.println("done");
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//
//        }
//
//
//    }

    @Override
    public void add(String str) throws SQLException, ClassNotFoundException {
        System.out.println("thise is the add brand");
        System.out.println(str);
        Statement st = connectionclass.getconnection().createStatement();

        st.execute("insert into ab values('"+str+"')");
    }
}


