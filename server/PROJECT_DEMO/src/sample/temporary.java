package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.connectivity.connectionclass;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class temporary {
    ActionEvent event;
    @FXML
    TextField u_n;
    @FXML
    TextField p;
    @FXML
    Controller c=new Controller();
    loginClient l;
    Connection   conn=null;
    public temporary() throws SQLException, ClassNotFoundException {
        conn=connectionclass.getconnection();


    }
    public  void getroll() throws IOException {
        Connection   conn=null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String roll=null;
        try {

//            System.out.println(supplier_name.getText());
//            System.out.println(supplier_number.getText());
            System.out.println("HEY");
            String query = "select * from user where uname=? and password=?";
            System.out.println("HEY1");
              conn= connectionclass.getconnection();
            System.out.println("HEY2");
            preparedStatement = conn.prepareStatement(query);
            System.out.println("HEY3");
            String u="fasika";
            String P="0000";
            preparedStatement.setString(1, u);
            System.out.println(u_n.getText());
            System.out.println("HEY4");
            preparedStatement.setString(2, P);
            System.out.println(p.getText());
            System.out.println("HEY5");
            resultSet = preparedStatement.executeQuery();
            System.out.println("HEY6");
            System.out.println(resultSet.getString(0));
            roll = resultSet.getString("roll");
            System.out.println("HEY7");
            if(resultSet.next()){System.out.println("asmndbf");}

        } catch (SQLException ex) {
            //  Logger.getLogger(LoginSecurity.class.getName()).log(level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (Exception ex) {

            }
        }



       // System.out.println(roll);
        roll="storekeeper";
        if(roll== null){
            System.out.println("Password Not Match");
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Password Not Match");
            alert.setHeaderText("Error : Name or Pass Not matched");
            alert.setContentText("User Name or Password not matched \ntry Again");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
//            Labeled label;
//            label.setText("incorrec");
        }else{
            switch (roll) {
                case "storekeeper":
                    c.loginbbuttonclicked();




                    break;
                case "admin":
                    c.changescenetoadmin();
                    l = new Admincontroller();
                    break;
                case "user":
                    c.changescenetouser();
                    l = new UserController();
                    break;
            }

            }



    }
    public void login_button_clicked() throws SQLException, IOException, ClassNotFoundException {
        login_class L=new login_class();
        L.getroll();
        L.login();


    }
}