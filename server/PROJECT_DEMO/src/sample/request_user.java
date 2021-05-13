package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

public class request_user {
    private final StringProperty user_name;
    private final StringProperty complain;
    private final StringProperty replay;
    private final Date date;
    private final Date date1;
    public request_user(String user_name, String complain, String replay,Date date, Date date1) {

        this.user_name = new SimpleStringProperty(user_name);
        this.complain = new SimpleStringProperty(complain);
        this.replay = new SimpleStringProperty(replay);
        this.date1 = date1;
        this.date = date;
    }
}
