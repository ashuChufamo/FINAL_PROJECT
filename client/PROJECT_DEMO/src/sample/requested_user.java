package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

public class requested_user {
    private final StringProperty itemame;
    private final StringProperty user_name;
    private final StringProperty category;

    private final StringProperty brand;
    private final IntegerProperty quantity;

    private final Date requested_date;
    private final StringProperty Aprroved;
    private final StringProperty Approved_by;
    private final Date Approved_date;

    public requested_user(String itemame, String user_name,Integer quantity,String  category,String brand,Date requested_date, String approved_by,Date approved_date,String aprroved) {

        this.user_name = new SimpleStringProperty(user_name);
        this.category =  new SimpleStringProperty(category);
        this.itemame = new SimpleStringProperty(itemame);
        this.brand = new SimpleStringProperty(brand);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.requested_date = requested_date;
        this.Aprroved =  new SimpleStringProperty(aprroved);
        this.Approved_by =  new SimpleStringProperty(approved_by);
        this.Approved_date = approved_date;

    }

    public String getUser_name() {
        return user_name.get();
    }

    public StringProperty user_nameProperty() {
        return user_name;
    }

    public String getCategory() {
        return category.get();
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public String getItemame() {
        return itemame.get();
    }

    public StringProperty itemameProperty() {
        return itemame;
    }

    public String getBrand() {
        return brand.get();
    }

    public StringProperty brandProperty() {
        return brand;
    }

    public int getQuantity() {
        return quantity.get();
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public Date getRequested_date() {
        return requested_date;
    }

    public String getAprroved() {
        return Aprroved.get();
    }

    public StringProperty aprrovedProperty() {
        return Aprroved;
    }

    public String getApproved_by() {
        return Approved_by.get();
    }

    public StringProperty approved_byProperty() {
        return Approved_by;
    }

    public Date getApproved_date() {
        return Approved_date;
    }
}