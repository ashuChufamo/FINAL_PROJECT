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

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class category_controll implements Initializable,collection_2 {
    databasewrite d=new databasewrite();


    @FXML
    private TextField searchBar;
    @FXML
    private  TextField supplier_name;
    @FXML
    private

    TextField supplier_addedby;
    @FXML
    private
    DatePicker supplier_date;
    @FXML
    private
    TextArea supplier_description;
    @FXML
     private TableView<category_class> table;
    @FXML
    TextField category_name;
    @FXML
    DatePicker datee;
    @FXML
    TextArea descriptionn;
    @FXML
    private TableColumn<category_class,String>Supplier_name;
    @FXML

    private TableColumn<category_class,String>addesd_by;
    @FXML
    private TableColumn<category_class,String>date;
    @FXML
    private TableColumn<category_class,String>description;
    @FXML
    private ObservableList<category_class> data=FXCollections.observableArrayList();
    @FXML
    private connectionclass connectionclass;

    public category_controll() {
    }

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
    public void submitButtonClicked() throws IOException {
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

        System.out.println(category_name.getText());
        //String supplier_name="belayab";
        //System.out.println(supplier_name);
        System.out.println(descriptionn.getText());
//            System.out.println(supplier_date.getText());
        System.out.println(datee.getValue());
        String  addby="atr/8584/10";
        System.out.println(addby);
        //LocalDate Date=datee.getValue();
//           Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagementsystem", "root", "");

        //Statement st = sample.connectivity.connectionclass.getconnection().createStatement();
        //int a= Integer.parseInt(supplier_number.getText());
        ArrayList<String > list=new ArrayList<>();
        list.add("c5");
        list.add(category_name.getText());
        list.add(addby);
        list.add(datee.getValue().toString());
        list.add(descriptionn.getText());

        data.writeObject(list);
        data.flush();
        data.close();
        //st.execute("insert into catagory values('"+category_name.getText()+"','"+addby+"','"+Date+"','"+descriptionn.getText()+"')");
        // st.execute("insert into supplier values('gfgd',23456789,'gshjhhjhj','ashu',null,'bgf')");
        System.out.println("done");
        //category_name.clear();

        //descriptionn.clear();
        //Date.clear();


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
        fun.add("c1");
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

                String a=message.get(i).get(0).toString();
                String b=message.get(i).get(1).toString();
                String c=message.get(i).get(2).toString();
                String d=message.get(i).get(3).toString();
                Date date= java.sql.Date.valueOf(c);
                data.add(new category_class(a,b,d,date));//,rs.getString("added_by"),rs.getDate("date"),rs.getString("description")));


        }
//            System.out.println("hey4");
//            data.add(new category_class(rs.getString("catagory_name"),rs.getString("added_by"),rs.getDate("date"),rs.getString("description")));
//        }
        System.out.println("hey5");


        System.out.println("hey6");
        addesd_by.setCellValueFactory(new PropertyValueFactory<>("added_by"));
        System.out.println("hey7");
        Supplier_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        System.out.println("hey7");

        System.out.println("hey8");

        System.out.println("hey9");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        System.out.println("hey10");
        description.setCellValueFactory(new PropertyValueFactory<>("descriiption"));
        System.out.println("hey11");
        table.setItems(null);

        System.out.println("hey12");
        table.setItems(data);
        System.out.println("hey13");
        this.addAll();
    }
    public void addAll(){
        int tlen = table.getItems().size();
        for (int i = 0; i < tlen; i++) {

            catagory_sheet_selection.add(table.getItems().get(i));

        }
    }
    public void supplierclass(ActionEvent actionEvent) {
        try {

            System.out.println(supplier_name.getText());

            System.out.println(supplier_addedby.getText());
//            System.out.println(supplier_date.getText());
            System.out.println(supplier_description.getText());
            System.out.println(supplier_name.getText());
            LocalDate date=supplier_date.getValue();
//           Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagementsystem", "root", "");

            Statement st = sample.connectivity.connectionclass.getconnection().createStatement();

            st.execute("insert into supplier values('"+supplier_name.getText()+"','"+supplier_addedby.getText()+"','"+date+"','"+supplier_description.getText()+"')");
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

    public void search(ActionEvent event){}
    public void addcategory(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("add_category.fxml"));
        Stage primaryStage=new Stage();
        Scene scene=new Scene(root, 600, 400);
        primaryStage.setTitle("add item");
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        primaryStage.show();
//        System.out.println("you have clicked me");
//        Parent inner = FXMLLoader.load(getClass().getResource("add_category.fxml"));
//        Scene innerscene = new Scene(inner);
//        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
//        innerStage.setScene(innerscene);
//        innerStage.show();


    }
    public void update_category(ActionEvent event) throws IOException {
        String model = table.getSelectionModel().getSelectedItem().toString();
        if (!model.equals(null)){
            catagory_sheet.add(table.getSelectionModel().getSelectedItem());
            Parent root = FXMLLoader.load(getClass().getResource("UpdateCategory.fxml"));

            Stage primaryStage=new Stage();
            Scene scene=new Scene(root, 600, 400);
            primaryStage.setTitle("Update Item");
            primaryStage.setResizable(false);
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
            primaryStage.show();

        }
//
//        Socket sock = null;
//        sock = new Socket("localhost", 434);
//        //InputStreamReader input = null;
//        //input = new InputStreamReader(sock.getInputStream());
//        //BufferedReader ir = new BufferedReader(input);
////        String message = null;
////        message = ir.readLine();
//        //System.out.println(message);
//        ObjectOutputStream data = null;
//        data = new ObjectOutputStream(sock.getOutputStream());
//        //data.writeUTF("thised");


    }
// String model = table.getSelectionModel().getSelectedItem().toString();
    public void search(){
        table.getItems().clear();
        System.out.println("Starts");
    String text = searchBar.getText();
    int tlen = catagory_sheet_selection.size();

        data.clear();
        for (int i = 0; i < tlen; i++) {
        if (catagory_sheet_selection.get(i).getName().toLowerCase().contains(searchBar.getText().toLowerCase())
        ){
            data.add(catagory_sheet_selection.get(i));
        }
    }
        addesd_by.setCellValueFactory(new PropertyValueFactory<>("added_by"));
        Supplier_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        description.setCellValueFactory(new PropertyValueFactory<>("descriiption"));
        table.setItems(data);}
    public  void delete_category(ActionEvent event) throws IOException {
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
}

