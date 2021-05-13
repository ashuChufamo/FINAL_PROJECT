package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import static javafx.application.Application.launch;
import java.lang.Runnable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application  implements Runnable {
//0798
//stock_control c=new stock_control();

    @Override
    public void start(Stage primaryStage) throws Exception {
        //c.brand_combobox();
        Parent root = FXMLLoader.load(getClass().getResource("ASHEE.fxml"));
        primaryStage.setTitle("Store Management System");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1200, 600));
        primaryStage.show();
    }
public Object getMessage(ArrayList message){


        return message;
}
    public void client() throws IOException {

        Socket sock = null;
        sock = new Socket("localhost", 1000);
        InputStreamReader input = null;
        input = new InputStreamReader(sock.getInputStream());
        BufferedReader ir = new BufferedReader(input);
        String message = null;
        message = ir.readLine();
        System.out.println(message);
        }




    @Override
    public void run() {
        try {
            client();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public static void main(String[] args) {


launch(args);
//        Main c = new Main();
//        Thread t = new Thread(c);
//        t.start();
    }
}


