package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

public class stock_user {





        private final StringProperty Item_id;
        private final StringProperty Name;
        private final StringProperty description;
        private final StringProperty owner;
        private final StringProperty brand;
        private final java.util.Date date;
        private final StringProperty category;
        private final StringProperty added_by;

    public String getItem_id() {
        return Item_id.get();
    }

    public StringProperty item_idProperty() {
        return Item_id;
    }

    public String getOwner() {
        return owner.get();
    }

    public StringProperty ownerProperty() {
        return owner;
    }


        public stock_user(String item_id,String name,String brand,String category,Date date,String added_by, String owner, String description ) {
            this.Name = new SimpleStringProperty(name);
            this.Item_id = new  SimpleStringProperty(item_id);
            this.description =new  SimpleStringProperty(description);


            this.owner =  new SimpleStringProperty(owner);
            this.brand =  new SimpleStringProperty(brand);

            this.category=new SimpleStringProperty(category);
            this.date = date;
            this.added_by =new SimpleStringProperty(added_by);

            //this.description = description;
        }




    public String getName() {
            return Name.get();
        }











        public String gebrand() {
            return brand.get();
        }
        public String getcategory() {
            return category.get();
        }

        public long getDate(){
            return date.getTime();
        }
        public String getDescription(){
        return description.get();
        }



    }


