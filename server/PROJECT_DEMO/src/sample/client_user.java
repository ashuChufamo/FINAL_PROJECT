package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.connectivity.connectionclass;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class client_user implements Initializable {
    @FXML
    TextField item_name;
    @FXML
    ComboBox category;
    @FXML
    ComboBox brand;
    @FXML
    DatePicker date;
    @FXML
    ComboBox Item_name;
    @FXML
    TextField quantity;
    private ObservableList<String> list = FXCollections.observableArrayList();
    @FXML
    private Label label;

    @FXML
    private ComboBox<String> box;

    public void request_for_item(ActionEvent event) {
        String in = item_name.getText();
        String un = "ashu";//thise should be the return value from the login
        String q = quantity.getText();
        String c = category.getPromptText();
        String b = brand.getPromptText();
        LocalDate d = date.getValue();

        try {
            System.out.println(item_name.getText());
            System.out.println(category.getPromptText());
            System.out.println(brand.getPromptText());
            System.out.println(date.getValue());
            System.out.println(quantity.getText());
//            System.out.println(supplier_date.getText());

//           Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagementsystem", "root", "");

            Statement st = connectionclass.getconnection().createStatement();
            //int a= Integer.parseInt(supplier_number.getText());
            st.execute("insert into requested_items values('" + in + "','" + un + "','" + q + "','" + c + "','" + b + "','" + d + "')");
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

    public void request_for_home_item(ActionEvent event) {


    }


    public void complain(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("addbrand.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }


    public void takeitem(ActionEvent event) {
    }

    public void logout(ActionEvent event) {
    }


    public void initialize(URL location, ResourceBundle resources) {
        //box.setItems(list);
        box.setItems(list);
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //Statement st = (Statement) connectionclass.getconnection().createStatement();
            PreparedStatement rd = connectionclass.getconnection().prepareStatement("select catagory_name from catagory");
            ResultSet rs = rd.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("catagory_name"));
                //System.out.println(rs.getString("name"));
            }
            //box.setItems(list);
            rd.close();
            rs.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));


        }
    }
}

