package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

public class category_class {

    private final StringProperty name;


    private final StringProperty added_by;
    private final Date  date;
    private final StringProperty descriiption;

    public category_class(String name,String added_by,String descriiption,Date date) {

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
