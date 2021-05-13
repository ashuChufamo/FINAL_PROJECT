package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;
import sample.connectivity.connectionclass;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login_class {
    String roll;

    @FXML
    TextField U_N;
    @FXML
    TextField P;
    @FXML
    Label label;
    String username;
    String Password;
    ActionEvent event;
    Controller c=new Controller();
    loginClient l;


    Connection conn;

    public login_class() throws SQLException, ClassNotFoundException {
        conn= connectionclass.getconnection();
    }
    @FXML
    public String  getroll() {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String roll=null;
        try {

//            System.out.println(supplier_name.getText());
//            System.out.println(supplier_number.getText());
            String query = "select * from user where user_name=? and password=?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, U_N.getText());
            preparedStatement.setString(2, P.getText());
            resultSet = preparedStatement.executeQuery();

            roll = resultSet.getString("roll");


        } catch (SQLException ex) {
            //  Logger.getLogger(LoginSecurity.class.getName()).log(level.SEVERE, null, ex);
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (Exception ex) {

            }
        }
        return  roll;
    }
    @FXML
    public void login() throws IOException, SQLException, ClassNotFoundException {
        login_class L=new login_class();
        roll=L.getroll();
        if(roll== null){
            System.out.println("Password Not Match");
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Password Not Match");
            alert.setHeaderText("Error : Name or Pass Not matched");
            alert.setContentText("User Name or Password not matched \ntry Again");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
            label.setText("incorrec");
        }else{
            switch (roll) {
                case "storekeeper":
                    //c.changescene_store_keeper_home();
                    l = new StoreKeeperController();
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

            l.login();}



    }
    public void login_button_clicked() throws SQLException, IOException, ClassNotFoundException {
        login_class L=new login_class();
        L.getroll();
        L.login();


    }



}









