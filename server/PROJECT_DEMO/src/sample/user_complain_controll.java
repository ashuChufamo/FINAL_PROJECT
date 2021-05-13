package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.ArrayList;

public class user_complain_controll {

    @FXML
    DatePicker datePicker;
    @FXML
    TextArea Complain_user;
    public void complain(ActionEvent event){

    }

    public void complain(javafx.event.ActionEvent event) {
        try {
            Socket sock = null;
            sock = new Socket("localhost", 121);

            ObjectOutputStream data = null;
            data = new ObjectOutputStream(sock.getOutputStream());
            ArrayList<String> list = new ArrayList<>();
            list.add("comp");

            //list.add(descriptionn.getText());


            System.out.println(Complain_user.getText());


            String user_name="yaredo";
            LocalDate Date = datePicker.getValue();

            list.add("yaredo");
            list.add(Complain_user.getText());

            list.add(datePicker.getValue().toString());


            data.writeObject(list);
            data.flush();
            data.close();

            System.out.println("done");




        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

