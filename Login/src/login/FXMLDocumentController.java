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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class FXMLDocumentController implements Initializable {
    
  
    @FXML
    private AnchorPane pane_login;

    @FXML
    private TextField txt_username;

    @FXML
    private PasswordField txt_password;

   // @FXML
   // private ComboBox<?> type;

    @FXML
    private Button btn_login;

    @FXML
    private AnchorPane pane_signup;

    @FXML
    private TextField txt_username_up;

    @FXML
    private TextField txt_password_up;

    @FXML
    private TextField email_up;

   // @FXML
   // private ComboBox<?> type_up;
    
    @FXML
    private TextField branch_up;
    
    @FXML
    private TextField Id_up;
    
    @FXML
    private TextField phone_up;

    
    
    
   Connection conn = null;
   ResultSet rs = null;
   PreparedStatement pst = null;
    
    public void LoginpaneShow() {
        
        pane_login.setVisible(true);
        pane_signup.setVisible(false);
    }
    
    public void SignuppaneShow() {
        
        pane_login.setVisible(false);
        pane_signup.setVisible(true);
    }
    
  
    
    @FXML
     private void Login (ActionEvent event) throws Exception {
     conn = mysqlconnect.ConnectDb();
     String sql = "Select * from users where username = ? and passward = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            pst.setString(2, txt_password.getText());
            rs = pst.executeQuery();
            
            if(rs.next()) {
               JOptionPane.showMessageDialog(null, "Username And Password is Correct");
             btn_login.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Secondpage.fxml"));
                        
               Stage mainStage = new Stage();
               Scene scene = new Scene(root);
               mainStage.setScene(scene);
               mainStage.show();
                 
                       
            }else
                JOptionPane.showMessageDialog(null, "Invalid Username Or Password");
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
        
    }
  }
     
     
     public void add_users(ActionEvent event) {
          conn = mysqlconnect.ConnectDb();
          String sql = "insert into users (username,password,email,branch,Id,Phone) values(?,?,?,?,?,?)";
          try {
              pst = conn.prepareStatement(sql);
              pst.setString(1, txt_username_up.getText());
              pst.setString(2, txt_password_up.getText());
              pst.setString(3, email_up.getText());
              pst.setString(4, branch_up.getText());
              pst.setString(5, Id_up.getText());
              pst.setString(6, phone_up.getText());
              pst.execute();
              
              JOptionPane.showMessageDialog(null, "Details Saved");
          }catch (Exception e){
              JOptionPane.showMessageDialog(null, e);
     }
     
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
