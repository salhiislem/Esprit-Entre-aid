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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author esprit
 */
public class AfficherController implements Initializable {

    @FXML
    private TableView<covoitu> tab;
    @FXML
    private TableColumn<covoitu, String> dep;
    @FXML
    private TableColumn<covoitu, String> ar;
    @FXML
    private TableColumn<covoitu, String> tem;
    @FXML
    private TableColumn<covoitu, Integer> nb;
    @FXML
    private TableColumn<covoitu, Integer> num;
    @FXML
    private TableColumn<covoitu, Integer> ty;
    @FXML
    private TableColumn<covoitu, Integer> p;
    @FXML
    private TableColumn<covoitu, Button> reserv;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                  covservice ps=new covservice();
        try {
            ArrayList<covoitu> covoiturage =(ArrayList<covoitu>) ps.getAllcov();
            ObservableList obs =FXCollections.observableArrayList(covoiturage);
            tab.setItems(obs);
            dep.setCellValueFactory(new PropertyValueFactory<>("depart"));
            ar.setCellValueFactory(new PropertyValueFactory<>("arrive"));
            tem.setCellValueFactory(new PropertyValueFactory<>("temps"));
            nb.setCellValueFactory(new PropertyValueFactory<>("nbr"));
            num.setCellValueFactory(new PropertyValueFactory<>("numero"));
            ty.setCellValueFactory(new PropertyValueFactory<>("type"));
            p.setCellValueFactory(new PropertyValueFactory<>("prix"));
             reserv.setCellValueFactory(new PropertyValueFactory<>("button"));
            
        } catch (SQLException ex) {
            Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
