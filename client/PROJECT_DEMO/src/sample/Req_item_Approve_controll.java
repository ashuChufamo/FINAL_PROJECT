package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Req_item_Approve_controll implements Initializable, collection_2 {

    @FXML
    private TextField itemName;

    @FXML
    private TextField ItemQuantity;

    @FXML
    private TextField ItemRequested_by;

    @FXML
    private TextField Item_Approved_By;

    @FXML
    private TextField ItemApproved;

    @FXML
    private DatePicker Item_req_date;

    @FXML
    private TextField ItemBrand;

    @FXML
    private DatePicker ItemApprovedDate;

    @FXML
    private TextField ItemCategory;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.setField();
    }
    public void setField(){
        itemName.setText(request_selItem.get(0).getItemame());
        ItemQuantity.setText(request_selItem.get(0).getQuantity()+"");
        ItemRequested_by.setText("");
        Item_Approved_By.setText(request_selItem.get(0).getApproved_by());
        ItemApproved.setText(request_selItem.get(0).getAprroved());
        Item_req_date.setPromptText(request_selItem.get(0).getApproved_date().toString());
        ItemBrand.setText(request_selItem.get(0).getBrand());
        ItemApprovedDate.setPromptText(request_selItem.get(0).getApproved_date().toString());
        ItemCategory.setText(request_selItem.get(0).getCategory());



    }
}