/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopPI.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import workshopdbPI.entities.Discussion;
import workshopdbPI.entities.Message;
import workshopdbPI.services.DiscussionService;
import workshopdbPI.services.InscriptionService;
import workshopdbPI.services.MessageService;

/**
 * FXML Controller class
 *
 * @author Hajbi
 */
public class Discussion1FXMLController implements Initializable {

    @FXML
    private TableView<Discussion> Tab_Disc1;
    @FXML
    private TableColumn<Discussion, String> tf_nom1;
     @FXML
    private TableColumn<Discussion, String> tf_sujet1;
    @FXML
    private Button btn_part1;
    @FXML
    private TableView<Message> tab_msg1;
    @FXML
    private Button btn_envoi1;
    @FXML
    private TextField tf_msg1;
    @FXML
    private TableColumn<Message,String> msg1;
    @FXML
    private Button btn_rtr;
    @FXML
    private Button btn_quitte;
    @FXML
    private AnchorPane btn_suppM1;
    @FXML
    private Button btn_suppM;

    /**
     * Initializes the controller class.
     */
    
     @FXML
       public void changeMessageCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException{
        Message productselected = tab_msg1.getSelectionModel().getSelectedItem();
        MessageService is= new MessageService();
        productselected.setMsg(edditedCell.getNewValue().toString());
        is.modifierMessage(productselected.getIdM(), productselected);
       }
    
       
        @FXML
       public void changeNomCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException{
        Discussion productselected = Tab_Disc1.getSelectionModel().getSelectedItem();
        DiscussionService is= new DiscussionService();
        productselected.setNom(edditedCell.getNewValue().toString());
        is.modifierDiscussion(productselected.getIdD(), productselected);
       }
       
       
        @FXML
       public void changeSujetCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException{
        Discussion productselected = Tab_Disc1.getSelectionModel().getSelectedItem();
        DiscussionService is= new DiscussionService();
        productselected.setSujet(edditedCell.getNewValue().toString());
        is.modifierDiscussion(productselected.getIdD(), productselected);
       }
       
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          DiscussionService ds = new DiscussionService();
        try {
            ArrayList<Discussion> discussions = (ArrayList<Discussion>) ds.getAllDiscussions();
            ObservableList obs= FXCollections.observableArrayList(discussions);
            Tab_Disc1.setItems(obs);
            tf_nom1.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            tf_sujet1.setCellValueFactory(new PropertyValueFactory<>("Sujet"));   
            Tab_Disc1.setEditable(true);
            tf_nom1.setCellFactory(TextFieldTableCell.forTableColumn());
            tf_sujet1.setCellFactory(TextFieldTableCell.forTableColumn());
            
              } catch (SQLException ex) {
            Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void participer1(MouseEvent event) {
        
        Discussion productselected = Tab_Disc1.getSelectionModel().getSelectedItem();
         MessageService ms = new MessageService();
        try {
            ArrayList<Message> messages = (ArrayList<Message>) ms.getAllMessagesById(productselected.getIdD());
            ObservableList obs= FXCollections.observableArrayList(messages);
            tab_msg1.setItems(obs);
            msg1.setCellValueFactory(new PropertyValueFactory<>("Msg"));
            tab_msg1.setEditable(true);
            msg1.setCellFactory(TextFieldTableCell.forTableColumn());
        } catch (SQLException ex) {
           // Logger.getLogger(MessageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        Notifications notificationBuilder2 = Notifications.create()
//                                    .title("échec  de modifcation")
//                                    .text("veuiller saisir la taille")
//                                    //.graphic(table)
//                                    .hideAfter(Duration.seconds(3))
//                                    .position(Pos.TOP_RIGHT);
//          
    }

    @FXML
    private void envoyer1(MouseEvent event) throws IOException, SQLException {
        
          
         if(tf_msg1.getText().isEmpty())
        {
              Notifications notificationBuilder2 = Notifications.create()
                                    .title("échec  d'ajout")
                                    .text("veulliez remplir tous les champs")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                             notificationBuilder2.show();
        }
else
         {    
        Discussion productselected = Tab_Disc1.getSelectionModel().getSelectedItem();
           Message m = new Message(tf_msg1.getText());
               MessageService ps = new MessageService();
  
                   ps.ajouterMessage(m,productselected.getIdD());
                   FXMLLoader loader = new FXMLLoader(getClass().getResource("./Discussion1FXML.fxml"));
                   Parent root;              
                      root = loader.load();
                      btn_envoi1.getScene().setRoot(root);
                       
                 Notifications notificationBuilder2 = Notifications.create()
                                    .title("succés  d'envoi")
                                    .text("message envoyé")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                             notificationBuilder2.show();
        }
        
    }

    @FXML
    private void retour(MouseEvent event) {
        
           
         FXMLLoader loader = new FXMLLoader(getClass().getResource("./Acceuil1FXML.fxml"));
                   Parent root;
                   try {
                       root = loader.load();
                       
                       btn_rtr.getScene().setRoot(root);
                         
                   } catch (IOException ex) {
                       Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void quitter(MouseEvent event) {
        
           
         FXMLLoader loader = new FXMLLoader(getClass().getResource("./LoginFXML.fxml"));
                   Parent root;
                   try {
                       root = loader.load();
                       
                       btn_quitte.getScene().setRoot(root);
                         
                   } catch (IOException ex) {
                       Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }

    @FXML
    private void suppM1(MouseEvent event) throws SQLException {
          MessageService is = new MessageService();
       Message productselected = tab_msg1.getSelectionModel().getSelectedItem();
       
       
       if(productselected==null)
        {
              Notifications notificationBuilder2 = Notifications.create()
                                    .title("échec  de suppression")
                                    .text("veuillez selecter un message")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                                notificationBuilder2.show();
        }
        else
        {
       
       is.supprimerMessage(productselected.getIdE(),productselected.getIdM());
       ArrayList<Message> messages = (ArrayList<Message>) is.getAllMessagesById(productselected.getIdM());
       ObservableList obs = FXCollections.observableArrayList(messages);
       tab_msg1.setItems(obs);
       msg1.setCellValueFactory(new PropertyValueFactory<>("Msg"));
           Notifications notificationBuilder2 = Notifications.create()
                                    .title("succés  de suppression")
                                    .text("message supprimé")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                                notificationBuilder2.show(); 
    }  
        
    }
}
