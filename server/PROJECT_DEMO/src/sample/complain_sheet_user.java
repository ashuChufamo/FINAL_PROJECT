package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

public class complain_sheet_user {
    private final StringProperty user_name;
    private final StringProperty complain;
    private final StringProperty replay;
    private final Date date;
    private final Date date1;
    public complain_sheet_user(String user_name, String complain, String replay,Date date, Date date1) {

        this.user_name = new SimpleStringProperty(user_name);
        this.complain = new SimpleStringProperty(complain);
        this.replay = new SimpleStringProperty(replay);
        this.date1 = date1;
        this.date = date;
}

    public String getUser_name() {
        return user_name.get();
    }

    public StringProperty user_nameProperty() {
        return user_name;
    }

    public String getComplain() {
        return complain.get();
    }

    public StringProperty complainProperty() {
        return complain;
    }

    public String getReplay() {
        return replay.get();
    }

    public StringProperty replayProperty() {
        return replay;
    }

    public Date getDate() {
        return date;
    }

    public Date getDate1() {
        return date1;
    }
}
