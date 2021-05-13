package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.connectivity.connectionclass;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class taken_item_control {
    @FXML
    private TableView<taken_item_user> table;

    @FXML
    private TableColumn<taken_item_user,String> status;
    @FXML
    private TableColumn<taken_item_user,Integer> take_no;
    @FXML
    private TableColumn<taken_item_user,String>taken_by;
    @FXML
    private TableColumn<taken_item_user,String>item_id;
    @FXML
    private TableColumn<taken_item_user,String>date;
    @FXML
    private ObservableList<taken_item_user> data=FXCollections.observableArrayList();
    @FXML
    private sample.connectivity.connectionclass connectionclass;



    public void initialize(URL location, ResourceBundle resources) {

        connectionclass =new connectionclass();

    }
    public void changescene_store_keeper_home(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("Store_keeper home.fxml"));
        Scene innerscene = new Scene(inner);

        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }
    @FXML
    public void load_info(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        table.getItems().clear();
          ArrayList<ArrayList> message = new ArrayList<>();
        ArrayList<String> fun=new ArrayList<>();
        Socket sock = null;
        sock = new Socket("localhost", 434);
        //InputStreamReader input = null;
        //input = new InputStreamReader(sock.getInputStream());
        //BufferedReader ir = new BufferedReader(input);
//        String message = null;
//        message = ir.readLine();
        //System.out.println(message);
        fun.add("t1");
        ObjectOutputStream dataa = null;
        dataa = new ObjectOutputStream(sock.getOutputStream());
        dataa.writeObject(fun);
        //
        ObjectInputStream input = new ObjectInputStream(sock.getInputStream());
        System.out.println("thise is the object input method");
        System.out.println(sock.getInputStream());
        Object object = input.readObject();
        System.out.println("the obeject have been read");
        System.out.println(object);
        message = (ArrayList<ArrayList>) object;
        ArrayList<String>listt=new ArrayList<>();
        for (int i = 0; i < message.size(); i++) {
            listt.clear();
            //listt.add(message.get(i);
            System.out.println(message.get(i));

                int a=Integer.parseInt(message.get(i).get(0).toString());
                String b=message.get(i).get(1).toString();
                String c=message.get(i).get(2).toString();
                String d=message.get(i).get(3).toString();
                String e=message.get(i).get(3).toString();
                //Date date= java.sql.Date.valueOf(e);
                data.add(new taken_item_user(a,b,c,d));//,rs.getString("added_by"),rs.getDate("date"),rs.getString("description")));


        }

        System.out.println("hey5");
        System.out.println("hey6");
        taken_by.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        System.out.println("hey7");
        item_id.setCellValueFactory(new PropertyValueFactory<>("item_id"));
        System.out.println("hey8");
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        System.out.println("hey9");

        System.out.println("hey10");
        take_no.setCellValueFactory(new PropertyValueFactory<>("take_no"));
        System.out.println("hey12");
       // date.setCellValueFactory(new PropertyValueFactory<>("date"));
        System.out.println("hey13");


        table.setItems(null);
        System.out.println("hey15");
        table.setItems(data);
        System.out.println("hey13");


    }

}
