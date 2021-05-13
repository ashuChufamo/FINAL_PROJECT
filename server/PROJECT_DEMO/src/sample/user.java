package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

public class user {

    private final StringProperty name;
    private final IntegerProperty contact_no;
    private final StringProperty adress;

    private final StringProperty added_by;
    private final Date  date;
    private final StringProperty descriiption;

    public user(String name, int contact_no, String adress, String added_by, Date date, String descriiption) {

        this.name = new SimpleStringProperty(name);
        this.contact_no =  new SimpleIntegerProperty(contact_no);
        this.adress =  new SimpleStringProperty(adress);
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

    public int getContact_no() {
        return contact_no.get();
    }



    public String getAdress() {
        return adress.get();
    }



    public String getAdded_by() {
        return added_by.get();
    }







    public String getDescriiption() {
        return descriiption.get();
    }


}
