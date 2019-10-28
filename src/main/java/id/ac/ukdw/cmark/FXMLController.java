package id.ac.ukdw.cmark;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
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

public class FXMLController implements Initializable {
    
    @FXML
    private TextField txtUser;
    
    @FXML
    private PasswordField txtPass;
    
    @FXML
    private Label lblLabel;
    
    @FXML
    private Button regis;
    
    @FXML
    public void handleButtonAction(ActionEvent event) throws SQLException{
       Connection connection = sqliteConnect.ConncrDB();
       Statement statement;
       statement = connection.createStatement();
       System.out.println("connect db berhasil");
       String username = txtUser.getText();
       String password = txtPass.getText();
       String query = "SELECT * from daftar where username='"+username+"'and password='"+password+"'";
       ResultSet rs = statement.executeQuery(query);
           if(rs.next()){
                lblLabel.setText("berhasil cok");
            }else{
                lblLabel.setText("gagal cok!");
            }  
    }
    
    @FXML
    public void handleSignupAction(ActionEvent event) throws SQLException, IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/register.fxml"));
        Parent Main = loader.load();
        Scene scene = new Scene(Main);
        Stage Primarystage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Primarystage.setResizable(false);
        Primarystage.setScene(scene);
        Primarystage.show();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
