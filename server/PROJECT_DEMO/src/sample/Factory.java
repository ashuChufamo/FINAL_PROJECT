package sample;

import java.sql.SQLException;

public class Factory {
    client c;
    public  client switchh(String a) throws SQLException, ClassNotFoundException {
        switch(a){
            case "a":
                c=new add_brand_from_client();
                System.out.println("hello");
                break;
            case "b":
                c=new add_category_from_client();
                break;
            case "c":
                c=new add_product_from_client();
                break;
            case "d":
                c=new add_supplier_from_client();
                break;
            default:
                break;

        }
        c.add(a);
        return c;




        }







        }




