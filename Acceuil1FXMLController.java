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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Hajbi
 */
public class Acceuil1FXMLController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private Button btn_D1;
    @FXML
    private Button btn_P1;
    @FXML
    private Button Email1;
    @FXML
    private Button btn_quitte1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Planning1(MouseEvent event) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./Planning1FXML.fxml"));
                   Parent root;
                   try {
                       root = loader.load();
                       
                       btn_P1.getScene().setRoot(root);
                         
                   } catch (IOException ex) {
                       Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
    }

    @FXML
    private void discussion1(MouseEvent event) {
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("./Discussion1FXML.fxml"));
                   Parent root;
                   try {
                       root = loader.load();
                       
                       btn_D1.getScene().setRoot(root);
                         
                   } catch (IOException ex) {
                       Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void mail1(MouseEvent event) {
    }

    @FXML
    private void quitter(MouseEvent event) {
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("./LoginFXML.fxml"));
                   Parent root;
                   try {
                       root = loader.load();
                       
                       btn_quitte1.getScene().setRoot(root);
                         
                   } catch (IOException ex) {
                       Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }

    }
    }
    

