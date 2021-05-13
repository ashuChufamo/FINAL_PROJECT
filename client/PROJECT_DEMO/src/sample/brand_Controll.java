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
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.connectivity.connectionclass;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class brand_Controll implements Initializable {
    stock_control s=new stock_control();
    databasewrite d=new databasewrite();


    @FXML
    TextField brand_name;
    @FXML
    private  ComboBox<String> category;
    @FXML
    DatePicker brand_date;
    @FXML
    TextArea brand_description;
    @FXML
    private TableView<user_brand> table;
    @FXML

    private TableColumn<user,String>Supplier_name;
    @FXML

    private TableColumn<user,String>addesd_by;
    @FXML

    private TableColumn<user,String>category_view;
    @FXML
    private TableColumn<user,String>date;
    @FXML
    private TableColumn<user,String>description;
    @FXML
    private ObservableList<user_brand> data=FXCollections.observableArrayList();

    @FXML
    private ObservableList<String> list= FXCollections.observableArrayList();
    @FXML
    private connectionclass connectionclass;
    @Override


    public void initialize(URL location, ResourceBundle resources) {

        connectionclass =new connectionclass();



    }
    @FXML


    public void to_main(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("Store_keeper home.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }
    public void load(javafx.event.ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
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
        fun.add("b2");
        ObjectOutputStream dataa = null;
        dataa = new ObjectOutputStream(sock.getOutputStream());
        dataa.writeObject(fun);
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

            String a=message.get(i).get(0).toString();
            String b=message.get(i).get(1).toString();
            String c=message.get(i).get(2).toString();
            String d=message.get(i).get(3).toString();
            String e=message.get(i).get(4).toString();
            Date date= java.sql.Date.valueOf(c);
            data.add(new user_brand(a,b,date,d,e));//,rs.getString("added_by"),rs.getDate("date"),rs.getString("description")));


        }
//            System.out.println("hey4");
//            data.add(new category_class(rs.getString("catagory_name"),rs.getString("added_by"),rs.getDate("date"),rs.getString("description")));
//        }


        System.out.println("hey5");


        System.out.println("hey6");
        Supplier_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        System.out.println("hey7");

        System.out.println("hey8");
        addesd_by.setCellValueFactory(new PropertyValueFactory<>("added_by"));
        System.out.println("hey9");
        category_view.setCellValueFactory(new PropertyValueFactory<>("category"));

        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        System.out.println("hey10");
        description.setCellValueFactory(new PropertyValueFactory<>("descriiption"));
        System.out.println("hey11");
        table.setItems(null);
        System.out.println("hey12");
        table.setItems(data);
        System.out.println("hey13");
    }
    public void update_brand(ActionEvent event) throws IOException {
        Socket sock = null;
        sock = new Socket("localhost", 434);
        //InputStreamReader input = null;
        //input = new InputStreamReader(sock.getInputStream());
        //BufferedReader ir = new BufferedReader(input);
//        String message = null;
//        message = ir.readLine();
        //System.out.println(message);
        ObjectOutputStream data = null;
        data = new ObjectOutputStream(sock.getOutputStream());
        //data.writeUTF("thised");
    }
    public void delete_brand(ActionEvent event) throws IOException {
        Socket sock = null;
        sock = new Socket("localhost", 434);
        //InputStreamReader input = null;
        //input = new InputStreamReader(sock.getInputStream());
        //BufferedReader ir = new BufferedReader(input);
//        String message = null;
//        message = ir.readLine();
        //System.out.println(message);
        ObjectOutputStream data = null;
        data = new ObjectOutputStream(sock.getOutputStream());
        //data.writeUTF("thised");
    }


    public void back(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("brandclass.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }
    public void ADDBRAND() throws IOException, ClassNotFoundException, SQLException {
        ArrayList<String> message = new ArrayList<>();
        Socket sock = null;
        sock = new Socket("localhost", 434);
        //

        //
        ObjectOutputStream data = null;
        data = new ObjectOutputStream(sock.getOutputStream());
        ArrayList<String > list=new ArrayList<>();
        list.add("b1");
        data.writeObject(list);
        //data.flush();
        //data.close();
        //
        ObjectInputStream input = new ObjectInputStream(sock.getInputStream());
        System.out.println("thise is the object input method");
        System.out.println(sock.getInputStream());
        Object object = input.readObject();
        System.out.println("the obeject have been read");
        System.out.println(object);
        message = (ArrayList<String>) object;
        for(int i=0;i<message.size();i++){
            System.out.println(message.get(i));
        }
        addbrand  ad=new addbrand();
        System.out.println("thise is the retrived value");

        ad.addCategoryy(message);



    }
    @FXML
    public void addbrand(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        s.ADDSTOCK();
        Parent root = FXMLLoader.load(getClass().getResource("addbrand.fxml"));
        Stage primaryStage=new Stage();
        Scene scene=new Scene(root, 600, 400);
        primaryStage.setTitle("add item");
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        primaryStage.show();
//        System.out.println("you have clicked me");
//        Parent inner = FXMLLoader.load(getClass().getResource("addbrand.fxml"));
//        Scene innerscene = new Scene(inner);
//        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
//        innerStage.setScene(innerscene);
//        innerStage.show();


    }
    public void search(ActionEvent event){



    }


}

