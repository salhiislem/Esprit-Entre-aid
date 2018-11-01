/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopPI.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Hajbi
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private TextField tf_utilisateur;
    @FXML
    private TextField tf_mdp;
    @FXML
    private Button btn_login;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void login(MouseEvent event) throws IOException {
       
        if((tf_utilisateur.getText().equalsIgnoreCase("admin"))&&(tf_mdp.getText().equalsIgnoreCase("admin")))
        {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("./AcceuilFXML.fxml"));
            
                     Parent root;
                   try {
                       root = loader.load();
                       
                       btn_login.getScene().setRoot(root);
                         
                   } catch (IOException ex) {
                       Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
        }
        else if((tf_utilisateur.getText().equalsIgnoreCase("etudiant"))&&(tf_mdp.getText().equalsIgnoreCase("123")))  
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("./Acceuil1FXML.fxml"));
            
                     Parent root;
                   try {
                       root = loader.load();
                       
                       btn_login.getScene().setRoot(root);
                         
                   } catch (IOException ex) {
                       Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
    }
            else
            {
                Notifications notificationBuilder2 = Notifications.create()
                                    .title("échec  de login")
                                    .text("verifier vos coordonnées")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                            notificationBuilder2.show();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("./LoginFXML.fxml"));
            
                     Parent root;
                   try {
                       root = loader.load();
                       
                       btn_login.getScene().setRoot(root);
                         
                   } catch (IOException ex) {
                       Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
            }
}
}
