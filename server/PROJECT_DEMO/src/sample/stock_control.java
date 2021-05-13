package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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

public class stock_control implements Initializable,collection_2 {
@FXML
TextField  searchBar;
    @FXML
    TextField item_name;
    @FXML
    private Label lab;
    TextField quantity;
    @FXML
    ComboBox supplied_by;

    ComboBox category;
    @FXML
    ComboBox<String> ctBox;
    @FXML
    ComboBox<String> category_box;
    @FXML
    public ComboBox<String> brand;
    @FXML
    DatePicker date;
    @FXML
    TextArea description;
    @FXML
    private TableView<stock_user> table;
    @FXML
    private TableColumn<stock_user, String> name;
    @FXML
    private TableColumn<stock_user, String> CATEGORY;
    @FXML
    private TableColumn<stock_user, String> bbrand;
    @FXML
    private TableColumn<stock_user, String> item_id;
    @FXML
    private TableColumn<stock_user, String> owner;
    @FXML

    private ObservableList<stock_user>collect=FXCollections.observableArrayList();
    @FXML
    private TableColumn<stock_user, String> ddate;
    @FXML
    private TextField searchFielld;

    @FXML
    private TableColumn<stock_user, String> added_by;
    @FXML
    private TableColumn<stock_user, String> describtion;

    private ObservableList<stock_user> data = FXCollections.observableArrayList();
    @FXML
    private sample.connectivity.connectionclass connectionclass;
    private static ObservableList<String> list = FXCollections.observableArrayList();
    @FXML
    private Label label;

    @FXML
    public ComboBox<String> brand_box;
    @FXML


    Add_produt a = new Add_produt();

