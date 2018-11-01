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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;

/**
 * FXML Controller class
 *
 * @author esprit
 */
public class SupprimerController implements Initializable {

    @FXML
  private TableView<covoitu> tabs;
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
    private Button supprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           covservice ps=new covservice();
        try {
            ArrayList<covoitu> covoiturage =(ArrayList<covoitu>) ps.getAllcov();
            ObservableList obs =FXCollections.observableArrayList(covoiturage);
            tabs.setItems(obs);
            dep.setCellValueFactory(new PropertyValueFactory<>("depart"));
            ar.setCellValueFactory(new PropertyValueFactory<>("arrive"));
            tem.setCellValueFactory(new PropertyValueFactory<>("temps"));
            nb.setCellValueFactory(new PropertyValueFactory<>("nbr"));
            num.setCellValueFactory(new PropertyValueFactory<>("numero"));
            ty.setCellValueFactory(new PropertyValueFactory<>("type"));
            p.setCellValueFactory(new PropertyValueFactory<>("prix"));
            tabs.setEditable(true);
            dep.setCellFactory(TextFieldTableCell.forTableColumn());
            ar.setCellFactory(TextFieldTableCell.forTableColumn());
            tem.setCellFactory(TextFieldTableCell.forTableColumn());
            nb.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            num.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            ty.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            p.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
         
        } catch (SQLException ex) {
            Logger.getLogger(AfficherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

//    @FXML
//    private void supprimer(MouseEvent event) throws SQLException{
//
//}  
    @FXML
    private void supprimer(MouseEvent event) throws SQLException {
        
       covservice ps =new covservice();
                 covoitu c=(covoitu) tabs.getSelectionModel().getSelectedItem();
                 if (c!=null){
               
                   ps.SupprimerId(c.getId());
                    //ps.Supprimernum(c.getNumero());
                     tabs.getItems().remove(c);}
                    
                     }
        
    
    @FXML
    private void changeDepartCellEvent(CellEditEvent editedCell) throws SQLException {
        covoitu c=tabs.getSelectionModel().getSelectedItem();
        covservice cs=new covservice();
        c.setDepart(editedCell.getNewValue().toString());
        cs.ModifierC(c, c.getId());
    }

    @FXML
    private void changeArriveCellEvent(CellEditEvent editedCell) throws SQLException{
        covoitu c=tabs.getSelectionModel().getSelectedItem();
        covservice cs=new covservice();
        c.setArrive(editedCell.getNewValue().toString());
        cs.ModifierC(c, c.getId());
    }

    @FXML
    private void changeTemsCellEvent(CellEditEvent editedCell) throws SQLException{
        covoitu c=tabs.getSelectionModel().getSelectedItem();
        covservice cs=new covservice();
        c.setTemps(editedCell.getNewValue().toString());
        cs.ModifierC(c, c.getId());
    }

    @FXML
    private void changeNombreCellEvent(CellEditEvent editedCell) throws SQLException {
        covoitu c=tabs.getSelectionModel().getSelectedItem();
        covservice cs=new covservice();
        c.setNbr(Integer.parseInt(editedCell.getNewValue().toString()));
        cs.ModifierC(c, c.getId());
    }

    @FXML
    private void changeNumeroCellEvent(CellEditEvent editedCell) throws SQLException {
        covoitu c=tabs.getSelectionModel().getSelectedItem();
        covservice cs=new covservice();
        c.setNumero(Integer.parseInt(editedCell.getNewValue().toString()));
        cs.ModifierC(c, c.getId());
    }

    @FXML
    private void changeTypeCellEvent(CellEditEvent editedCell) throws SQLException{
        covoitu c=tabs.getSelectionModel().getSelectedItem();
        covservice cs=new covservice();
        c.setType(Integer.parseInt(editedCell.getNewValue().toString()));
        cs.ModifierC(c, c.getId());
    }

    @FXML
    private void changePrixCellEvent(CellEditEvent editedCell) throws SQLException {
        covoitu c=tabs.getSelectionModel().getSelectedItem();
        covservice cs=new covservice();
        c.setPrix(Integer.parseInt(editedCell.getNewValue().toString()));
        cs.ModifierC(c, c.getId());
    }
    
}
