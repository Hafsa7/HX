/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class SecondpageController implements Initializable {

    @FXML
    private Button buyer;

    @FXML
    private Button seller;

    @FXML
    private TextField bookname;

    @FXML
    private TextField authorname;

    @FXML
    private TextField semester;

    @FXML
    private TextField price;

    @FXML
    private TextField studentid;

    @FXML
    private TextField bookid;
 
    @FXML
    private Button button;
    
    @FXML
    private TextField collegeid_buy;
   
    @FXML
    private AnchorPane pane_buyer;
     
    @FXML
    private AnchorPane pane_seller;

    @FXML
    private Button handwritten;

    @FXML
    private Button history;


    @FXML
    private AnchorPane pane_history;

    @FXML
    private AnchorPane pane_handwritten;

        
   Connection conn = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
    
    public void BuyerpaneShow(){
        
        pane_buyer.setVisible(true);
        pane_seller.setVisible(false);
        pane_history.setVisible(false);
        pane_handwritten.setVisible(false);
        
    }
    public void Sellerpaneshow(){
        pane_buyer.setVisible(false);
        pane_seller.setVisible(true);
        pane_history.setVisible(false);
        pane_handwritten.setVisible(false);
        
    }
     public void Historypaneshow(){
        pane_buyer.setVisible(false);
        pane_seller.setVisible(false);
        pane_history.setVisible(true);
        pane_handwritten.setVisible(false);
        
    }
      public void Handwrittenpaneshow(){
        pane_buyer.setVisible(false);
        pane_seller.setVisible(false);
        pane_history.setVisible(false);
        pane_handwritten.setVisible(true);
        
    }
     
      
    
     
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
