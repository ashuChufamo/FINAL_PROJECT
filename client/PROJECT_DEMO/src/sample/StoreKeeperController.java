package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class StoreKeeperController extends loginClient {
    ActionEvent event;
    @Override
    public void login() {

    }

    @FXML
    private HBox hbox;
    @FXML
    public void changescene_stack(ActionEvent event) throws IOException {
//        Socket sock = null;
//        sock = new Socket("localhost", 121);
//        //InputStreamReader input = null;
//        //input = new InputStreamReader(sock.getInputStream());
//        //BufferedReader ir = new BufferedReader(input);
////        String message = null;
////        message = ir.readLine();
//        //System.out.println(message);
//        ObjectOutputStream data = null;
//        data = new ObjectOutputStream(sock.getOutputStream());
        //data.writeUTF("thised");
        FXMLLoader FXMLLOADER=new FXMLLoader();
        FXMLLOADER.load(getClass().getResource("store_keeper.fxml").openStream());
        BorderPane bd=FXMLLOADER.getRoot();
        bd.setMaxSize(2500,700);
        hbox.getChildren().clear();
        hbox.getChildren().add(bd);
//        System.out.println("you have clicked me");
//        Parent inner = FXMLLoader.load(getClass().getResource("store_keeper.fxml"));
//        Scene innerscene = new Scene(inner);
//        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
//        innerStage.setScene(innerscene);
//        innerStage.show();


    }
    @FXML
    public void changescene_category(ActionEvent event) throws IOException {
//        Socket sock = null;
//        sock = new Socket("localhost", 121);
//        //InputStreamReader input = null;
//        //input = new InputStreamReader(sock.getInputStream());
//        //BufferedReader ir = new BufferedReader(input);
////        String message = null;
////        message = ir.readLine();
//        //System.out.println(message);
//        ObjectOutputStream data = null;
//        data = new ObjectOutputStream(sock.getOutputStream());
//        //data.writeUTF("thised");
        FXMLLoader FXMLLOADER=new FXMLLoader();
        FXMLLOADER.load(getClass().getResource("category.fxml").openStream());
        BorderPane bd=FXMLLOADER.getRoot();
        bd.setMaxSize(2500,700);
        hbox.getChildren().clear();
        hbox.getChildren().add(bd);
//        System.out.println("you have clicked me");
//        Parent inner = FXMLLoader.load(getClass().getResource("category.fxml"));
//        Scene innerscene = new Scene(inner);
//        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
//        innerStage.setScene(innerscene);
//        innerStage.show();


    }
    @FXML
    public void changescene_brand(ActionEvent event) throws IOException {
//        Socket sock = null;
//        sock = new Socket("localhost", 121);
//        //InputStreamReader input = null;
//        //input = new InputStreamReader(sock.getInputStream());
//        //BufferedReader ir = new BufferedReader(input);
////        String message = null;
////        message = ir.readLine();
//        //System.out.println(message);
//        ObjectOutputStream data = null;
//        data = new ObjectOutputStream(sock.getOutputStream());
        //data.writeUTF("thised");
        FXMLLoader FXMLLOADER=new FXMLLoader();
        FXMLLOADER.load(getClass().getResource("brandclass.fxml").openStream());
        BorderPane bd=FXMLLOADER.getRoot();
        bd.setMaxSize(2500,700);
        hbox.getChildren().clear();
        hbox.getChildren().add(bd);
//        System.out.println("you have clicked me");
//        Parent inner = FXMLLoader.load(getClass().getResource("brandclass.fxml"));
//        Scene innerscene = new Scene(inner);
//        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
//        innerStage.setScene(innerscene);
//        innerStage.show();


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
    public void logout(ActionEvent event) throws IOException {

        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("LOGIN.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }
    @FXML
    public void supplierclass(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("SUPPLIERr.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }

    @FXML
    public void complain(ActionEvent event) throws IOException {
        Socket sock = null;
        sock = new Socket("localhost", 121);
        //InputStreamReader input = null;
        //input = new InputStreamReader(sock.getInputStream());
        //BufferedReader ir = new BufferedReader(input);
//        String message = null;
//        message = ir.readLine();
        //System.out.println(message);
        ObjectOutputStream data = null;
        data = new ObjectOutputStream(sock.getOutputStream());
        //data.writeUTF("thised");
        FXMLLoader FXMLLOADER=new FXMLLoader();
        FXMLLOADER.load(getClass().getResource("complain_reciving_sheet.fxml").openStream());
        BorderPane bd=FXMLLOADER.getRoot();
        bd.setMaxSize(2500,700);
        hbox.getChildren().clear();
        hbox.getChildren().add(bd);
//        System.out.println("you have clicked me");
//        Parent inner = FXMLLoader.load(getClass().getResource("complain_reciving_sheet.fxml"));
//        Scene innerscene = new Scene(inner);
//        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
//        innerStage.setScene(innerscene);
//        innerStage.show();
    }
    @FXML
    public void request_item(ActionEvent event) throws IOException {
        Socket sock = null;
        sock = new Socket("localhost", 121);
        //InputStreamReader input = null;
        //input = new InputStreamReader(sock.getInputStream());
        //BufferedReader ir = new BufferedReader(input);
//        String message = null;
//        message = ir.readLine();
        //System.out.println(message);
        ObjectOutputStream data = null;
        data = new ObjectOutputStream(sock.getOutputStream());
        //data.writeUTF("thised");
        FXMLLoader FXMLLOADER=new FXMLLoader();
        FXMLLOADER.load(getClass().getResource("request_item.fxml").openStream());
        BorderPane bd=FXMLLOADER.getRoot();
        bd.setMaxSize(2500,700);
        hbox.getChildren().clear();
        hbox.getChildren().add(bd);
//        System.out.println("you have clicked me");
//        Parent inner = FXMLLoader.load(getClass().getResource("request_item.fxml"));
//        Scene innerscene = new Scene(inner);
//        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
//        innerStage.setScene(innerscene);
//        innerStage.show();
    }
        @FXML
        public void gotohome(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("HOME.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }
    public void updateitem(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("update item.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    } public void takenitem(ActionEvent event) throws IOException {

        FXMLLoader FXMLLOADER=new FXMLLoader();
        FXMLLOADER.load(getClass().getResource("taken item.fxml").openStream());
        BorderPane bd=FXMLLOADER.getRoot();
        bd.setMaxSize(2500,700);
        hbox.getChildren().clear();
        hbox.getChildren().add(bd);
//        System.out.println("you have clicked me");
//        Parent inner = FXMLLoader.load(getClass().getResource("taken item.fxml"));
//        Scene innerscene = new Scene(inner);
//        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
//        innerStage.setScene(innerscene);
//        innerStage.show();


    }
    public void addstock(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addproduct.fxml"));
        Stage primaryStage=new Stage();
        primaryStage.setTitle("add item");

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
//        System.out.println("you have clicked me");
//        Parent inner = FXMLLoader.load(getClass().getResource("addproduct.fxml"));
//        Scene innerscene = new Scene(inner);
//        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
//        innerStage.setScene(innerscene);
//        innerStage.show();


    }
}