    public void to_main(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("Store_keeper home.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }

    public void search(Event event ) throws SQLException, ClassNotFoundException {
        table.getItems().clear();
        System.out.println(stocks.isEmpty());
        System.out.println("Starts");
        String text = searchBar.getText();
        int tlen = stocks.size();

        data.clear();
        for (int i = 0; i < tlen; i++) {
            if (stocks.get(i).getName().toLowerCase().contains(searchBar.getText().toLowerCase()) || stocks.get(i).getcategory().toLowerCase().contains(searchBar.getText().toLowerCase())|| stocks.get(i).gebrand().toLowerCase().contains(searchBar.getText().toLowerCase())){
                data.add(stocks.get(i));
            }
        }

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        bbrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        //quan.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        //supplied.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        ddate.setCellValueFactory(new PropertyValueFactory<>("date"));
        added_by.setCellValueFactory(new PropertyValueFactory<>("added_by"));
        CATEGORY.setCellValueFactory(new PropertyValueFactory<>("category"));
        table.setItems(data);


    }

//    public void initialize(URL location, ResourceBundle resources) {
//        //box.setItems(list);
//
//        try {
//            //Class.forName("com.mysql.cj.jdbc.Driver");
//            //Statement st = (Statement) connectionclass.getconnection().createStatement();
//            PreparedStatement rd = connectionclass.getconnection().prepareStatement("select brand_name from brand");
//            ResultSet rs = rd.executeQuery();
//            while (rs.next()) {
//                list.add(rs.getString("brand_name"));
//                //System.out.println(rs.getString("name"));
//            }
//            brand_box.setItems(list);
//            rd.close();
//            rs.close();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(list);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//    }

    public void back_to_main(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = null;
        try {
            inner = FXMLLoader.load(getClass().getResource("store_keeper.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }
    public void add(){
        int tlen = table.getItems().size();
        for (int i = 0; i < tlen; i++) {

            stocks.add(table.getItems().get(i));

        }

    }


    public void load_information(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
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
        fun.add("S1");
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


                String b=message.get(i).get(0).toString();
                System.out.println(b);
                String c=message.get(i).get(1).toString();
                System.out.println(c);
                String d=message.get(i).get(2).toString();
                System.out.println(d);
                String e=message.get(i).get(3).toString();
                System.out.println(e);
                String f=message.get(i).get(4).toString();
                System.out.println(f);
                String g=message.get(i).get(5).toString();
                System.out.println(g);
                String h=message.get(i).get(7).toString();
                System.out.println(h);
            String v= (String) message.get(i).get(6);
            System.out.println(v);
            //String j=message.get(i).get(8).toString();
            java.util.Date date=Date.valueOf(f);
                //Date date= java.sql.Date.valueOf(f);
                data.add(new stock_user(b,c,d,e, (Date) date,g,v,h));//,rs.getString("added_by"),rs.getDate("date"),rs.getString("description")));


        }
        System.out.println(data.get(0).gebrand()+data.get(0).getcategory());


        System.out.println("hey5");
        System.out.println("hey6");
        item_id.setCellValueFactory(new PropertyValueFactory<>("Item_id"));
        System.out.println("hey7");
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        System.out.println("hey8");
        CATEGORY.setCellValueFactory(new PropertyValueFactory<>("category"));
        System.out.println("hey9");
        bbrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        System.out.println("hey9");
        owner.setCellValueFactory(new PropertyValueFactory<>("owner"));
        System.out.println("hey9");

        System.out.println("hey10");
        ddate.setCellValueFactory(new PropertyValueFactory<>("date"));
        System.out.println("hey12");
        added_by.setCellValueFactory(new PropertyValueFactory<>("added_by"));
        System.out.println("hey13");
        describtion.setCellValueFactory(new PropertyValueFactory<>("description"));


        table.setItems(null);
        System.out.println("hey15");
        table.setItems(data);
        System.out.println("hey13");


    }
public void viewItem() throws IOException, ClassNotFoundException {


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
    fun.add("N");
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


        String b=message.get(i).get(0).toString();
        System.out.println(b);
        String c=message.get(i).get(1).toString();
        System.out.println(c);
        String d=message.get(i).get(2).toString();
        System.out.println(d);
        String e=message.get(i).get(3).toString();
        System.out.println(e);
        String f=message.get(i).get(4).toString();
        System.out.println(f);
        String g=message.get(i).get(5).toString();
        System.out.println(g);
        String h=message.get(i).get(7).toString();
        System.out.println(h);
        String v= (String) message.get(i).get(6);
        System.out.println(v);
        //String j=message.get(i).get(8).toString();
        java.util.Date date=Date.valueOf(f);
        //Date date= java.sql.Date.valueOf(f);
        data.add(new stock_user(b,c,d,e, (Date) date,g,v,h));//,rs.getString("added_by"),rs.getDate("date"),rs.getString("description")));


    }
    System.out.println(data.get(0).gebrand()+data.get(0).getcategory());


    System.out.println("hey5");
    System.out.println("hey6");
    item_id.setCellValueFactory(new PropertyValueFactory<>("Item_id"));
    System.out.println("hey7");
    name.setCellValueFactory(new PropertyValueFactory<>("Name"));
    System.out.println("hey8");
    CATEGORY.setCellValueFactory(new PropertyValueFactory<>("category"));
    System.out.println("hey9");
    bbrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
    System.out.println("hey9");
    owner.setCellValueFactory(new PropertyValueFactory<>("owner"));
    System.out.println("hey9");

    System.out.println("hey10");
    ddate.setCellValueFactory(new PropertyValueFactory<>("date"));
    System.out.println("hey12");
    added_by.setCellValueFactory(new PropertyValueFactory<>("added_by"));
    System.out.println("hey13");
    describtion.setCellValueFactory(new PropertyValueFactory<>("description"));


    table.setItems(null);
    System.out.println("hey15");
    table.setItems(data);
    System.out.println("hey13");
}





    public void ADDSTOCK() throws IOException, ClassNotFoundException, SQLException {
        ArrayList<String> message = new ArrayList<>();
        Socket sock = null;
        sock = new Socket("localhost", 434);
        //

        //
        ObjectOutputStream data = null;
        data = new ObjectOutputStream(sock.getOutputStream());
        ArrayList<String> list = new ArrayList<>();
        list.add("s2");
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
        a.getInttomessage(message);
        //a.addCategoryy();
//a.initialize();


    }

    public void add_stock(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        ADDSTOCK();
        Parent root = FXMLLoader.load(getClass().getResource("addproduct.fxml"));
        Stage primaryStage = new Stage();
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("add item");
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        primaryStage.show();
//        System.out.println("you have clicked me");
//        Parent inner = null;
//        try {
//            inner = FXMLLoader.load(getClass().getResource("addproduct.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Scene innerscene = new Scene(inner);
//        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
//        innerStage.setScene(innerscene);
//        innerStage.show();


    }

    public void submit_button_clicked(ActionEvent event) throws IOException {
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

        try {
            System.out.println(item_name.getText());
            System.out.println(quantity.getText());
            System.out.println(supplied_by.getSelectionModel());
            System.out.println(category.getSelectionModel());
            System.out.println(brand.getSelectionModel());
            System.out.println(date.getValue());


            LocalDate datee = date.getValue();
            ArrayList<String> list = new ArrayList<>();
            list.add("c5");
            list.add(item_name.getText());
            list.add(quantity.getText());
            list.add("200-10-02");
            //list.add(descriptionn.getText());

            data.writeObject(list);
            data.flush();
            data.close();
//           Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagementsystem", "root", "");

            Statement st = sample.connectivity.connectionclass.getconnection().createStatement();
            // int a= Integer.parseInt(supplier_number.());
            st.execute("insert into stock values('" + item_name.getText() + "','" + supplied_by.getSelectionModel() + "','" + brand.getSelectionModel() + "','" + category.getSelectionModel() + "','" + quantity.getText() + "','" + date + "')");
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
    public void update_stock(ActionEvent event) throws IOException {
        this.view();
//        System.out.println("you have clicked me");
//        Parent inner = null;
//        try {
//            inner = FXMLLoader.load(getClass().getResource("update item.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Scene innerscene = new Scene(inner);
//        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
//        innerStage.setScene(innerscene);
//        innerStage.show();


    }
    public void view() throws IOException {
        String model =table.getSelectionModel().getSelectedItem().toString();
        if (!model.equals(null)) {
            stocks.clear();
            stocks.add(table.getSelectionModel().getSelectedItem());
            Parent root = FXMLLoader.load(getClass().getResource("update item.fxml"));
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Update Item");
            primaryStage.setResizable(false);
            Scene scene = new Scene(root, 600, 400);
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
            primaryStage.show();
        }
    }


    public void delete_stock(ActionEvent event) {
    }

    public void back(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = null;
        try {
            inner = FXMLLoader.load(getClass().getResource("store_keeper.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }
public void doubleClickSt_table(MouseEvent event) throws IOException {
    int click = event.getClickCount();
    if (click == 2) {
       this.view();
    }

}
    public void brand_combobox() {

        //box.setItems(list);
        // brand_box=new ComboBox<>(list);

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //Statement st = (Statement) connectionclass.getconnection().createStatement();
            PreparedStatement rd = sample.connectivity.connectionclass.getconnection().prepareStatement("select brand_name from brand");
            ResultSet rs = rd.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("brand_name"));
                //System.out.println(rs.getString("name"));
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
                //brand.getItems().add(list.get(i));


            }


            brand_box.setItems(list);
            rd.close();
            rs.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        try {
//            this.ADDSTOCK();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    }
}





