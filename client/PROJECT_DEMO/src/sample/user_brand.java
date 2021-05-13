package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

public class user_brand {

    private final StringProperty name;


    private final StringProperty category;
    private final StringProperty added_by;
    private final Date  date;
    private final StringProperty descriiption;

    public user_brand(String name,  String added_by, Date date, String descriiption,String category) {
        this.category=new SimpleStringProperty(category);
        this.name = new SimpleStringProperty(name);

        this.added_by =  new SimpleStringProperty(added_by);
        this.descriiption=new SimpleStringProperty(descriiption);
        this.date = date;




    }



    public String getName() {
        return name.get();
    }

    public Date getDate() {
        return date;
    }





    public String getAdded_by() {
        return added_by.get();
    }







    public String getDescriiption() {
        return descriiption.get();
    }


}
