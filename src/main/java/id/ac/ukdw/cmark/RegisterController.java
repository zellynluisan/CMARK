/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.cmark;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class RegisterController implements Initializable {
    
    @FXML
    private TextField user;
    
    @FXML
    private TextField email;
    
    @FXML
    private PasswordField pass;
    
    @FXML
    private PasswordField passConf;
    
    @FXML
    private Label lblLabel;
    
    @FXML
    private Button login;
    
    
    @FXML
    private void handleSignupAction(ActionEvent event) throws SQLException{
       Connection connection = sqliteConnect.ConncrDB();
       Statement statement;
       statement = connection.createStatement();
       System.out.println("connect db berhasil");
       String Username = user.getText();
       String Email = email.getText();
       String Password = pass.getText();
       String PasswordConf = passConf.getText();
       String query = "INSERT INTO daftar ( username, email, password, confpass) VALUES ( '"+Username+"', '"+Email+"', '"+Password+"', '"+PasswordConf+"')";
       boolean b = statement.execute(query);
            if(!b){
                lblLabel.setText("berhasil");
            }else{
                lblLabel.setText("GAGAL!");
            }
            
        
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/Scene.fxml"));
        Parent Main = loader.load();
        Scene scene = new Scene(Main);
        Stage Primarystage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Primarystage.setResizable(false);
        Primarystage.setScene(scene);
        Primarystage.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
}
