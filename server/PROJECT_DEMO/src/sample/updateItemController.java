package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class updateItemController implements Initializable,collection_2
{
    @FXML
    private TextField up_itemName;

    @FXML
    private TextField up_itemCategory;

    @FXML
    private TextArea up_itemDescribtion;

    @FXML
    private DatePicker up_Item_date;
    @FXML
    private TextField up_item_brand;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.upRun();
    }
    public void upRun(){
        up_itemName.setText(updateStocks.get(0).getName());
        up_itemCategory.setText(updateStocks.get(0).getcategory());
        up_Item_date.setPromptText(updateStocks.get(0).getDate()+"");
        up_item_brand.setText(updateStocks.get(0).gebrand());
        up_itemDescribtion.setText(updateStocks.get(0).getDescription());
    }


}
