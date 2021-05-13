package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.connectivity.connectionclass;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class addbrand implements Initializable,collection_2 {


    @FXML
    TextField brand_name;
    @FXML
    private ComboBox<String> category;
    @FXML
    DatePicker brand_date;
    @FXML
    TextArea brand_description;
    @FXML
    private ObservableList<String> list= FXCollections.observableArrayList();
    @FXML
    public void supplierclass(ActionEvent actionEvent) throws IOException {
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
        ArrayList<String > list=new ArrayList<>();
        list.add("b1");

        //list.add(descriptionn.getText());


        System.out.println(brand_name.getText());
        String supplier_name="belayab";
        System.out.println(supplier_name);
        //System.out.println(brand.getSelectionModel().getSelectedItem());
        System.out.println(category.getSelectionModel().getSelectedItem());
        //System.out.println(quantity.getText());
//            System.out.println(supplier_date.getText());
        //System.out.println(date.getValue());
        String  addby="fasika";
        System.out.println(addby);
        LocalDate Date=brand_date.getValue();
        list.add(brand_name.getText());
        list.add(addby);
        list.add(brand_date.getValue().toString());
        list.add(brand_description.getText());
        list.add(category.getSelectionModel().getSelectedItem());
        //list.add(brand_description.getText());
        //list.add(date.getValue().toString());
        //list.add(addby);
        //list.add(description.getText());
        //list.add(quantity.getText());
//           Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagementsystem", "root", "");

        //list.add(descriptionn.getText());

        data.writeObject(list);
        data.flush();
        data.close();
//        try {
//            String added_by="ashu";
//            System.out.println(brand_name.getText());
//
//            System.out.println(category.getSelectionModel().getSelectedItem());
////            System.out.println(supplier_date.getText());
//            System.out.println(brand_description.getText());
//
//            LocalDate date=brand_date.getValue();
////           Class.forName("com.mysql.cj.jdbc.Driver");
////            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagementsystem", "root", "");
//
//            Statement st = sample.connectivity.connectionclass.getconnection().createStatement();
//
//            st.execute("insert into brand values('"+brand_name.getText()+"','"+added_by+"','"+date+"','"+brand_description.getText()+"','"+category.getSelectionModel().getSelectedItem()+"')");
//            // st.execute("insert into supplier values('gfgd',23456789,'gshjhhjhj','ashu',null,'bgf')");
//            System.out.println("done");
//        } catch (SQLException e) {
//            e.printStackTrace();
////        } catch (ClassNotFoundException e) {
////            e.printStackTrace();
////        }


        //} catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }

    public void addCategoryy(ArrayList message) throws SQLException, ClassNotFoundException, IOException {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//Add_produt a=new Add_produt();
        try {
            this.addCategoryy(category_collection);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//         try {
//        this.addCategoryy();
//         } catch (SQLException e) {
//          e.printStackTrace();
//         } catch (ClassNotFoundException e) {
//          e.printStackTrace();
//        }
//         }
}
    }