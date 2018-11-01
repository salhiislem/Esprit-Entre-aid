/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import covbd.entities.covoitu;
import covbd.services.covservice;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacov.Javacov;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author esprit
 */
public class AjouterController implements Initializable {

    @FXML
    private AnchorPane aj;
    @FXML
    private TextField depart;
    @FXML
    private TextField arrive;
    @FXML
    private TextField temps;
    @FXML
    private TextField nbr;
    @FXML
    private TextField numero;
    @FXML
    private TextField type;
    @FXML
    private TextField prix;
    @FXML
    private Button b_ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void ajouter(MouseEvent event) throws SQLException {
          
covoitu p = new covoitu(depart.getText(),arrive.getText(),temps.getText(),Integer.parseInt(nbr.getText()),Integer.parseInt(numero.getText()),Integer.parseInt(type.getText()),Integer.parseInt(prix.getText()));
       
                    covservice ps=new covservice();
                    ps.ajoutercovcs(p);}
 
    }
    

