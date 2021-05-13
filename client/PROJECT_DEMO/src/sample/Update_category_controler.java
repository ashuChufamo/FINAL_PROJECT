package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Update_category_controler implements Initializable,collection_2 {

    @FXML
    private TextField category_name;

    @FXML
    private DatePicker datee;

    @FXML
    private TextArea descriptionn;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.view();

    }
    public void view (){
        category_name.setText(catagory_sheet.get(0).getName());
        descriptionn.setText(catagory_sheet.get(0).getDescriiption());
        datee.setPromptText(catagory_sheet.get(0).getDate().toString());

    }

    public void submitButtonClicked(ActionEvent actionEvent) {
    }
}
