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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.C;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import workshopdbPI.services.SendingEmail;

/**
 * FXML Controller class
 *
 * @author Hajbi
 */
public class AcceuilFXMLController implements Initializable {

    @FXML
    private Button btn_D;
    @FXML
    private Button btn_P;
    @FXML
    private Font x1;
    @FXML
    private Button email;
    @FXML
    private Button btn_quitte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Image image = new Image("/Icons/communication.jpg");
//      ImageView iv = new ImageView();
//      imgA.setImage(image);
    }    

    @FXML
    private void discussion(MouseEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("./DiscussionFXML.fxml"));
                   Parent root;
                   try {
                       root = loader.load();
                       
                       btn_D.getScene().setRoot(root);
                         
                   } catch (IOException ex) {
                       Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }}

    @FXML
    private void planning(MouseEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("./PlanningFXML.fxml"));
                   Parent root;
                   try {
                       root = loader.load();
                       
                       btn_P.getScene().setRoot(root);
                         
                   } catch (IOException ex) {
                       Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}

    @FXML
    private void mail(MouseEvent event) {
        
        SendingEmail sm= new SendingEmail();
        sm.envoyer();
        
    }

    @FXML
    private void quitter1(MouseEvent event) {
        
          
         FXMLLoader loader = new FXMLLoader(getClass().getResource("./LoginFXML.fxml"));
                   Parent root;
                   try {
                       root = loader.load();
                       
                       btn_quitte.getScene().setRoot(root);
                         
                   } catch (IOException ex) {
                       Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
