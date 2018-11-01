/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author esprit
 */
public class CovFXMLController implements Initializable {

    @FXML
    private BorderPane bdr;
    @FXML
    private Button Ajout;
    @FXML
    private Button Modifier;
    @FXML
    private Button Afficher;
    @FXML
    private Button Supprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void ajouter(MouseEvent event) throws IOException {
        Parent p=FXMLLoader.load(getClass().getResource("./ajouter.fxml"));
        bdr.setCenter(p);
    }

    @FXML
    private void modifier(MouseEvent event) throws IOException {
        Parent p=FXMLLoader.load(getClass().getResource("./modifier.fxml"));
        bdr.setCenter(p);
    }

    @FXML
    private void afficher(MouseEvent event) throws IOException {
        Parent p=FXMLLoader.load(getClass().getResource("./afficher.fxml"));
        bdr.setCenter(p);
    }

    @FXML
    private void supprimer(MouseEvent event) throws IOException {
        Parent p=FXMLLoader.load(getClass().getResource("./supprimer.fxml"));
        bdr.setCenter(p);
    }
    
    
}
