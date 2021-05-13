package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class complain_reply_controller implements Initializable,collection_2 {
    @FXML
    private TextField user_name;

    @FXML
    private DatePicker replay_date;

    @FXML
    private DatePicker complainDate;

    @FXML
    private TextArea complain;

    @FXML
    private TextArea replay;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.setAll();
    }
    public void setAll(){
        user_name.setText(complain_sheet_users.get(0).getUser_name());
        complain.setText(complain_sheet_users.get(0).getComplain());
        replay.setText(complain_sheet_users.get(0).getReplay());
        complainDate.setPromptText(complain_sheet_users.get(0).getDate().toString());
        replay_date.setPromptText(complain_sheet_users.get(0).getDate1().toString());

    }
}
