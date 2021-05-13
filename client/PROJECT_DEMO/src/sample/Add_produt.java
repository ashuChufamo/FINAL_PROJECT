package sample;




import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.connectivity.connectionclass;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class Add_produt  implements Initializable,collection_2{
    @FXML
    private ObservableList<String> list= FXCollections.observableArrayList();
    @FXML
    private ObservableList<String> list1= FXCollections.observableArrayList();
    @FXML
    private ObservableList<String> liste= FXCollections.observableArrayList();
    @FXML
    TextField item_name;
    @FXML
    private Label lab;
    @FXML
    TextField quantity;
    @FXML
    TextArea description;
    @FXML
    DatePicker date;
    @FXML
    private  ComboBox<String> category;
    @FXML
    private ComboBox<String> brand;
        @Override
        public void initialize(URL location, ResourceBundle resources) {
            //this.addCategoryy(category_collection);

            try {
                this.addCategoryy(category_collection);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        @FXML



        public void addbrand(ArrayList message) throws SQLException, ClassNotFoundException {
           // ObservableList liste=new ArrayList<>();
            liste.clear();
            for(int i=0;i<message.size();i++){
                liste.add((String) message.get(i));

            }

            System.out.println("thise is the add brand class");
//            System.out.println(category.getSelectionModel().getSelectedItem());
//            String value=category.getSelectionModel().getSelectedItem();
//            PreparedStatement rd = connectionclass.getconnection().prepareStatement("select brand_name from brand where catagory='"+value+"'");
//            ResultSet rs = rd.executeQuery();
//            list.clear();
//            while (rs.next()) {
//
//                System.out.println("thise is the while loop");
//                if(list.contains(rs.getString("brand_name"))){
//
//                    System.out.println("the item have been added");
//
//                }else{
//
//                    list.add(rs.getString("brand_name"));
//
//                }
//
//                //System.out.println(rs.getString("name"));
//            }


            brand.setItems(liste);


        }
        public void getInttomessage(ArrayList message){

            for(int i=0;i<message.size();i++){
                category_collection.add((String) message.get(i));


            }


        }
        @FXML
        public String combo_1(ActionEvent event){
            //System.out.println(category.getValue());
            return(category.getValue().toString());



        }
    public void addCategoryy(ArrayList message) throws SQLException, ClassNotFoundException {
            for(int i=0;i<message.size();i++){

                list.add((String) message.get(i));
            }
//        PreparedStatement rd = connectionclass.getconnection().prepareStatement("select catagory_name from catagory");
//        ResultSet rs = rd.executeQuery();
//        list1.clear();
//        while (rs.next()) {
//
//            System.out.println("thise is the while loop");
//            if(list1.contains(rs.getString("catagory_name"))){
//                System.out.println("the item is already existed");
//
//            }else{
//
//                list1.add(rs.getString("catagory_name"));
//            }
//           ;
//            //System.out.println(rs.getString("name"));
//        }
//        list.add("Electronics");
//        list.add("writing");
//        list.add("Furniture");
//        list.add("Chairs");
        category.setItems(list);



    }
    public void add_stock(ActionEvent event){


    }
        public void addnew(ActionEvent event) throws IOException {
            System.out.println("you have clicked me");
            Parent inner = FXMLLoader.load(getClass().getResource("addproduct.fxml"));
            Scene innerscene = new Scene(inner);
            Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
            innerStage.setScene(innerscene);
            innerStage.show();
        }
        @FXML
    public   void get_value() throws SQLException, ClassNotFoundException {
            System.out.println(category.getSelectionModel().getSelectedItem());
    }
    public void temporary() throws IOException, ClassNotFoundException, SQLException {
        System.out.println(category.getSelectionModel().getSelectedItem());

        ArrayList<String> message = new ArrayList<>();
        Socket sock = null;
        sock = new Socket("localhost", 434);
        //

        //
        ObjectOutputStream data = null;
        data = new ObjectOutputStream(sock.getOutputStream());
        ArrayList<String> list = new ArrayList<>();
        list.add("temp");
        System.out.println(category.getSelectionModel().getSelectedItem());
        list.add(category.getSelectionModel().getSelectedItem());
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
        for (int i = 0; i < message.size(); i++) {
            System.out.println(message.get(i));
        }
        //addbrand  ad=new addbrand();
        System.out.println("thise is the retrived value");
        //a.getInttomessage(message);
        //a.addCategoryy();
        addbrand(message);
    }
    public void add_stock(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addproduct.fxml"));
        Stage primaryStage=new Stage();
        Scene scene=new Scene(root, 600, 400);
        primaryStage.setTitle("add item");
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        primaryStage.show();



    }
    public void _submit_button_clicked(javafx.event.ActionEvent actionEvent) {
        try {
            Socket sock = null;
            sock = new Socket("localhost",  434);
            //InputStreamReader input = null;
            //input = new InputStreamReader(sock.getInputStream());
            //BufferedReader ir = new BufferedReader(input);
//        String message = null;
//        message = ir.readLine();
            //System.out.println(message);
            ObjectOutputStream data = null;
            data = new ObjectOutputStream(sock.getOutputStream());
            ArrayList<String > list=new ArrayList<>();
            list.add("s5");

            //list.add(descriptionn.getText());


            System.out.println(item_name.getText());
            String supplier_name="belayab";
            System.out.println(supplier_name);
            System.out.println(brand.getSelectionModel().getSelectedItem());
            System.out.println(category.getSelectionModel().getSelectedItem());
            System.out.println(quantity.getText());
//            System.out.println(supplier_date.getText());
            System.out.println(date.getValue());
            String  addby="atr/8584/10";
            System.out.println(addby);
            LocalDate Date=date.getValue();
            list.add(item_name.getText());
            list.add(quantity.getText());
            //list.add(supplier_name);
            list.add(brand.getSelectionModel().getSelectedItem());
            list.add(category.getSelectionModel().getSelectedItem());

            list.add(date.getValue().toString());
            list.add(addby);
            list.add("null");
            list.add(description.getText());

            //list.add(description.getText());
            //list.add(quantity.getText());
//           Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagementsystem", "root", "");

            //list.add(descriptionn.getText());

            data.writeObject(list);
            data.flush();
            data.close();
            //Statement st = sample.connectivity.connectionclass.getconnection().createStatement();
            //int a= Integer.parseInt(supplier_number.getText());
            //st.execute("insert into stock values('"+item_name.getText()+"','"+supplier_name+"','"+brand.getSelectionModel().getSelectedItem()+"','"+category.getSelectionModel().getSelectedItem()+"','"+quantity.getText()+"','"+date.getValue()+"','"+addby+"','"+description+"')");
            // st.execute("insert into supplier values('gfgd',23456789,'gshjhhjhj','ashu',null,'bgf')");
            System.out.println("done");
            item_name.clear();
            brand.setPromptText("brand");
            category.setPromptText("category");
            quantity.clear();
            date.setValue(null);



        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}


