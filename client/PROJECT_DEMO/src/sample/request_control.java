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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.connectivity.connectionclass;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

public class request_control implements Initializable,collection_2 {
    @FXML
    private TextField searchBoc;
    @FXML
    private TableView<requested_user> table;
    @FXML
    private TableColumn<requested_user,String> user_name;
    @FXML
    private TableColumn<requested_user,String> categoy;
    @FXML
    private TableColumn<requested_user,String> item_name;
    @FXML
    private TableColumn<requested_user,String>brand;
    @FXML
    private TableColumn<requested_user,Integer>quantity;
    @FXML
    private TableColumn<requested_user, Date> requested_date;
    @FXML
    private TableColumn<requested_user,String> aproved_by;
    @FXML
    private TableColumn<requested_user,String> approved;
    @FXML
    private TableColumn<requested_user, Date> approved_date;
    @FXML
    private ObservableList<requested_user> data= FXCollections.observableArrayList();
    @FXML
    private sample.connectivity.connectionclass connectionclass;



    public void initialize(URL location, ResourceBundle resources) {

        connectionclass =new connectionclass();

    }

    @FXML
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
    public void load_information(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        Socket sock = null;
        sock = new Socket("localhost", 434);
        //InputStreamReader input = null;
        //input = new InputStreamReader(sock.getInputStream());
        //BufferedReader ir = new BufferedReader(input);
//        String message = null;
//        message = ir.readLine();
        //System.out.println(message);
        ObjectOutputStream dataa = null;
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
        ResultSet rs=st.executeQuery("SELECT * FROM requested_items");
        System.out.println("hey3");
        while(rs.next()){
            System.out.println("hey4");
            data.add(new requested_user(rs.getString("item_name"),rs.getString("user_name"),rs.getInt("quantity"),rs.getString("category"),rs.getString("brand"),rs.getDate("requested_date"),rs.getString("approved_by"),rs.getDate("approved_date"),rs.getString("approved")));
        }
        System.out.println("hey5");
        System.out.println("hey6");
        user_name.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        System.out.println("hey7");
        categoy.setCellValueFactory(new PropertyValueFactory<>("category"));
        System.out.println("hey8");
        item_name.setCellValueFactory(new PropertyValueFactory<>("itemame"));
        System.out.println("hey9");
        brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        System.out.println("hey10");
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        System.out.println("hey12");
        requested_date.setCellValueFactory(new PropertyValueFactory<>("requested_date"));
        System.out.println("hey9");
        aproved_by.setCellValueFactory(new PropertyValueFactory<>("Approved_by"));
        System.out.println("hey10");
        approved.setCellValueFactory(new PropertyValueFactory<>("Approved"));
        System.out.println("hey12");
        approved_date.setCellValueFactory(new PropertyValueFactory<>("Approved_date"));
        System.out.println("hey12");



        table.setItems(null);
        System.out.println("hey15");
        table.setItems(data);
        System.out.println("hey13");


    }
    @FXML
    public void approve(ActionEvent event) throws IOException {
        String model =table.getSelectionModel().getSelectedItem().toString();
        if (!model.equals(null)) {
            request_selItem.clear();
            request_selItem.add(table.getSelectionModel().getSelectedItem());
            Parent root = FXMLLoader.load(getClass().getResource("Approve_req_item.fxml"));
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Approve Item");
            Scene scene = new Scene(root, 600, 400);
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
            primaryStage.show();



        }


    }
    @FXML
    public void search(ActionEvent event){
        table.getItems().clear();
        System.out.println(request_items.isEmpty());
        System.out.println("Starts");
        String text = searchBoc.getText();
        int tlen = request_items.size();

        data.clear();
        for (int i = 0; i < tlen; i++) {
            if (request_items.get(i).getItemame().toLowerCase().contains(searchBoc.getText().toLowerCase()) || request_items.get(i).getCategory().toLowerCase().contains(searchBoc.getText().toLowerCase())|| request_items.get(i).getBrand().toLowerCase().contains(searchBoc.getText().toLowerCase())){
                data.add(request_items.get(i));
            }
        }
        user_name.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        System.out.println("hey7");
        categoy.setCellValueFactory(new PropertyValueFactory<>("category"));
        System.out.println("hey8");
        item_name.setCellValueFactory(new PropertyValueFactory<>("itemame"));
        System.out.println("hey9");
        brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        System.out.println("hey10");
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        System.out.println("hey12");
        requested_date.setCellValueFactory(new PropertyValueFactory<>("requested_date"));
        System.out.println("hey9");
        aproved_by.setCellValueFactory(new PropertyValueFactory<>("Approved_by"));
        System.out.println("hey10");
        approved.setCellValueFactory(new PropertyValueFactory<>("Approved"));
        System.out.println("hey12");
        approved_date.setCellValueFactory(new PropertyValueFactory<>("Approved_date"));
        System.out.println("hey12");
        table.setItems(data);


    }

}
