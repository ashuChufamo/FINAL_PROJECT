package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class User_app_controller implements Initializable {
    @FXML
    private TableView<?> sttabkview;

    @FXML
    private TableColumn<?, ?> Stname;

    @FXML
    private TableColumn<?, ?> stbrand;

    @FXML
    private TableColumn<?, ?> stcategory;

    @FXML
    private Button user_home_buttn;

    @FXML
    private Button user_ItemsButtn;

    @FXML
    private Button user_req_butn;

    @FXML
    private Button user_comp_butn;

    @FXML
    private StackPane user_home_stack;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    @FXML
    public void homeOnAction(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("userItemslist.fxml").openStream());
        //Parent root= FXMLLoader.load(getClass().getResource("store_keeper.fxml"));
        //homepane.setCenter(root);
        BorderPane bp = fXMLLoader.getRoot();
        bp.setMaxSize(2500, 700);
        bp.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        user_home_stack.getChildren().clear();
        user_home_stack.getChildren().add(bp);
    }
    @FXML
    public void complainBtnOnAction(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("complain.fxml").openStream());
        //Parent root= FXMLLoader.load(getClass().getResource("store_keeper.fxml"));
        //homepane.setCenter(root);
        BorderPane bp = fXMLLoader.getRoot();
        bp.setMaxSize(2500, 700);
        bp.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        user_home_stack.getChildren().clear();
        user_home_stack.getChildren().add(bp);

    }
    @FXML
    public void requestBtnOnAction(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("request_for_home_item.fxml").openStream());
        //Parent root= FXMLLoader.load(getClass().getResource("store_keeper.fxml"));
        //homepane.setCenter(root);
        BorderPane bp = fXMLLoader.getRoot();
        bp.setMaxSize(2500, 700);
        bp.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        user_home_stack.getChildren().clear();
        user_home_stack.getChildren().add(bp);

    }
    public void logout(ActionEvent event) throws IOException {

        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("LOGIN.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }



}
