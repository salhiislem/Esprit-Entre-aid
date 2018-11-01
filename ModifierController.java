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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author esprit
 */
public class ModifierController implements Initializable {

    @FXML
    private AnchorPane mo;
    @FXML
    private TableColumn<?, ?> dep;
    @FXML
    private TableColumn<?, ?> ar;
    @FXML
    private TableColumn<?, ?> tem;
    @FXML
    private TableColumn<?, ?> nb;
    @FXML
    private TableColumn<?, ?> num;
    @FXML
    private TableColumn<?, ?> ty;
    @FXML
    private TableColumn<?, ?> p;
    private TableColumn<?, ?> reserv;
    @FXML
    private TableView<?> mod;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              covservice ps=new covservice();
        try {
            ArrayList<covoitu> covoiturage =(ArrayList<covoitu>) ps.getAllcov();
            ObservableList obs =FXCollections.observableArrayList(covoiturage);
            mod.setItems(obs);
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
