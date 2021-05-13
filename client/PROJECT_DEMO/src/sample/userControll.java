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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.connectivity.connectionclass;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class userControll implements Initializable {
    databasewrite d=new databasewrite();


    @FXML
    TextField supplier_name;
    @FXML
    TextField supplier_number;
    @FXML
    TextField supplier_Address;
    @FXML
    TextField supplier_addedby;
    @FXML
    DatePicker supplier_date;
    @FXML
    TextArea supplier_description;
    @FXML
    private TableView<user> table;
    @FXML
    private TableColumn<user,Integer>Contact_no;
    @FXML
    private TableColumn<user,String>Supplier_name;
    @FXML
    private TableColumn<user,String>address;
    @FXML
    private TableColumn<user,String>addesd_by;
    @FXML
    private TableColumn<user,String>date;
    @FXML
    private TableColumn<user,String>description;
    @FXML
    private ObservableList<user> data=FXCollections.observableArrayList();
    @FXML
    private connectionclass connectionclass;
    @Override


    public void initialize(URL location, ResourceBundle resources) {

        connectionclass =new connectionclass();

    }
    @FXML
//public void load(ActionEvent event) throws SQLException, ClassNotFoundException {
//        Connection com=connectionclass.getconnection();
//        data= FXCollections.observableArrayList();
//        Statement st = (Statement) connectionclass.getconnection().createStatement();
//        ResultSet rs=st.executeQuery("SELECT * FROM supplier");
//
//        while(((ResultSet) rs).next()){
//            data.add(new user(rs.getString(0),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
//}
//        Supplier_name.setCellValueFactory(new PropertyValueFactory<>("supplier name"));
//        Contact_no.setCellValueFactory(new PropertyValueFactory<>("Contact_no"));
//        address.setCellValueFactory(new PropertyValueFactory<>("address"));
//        addesd_by.setCellValueFactory(new PropertyValueFactory<>("addesd_by"));
//        date.setCellValueFactory(new PropertyValueFactory<>("date"));
//        description.setCellValueFactory(new PropertyValueFactory<>("description"));
//
//        table.setItems(null);
//        table.setItems(data);
//
//
//
//    }


    public void load(javafx.event.ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
//        ArrayList<String> message = new ArrayList<>();
//        Socket sock = null;
//        sock = new Socket("localhost", 121);
//        //
//
//        //
//        ObjectOutputStream data = null;
//        data = new ObjectOutputStream(sock.getOutputStream());
//        ArrayList<String> list = new ArrayList<>();
//        list.add("temp");
//        System.out.println("thise is the loader method");
//        Connection com= sample.connectivity.connectionclass.getconnection();
//        System.out.println("hey");
//        data= FXCollections.observableArrayList();
        System.out.println("hey1");
        Statement st = sample.connectivity.connectionclass.getconnection().createStatement();
        System.out.println("hey2");
        ResultSet rs=st.executeQuery("SELECT * FROM supplier");
        System.out.println("hey3");
        while(rs.next()){
            System.out.println("hey4");
            data.add(new user(rs.getString("supplier_name"),rs.getInt("contact_no"),rs.getString("adress"),rs.getString("added_by"),rs.getDate("date"),rs.getString("description")));
        }
        System.out.println("hey5");
        Contact_no.setCellValueFactory(new PropertyValueFactory<>("Contact_no"));

        System.out.println("hey6");
        Supplier_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        System.out.println("hey7");
        address.setCellValueFactory(new PropertyValueFactory<>("adress"));
        System.out.println("hey8");
        addesd_by.setCellValueFactory(new PropertyValueFactory<>("added_by"));
        System.out.println("hey9");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        System.out.println("hey10");
        description.setCellValueFactory(new PropertyValueFactory<>("descriiption"));
        System.out.println("hey11");
        table.setItems(null);
        System.out.println("hey12");
        table.setItems(data);
        System.out.println("hey13");
    }
    public void to_main(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("Store_keeper home.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }
    public void supplierclass(ActionEvent actionEvent) {
        try {
            System.out.println(supplier_number.getText());
            System.out.println(supplier_name.getText());
            System.out.println(supplier_number.getText());
            System.out.println(supplier_Address.getText());
            System.out.println(supplier_addedby.getText());
//            System.out.println(supplier_date.getText());
            System.out.println(supplier_description.getText());
            System.out.println(supplier_name.getText());
            LocalDate date=supplier_date.getValue();
//           Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagementsystem", "root", "");

            Statement st = sample.connectivity.connectionclass.getconnection().createStatement();
            int a= Integer.parseInt(supplier_number.getText());
            st.execute("insert into supplier values('"+supplier_name.getText()+"','"+a+"','"+supplier_Address.getText()+"','"+supplier_addedby.getText()+"','"+date+"','"+supplier_description.getText()+"')");
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
    public void back(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("SUPPLIERr.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }
    public void addsupplier(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("addsupplier.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }
}

