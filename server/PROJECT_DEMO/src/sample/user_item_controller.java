package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.ArrayList;

public class user_item_controller {
    @FXML
    TextField Quantity;
    @FXML
    ComboBox<String> brand;
    @FXML
    ComboBox<String> catagory;
    @FXML
    ComboBox<String> item;
    @FXML
    DatePicker date;
    @FXML
    public void load_info(ActionEvent event) {

    }

    public void request_for_home_item(ActionEvent event) {

    }

    public void request_for_home_item(javafx.event.ActionEvent event) {
        try {
            Socket sock = null;
            sock = new Socket("localhost", 121);

            ObjectOutputStream data = null;
            data = new ObjectOutputStream(sock.getOutputStream());
            ArrayList<String> list = new ArrayList<>();
            list.add("u1");

            //list.add(descriptionn.getText());


            System.out.println(Quantity.getText());

            System.out.println(brand.getSelectionModel().getSelectedItem());
            System.out.println(catagory.getSelectionModel().getSelectedItem());

//
            System.out.println(date.getValue());


            LocalDate Date = date.getValue();
            list.add(item.getSelectionModel().getSelectedItem());
            list.add("ashu");
            list.add(Quantity.getText());
            list.add(catagory.getSelectionModel().getSelectedItem());
            //list.add(catagory.getSelectionModel().getSelectedItem());
            list.add(brand.getSelectionModel().getSelectedItem());
            list.add(date.getValue().toString());


            data.writeObject(list);
            data.flush();
            data.close();

            System.out.println("done");


            Quantity.clear();


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnupdate(MouseEvent mouseEvent) {
    }
}
