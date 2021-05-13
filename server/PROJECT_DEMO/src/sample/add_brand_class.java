package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.connectivity.connectionclass;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;



    public class add_brand_class {
        @FXML
        TextField brand_name;
        @FXML
        TextField added_by;

        @FXML
        DatePicker supplier_date;
        @FXML
        TextArea supplier_description;
        public void to_main(ActionEvent event) throws IOException {
            System.out.println("you have clicked me");
            Parent inner = FXMLLoader.load(getClass().getResource("Store_keeper home.fxml"));
            Scene innerscene = new Scene(inner);
            Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
            innerStage.setScene(innerscene);
            innerStage.show();


        }

        public void back_brand(ActionEvent event) throws IOException {
            System.out.println("you have clicked me");
            Parent inner = FXMLLoader.load(getClass().getResource("brandclass.fxml"));
            Scene innerscene = new Scene(inner);
            Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
            innerStage.setScene(innerscene);
            innerStage.show();


        }
        public void add_brand(ActionEvent actionEvent) {
            System.out.println("thise is the add brand method");
            try {
                System.out.println(brand_name.getText());
                System.out.println(added_by.getText());
                System.out.println(supplier_description.getText());

//            System.out.println(supplier_date.getText());

                LocalDate date=supplier_date.getValue();
//           Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagementsystem", "root", "");

                Statement st = connectionclass.getconnection().createStatement();

                st.execute("insert into brand values('"+brand_name.getText()+"','"+added_by.getText()+"','"+date+"','"+supplier_description.getText()+"')");
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
        public void changescene_brand(ActionEvent event) throws IOException {
            System.out.println("you have clicked me");
            Parent inner = FXMLLoader.load(getClass().getResource("BBrand.fxml"));
            Scene innerscene = new Scene(inner);
            Stage innerStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            innerscene.getStylesheets().add(getClass().getResource("new.css").toExternalForm());
            innerStage.setScene(innerscene);
            innerStage.show();


        }
    }




