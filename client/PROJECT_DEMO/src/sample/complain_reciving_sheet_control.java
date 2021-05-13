package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.connectivity.connectionclass;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class complain_reciving_sheet_control implements Initializable,collection_2 {

    @FXML
    private TextField searchBar;
    @FXML
    private TableView<complain_sheet_user> table;
    @FXML
    private TableColumn<complain_sheet_user,String> user_name;
    @FXML
    private TableColumn<complain_sheet_user,String> complain;
    @FXML
    private TableColumn<complain_sheet_user,String> replay;
    @FXML
    private TableColumn<complain_sheet_user,String>complain_date;
    @FXML
    private TableColumn<complain_sheet_user,String>replay_date;
    @FXML
    private ObservableList<complain_sheet_user> data= FXCollections.observableArrayList();
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
    public  void load_information(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        Socket sock = null;
        sock = new Socket("localhost", 121);
        //InputStreamReader input = null;
        //input = new InputStreamReader(sock.getInputStream());
        //BufferedReader ir = new BufferedReader(input);
//        String message = null;
//        message = ir.readLine();
        //System.out.println(message);
        ObjectOutputStream dataa= null;
        dataa = new ObjectOutputStream(sock.getOutputStream());
        //data.writeUTF("thised");
        System.out.println("thsie is the load method");
        System.out.println("thise is the loader method");
        Connection com= sample.connectivity.connectionclass.getconnection();
        System.out.println("hey");
        //data= FXCollections.observableArrayList();
        System.out.println("hey1");
        Statement st = sample.connectivity.connectionclass.getconnection().createStatement();
        System.out.println("hey2");
        ResultSet rs=st.executeQuery("SELECT * FROM complain_sheet");
        System.out.println("hey3");
        while(rs.next()){
            System.out.println("hey4");
            data.add(new complain_sheet_user(rs.getString("user_name"),rs.getString("complain"),rs.getString("replay"),rs.getDate("complain_date"),rs.getDate("replay_date")));
        }
        System.out.println("hey5");
        System.out.println("hey6");
        user_name.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        System.out.println("hey7");
        complain.setCellValueFactory(new PropertyValueFactory<>("complain"));
        System.out.println("hey8");
        replay.setCellValueFactory(new PropertyValueFactory<>("replay"));
        System.out.println("hey9");
        complain_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        System.out.println("hey10");
        replay_date.setCellValueFactory(new PropertyValueFactory<>("date1"));
        System.out.println("hey12");



        table.setItems(null);
        System.out.println("hey15");
        table.setItems(data);
        System.out.println("hey13");
        this.add();


    }

    @FXML
    public void search(ActionEvent event){
        table.getItems().clear();
        System.out.println("Starts");
        String text = searchBar.getText();
        int tlen = catagory_sheet_selection.size();

        data.clear();
        for (int i = 0; i < tlen; i++) {
            if (complain_sheet_users_list.get(i).getUser_name().toLowerCase().contains(searchBar.getText().toLowerCase())
            ){
                data.add(complain_sheet_users_list.get(i));
            }
        }
        user_name.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        complain.setCellValueFactory(new PropertyValueFactory<>("complain"));
        replay.setCellValueFactory(new PropertyValueFactory<>("replay"));
        complain_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        replay_date.setCellValueFactory(new PropertyValueFactory<>("date1"));
        table.setItems(data);

    }



    public void add(){
        int tlen = table.getItems().size();
        for (int i = 0; i < tlen; i++) {

            complain_sheet_users_list.add(table.getItems().get(i));

        }

    }

    @FXML
    public void replay(ActionEvent event) throws IOException {
        String model = table.getSelectionModel().getSelectedItem().toString();
        if (!model.equals(null)){
            Parent root = FXMLLoader.load(getClass().getResource("complain_about_item.fxml"));
            complain_sheet_users.add(table.getSelectionModel().getSelectedItem());
            Stage primaryStage=new Stage();
            Scene scene=new Scene(root, 600, 400);
            primaryStage.setTitle("Replay Complain");
            primaryStage.setResizable(false);
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
            primaryStage.show();




    }
}}
