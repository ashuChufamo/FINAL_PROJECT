//package sample;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.ComboBox;
//import sample.connectivity.connectionclass;
//
//import java.net.URL;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//
//public class add_product_control implements Initializable{
//    @FXML
//    public ComboBox<String> brand_box;
//    @FXML
//        private sample.connectivity.connectionclass connectionclass;
//        private static  ObservableList<String> list = FXCollections.observableArrayList();
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        add__to_com();
//    }
//    public void add__to_com(){
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
//            for(int i =0;i<list.size();i++){
//                System.out.println(list.get(i));
//                //brand.getItems().add(list.get(i));
//
//
//            }
//
//
//            brand_box.setItems(list);
//            rd.close();
//            rs.close();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
//        System.out.println(list);
//        for (int i =0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
//
//
//
//    }
//}
