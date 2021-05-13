package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class login_controller implements  collection_2 {
    @FXML
    TextField U_N;
    @FXML
    TextField p;
    @FXML
    public  void login(ActionEvent event) throws IOException, ClassNotFoundException {

        u_name.clear();
        ArrayList<String> message = new ArrayList<>();
        Socket sock = null;
        sock = new Socket("localhost", 434);
        ObjectOutputStream data = null;
        data = new ObjectOutputStream(sock.getOutputStream());
        ArrayList<String> list = new ArrayList<>();
        list.add("log");
        list.add(U_N.getText());
        list.add(p.getText());
        data.writeObject(list);
        ObjectInputStream input = new ObjectInputStream(sock.getInputStream());
        System.out.println("thise is the object input method");
        System.out.println(sock.getInputStream());
        Object object = input.readObject();
        System.out.println("the obeject have been read");
        System.out.println(object);
        message = (ArrayList<String>) object;
        for (int i = 0; i < message.size(); i++) {
            System.out.println(message.get(i));
        }
        addroll(message);
        String value=roll.get(0);
        roll.clear();
        if(value.equals("store_keeper")){
            u_name.add(U_N.getText());
            System.out.println("you have clicked me");
            Parent inner = FXMLLoader.load(getClass().getResource("Store_keeper home.fxml"));
            Scene innerscene = new Scene(inner);

            Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
            innerStage.setScene(innerscene);
            innerStage.setResizable(true);
            innerStage.show();



        }
        else if(value.equals("NO")){
            u_name.add(U_N.getText());
            System.out.println("Password Not Match");
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Password Not Match");
            alert.setHeaderText("Error : Name or Pass Not matched");
            alert.setContentText("User Name or Password not matched \ntry Again");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
            //label.setText("incorrec");


        }

        else{

            System.out.println("you have clicked me");
            Parent inner = FXMLLoader.load(getClass().getResource("user.fxml"));


            Scene innerscene = new Scene(inner);

            Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
            innerStage.setScene(innerscene);
            innerStage.setResizable(true);
            innerStage.show();

        }





    }
    public void addroll(ArrayList listt) throws IOException {

        roll.add((String) listt.get(0));
        }



    }

