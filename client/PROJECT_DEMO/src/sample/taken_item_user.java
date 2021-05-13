package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

public class taken_item_user {

    private final IntegerProperty take_no;
    private final StringProperty item_id;

    public int getTake_no() {
        return take_no.get();
    }

    public IntegerProperty take_noProperty() {
        return take_no;
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    private final StringProperty status;

    private final StringProperty user_name;





    public taken_item_user(Integer take_no,String item_id, String status, String user_name) {
        this.take_no = new SimpleIntegerProperty(take_no);

        this.item_id = new SimpleStringProperty(item_id);
        this.user_name = new SimpleStringProperty(user_name);

        this.status = new SimpleStringProperty(status);


    }

    public String getItem_id() {
        return item_id.get();
    }

    public StringProperty item_idProperty() {
        return item_id;
    }




    public String getUser_name() {
        return user_name.get();
    }

    public StringProperty user_nameProperty() {
        return user_name;
    }










}



