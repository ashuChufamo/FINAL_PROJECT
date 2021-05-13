package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Controller {
    ActionEvent event;


    private AnchorPane rootpane;

    public void loginbbuttonclicked() throws IOException {
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
        //ActionEvent evet=new ActionEvent();
        Stage primaryStage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Store_keeper home.fxml"));
        Scene innerscene=new Scene(root,300,275);
        innerscene.getStylesheets().add(getClass().getResource("store_keeper.css").toExternalForm());
        //primaryStage=(Stage) ((Node) evet.getSource()).getScene().getWindow();
        primaryStage.setTitle("store_keeper_home");
        primaryStage.setScene(innerscene);
        primaryStage.show();


    }
    public void changescenetoadmin(){

    }

//    public void changescene_store_keeper_home() throws IOException {
//        Stage newstage = new Stage();
//
//           // AnchorPane page = (AnchorPane) FXMLLoader.load((Class.getResource("g.fxml")));
//            Scene scene = new Scene(page);
//            newstage.setScene((scene));
//            newstage.show();




    public void changescenetouser(){}

    public void changescene_store_keeper_LOGIN(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("STORE_KEEPER_LOGIN.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }




    public void gotohome(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("HOME.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }



    public void addbrand(ActionEvent event) throws IOException {
        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("addbrand.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }
    public void addsupplier() throws IOException {
        ActionEvent event = null;
        System.out.println("you have clicked me");
        Parent inner = FXMLLoader.load(getClass().getResource("addsupplier.fxml"));
        Scene innerscene = new Scene(inner);
        Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
        innerStage.setScene(innerscene);
        innerStage.show();


    }


}
