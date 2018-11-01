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
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import workshopdbPI.entities.Discussion;
import workshopdbPI.entities.Message;
import workshopdbPI.services.DiscussionService;
import workshopdbPI.services.MessageService;

/**
 * FXML Controller class
 *
 * @author Hajbi
 */
public class DiscussionFXMLController implements Initializable {

    @FXML
    private TableView<Discussion> Tab_Disc;
    @FXML
    private TableColumn<Discussion, String> tf_nom;
    @FXML
    private TableColumn<Discussion, String> tf_sujet;
    @FXML
    private Button btn_ajoutD;
    @FXML
    private Button btn_supp;
    @FXML
    private Button btn_part;
    @FXML
    private TextField tf_nomD;
    @FXML
    private TextField tf_sujetD;
    @FXML
    private TableView<Message> tab_msg;
    @FXML
    private Button btn_envoi;
    @FXML
    private TextField tf_msg;
    @FXML
    private TableColumn<Message,String> msg;
    @FXML
    private Button btn_quitte;
    @FXML
    private Button btn_rtr;
    @FXML
    private Button btn_suppM;

    /**
     * Initializes the controller class.
     */
    @FXML
       public void changeNomCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException{
        Discussion discussionselected = Tab_Disc.getSelectionModel().getSelectedItem();
        DiscussionService ds= new DiscussionService();
        discussionselected.setNom(edditedCell.getNewValue().toString());
        ds.modifierDiscussion(discussionselected.getIdD(), discussionselected);
        
    }
    @FXML
       public void changeSujetCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException{
        Discussion productselected = Tab_Disc.getSelectionModel().getSelectedItem();
        DiscussionService ds= new DiscussionService();
        productselected.setSujet(edditedCell.getNewValue().toString());
        ds.modifierDiscussion(productselected.getIdD(), productselected);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         DiscussionService ds = new DiscussionService();
        try {
            ArrayList<Discussion> discussions = (ArrayList<Discussion>) ds.getAllDiscussions();
            ObservableList obs= FXCollections.observableArrayList(discussions);
            Tab_Disc.setItems(obs);
            tf_nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            tf_sujet.setCellValueFactory(new PropertyValueFactory<>("Sujet"));   
            
            Tab_Disc.setEditable(true);
            tf_nom.setCellFactory(TextFieldTableCell.forTableColumn());
            tf_sujet.setCellFactory(TextFieldTableCell.forTableColumn());
        } catch (SQLException ex) {
            Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void ajoutD(MouseEvent event) { 
      Discussion d = new Discussion(tf_nomD.getText(),tf_sujetD.getText());
               DiscussionService ds = new DiscussionService();
               
              
       try {  
          
         //  if ((validatelastname())&&(validatefirstname()))
                
             ds.ajouterDiscussion(d);
                   FXMLLoader loader = new FXMLLoader(getClass().getResource("./DiscussionFXML.fxml"));
                   Parent root;
                   try {
                       root = loader.load();
                       
                       btn_ajoutD.getScene().setRoot(root);
                        Notifications notificationBuilder2 = Notifications.create()
                                    .title("succés d'ajout")
                                    .text("discussion ajouté ")
                               
                                    .hideAfter(Duration.seconds(10))
                                    .position(Pos.TOP_RIGHT);
                            notificationBuilder2.show();   
                   
                   } catch (IOException ex) {
                       Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                   }   
               } catch (SQLException ex) {
                   Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
               }
                
              
    }


    @FXML
    private void supprimer(MouseEvent event) throws SQLException { 
        
        DiscussionService ds = new DiscussionService();
        Discussion productselected = Tab_Disc.getSelectionModel().getSelectedItem();
        ds.supprimerDiscussion(productselected.getIdD());
        ArrayList<Discussion> discussions = (ArrayList<Discussion>) ds.getAllDiscussions();
            ObservableList obs= FXCollections.observableArrayList(discussions);
            Tab_Disc.setItems(obs);
            tf_nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            tf_sujet.setCellValueFactory(new PropertyValueFactory<>("Sujet"));
        
    }

    @FXML
    private void participer(MouseEvent event) {   
        Discussion productselected = Tab_Disc.getSelectionModel().getSelectedItem();
         MessageService ms = new MessageService();
        try {
            ArrayList<Message> messages = (ArrayList<Message>) ms.getAllMessagesById(productselected.getIdD());
            ObservableList obs= FXCollections.observableArrayList(messages);
            tab_msg.setItems(obs);
            msg.setCellValueFactory(new PropertyValueFactory<>("Msg"));
            tab_msg.setEditable(true);
            msg.setCellFactory(TextFieldTableCell.forTableColumn());
        } catch (SQLException ex) {
           // Logger.getLogger(MessageFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        //Inscription i = new Inscription(tf_nomE.getText(),tf_prenomE.getText());
        
//               InscriptionService is = new InscriptionService();
//               
//              
//     
//                   //is.ajouterInscription(i);
//                   FXMLLoader loader = new FXMLLoader(getClass().getResource("./MessageFXML.fxml"));
//                   Parent root;
//                   try {
//                       root = loader.load();
//                       //btn_inscrire.getScene().setRoot(root);
//                       
//                   } catch (IOException ex) {
//                       Logger.getLogger(InscriptionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
//                   }   
//             
    }

//  private boolean validatefirstname(){
//        firstname_er_label.setText("");
//        Pattern pattern=Pattern.compile("[a-zA-Z]+");
//        Matcher matcher=pattern.matcher(tf_sujetD.getText());
//        if (tf_sujetD.getText().isEmpty()){
//            firstname_er_label.setText("(*)champ requis");
//            return false;
//        }
//        else if (matcher.find() && matcher.group().equals(tf_sujetD.getText())){
//            return true;
//        }else {
//            firstname_er_label.setText("(*)Enter des lettres");
//            return false;
//        }  
//    
//}
//    private boolean validatelastname(){
//       lastname_er_label.setText("");
//        Pattern pattern=Pattern.compile("[a-zA-Z]+");
//        Matcher matcher=pattern.matcher(tf_nomD.getText());
//        if (tf_nomD.getText().isEmpty()){
//           lastname_er_label.setText("(*)champ requis");
//            return false;
//        }
//        else if (matcher.find() && matcher.group().equals(tf_nomD.getText())){
//            return true;
//        }else {
//            lastname_er_label.setText("(*)Enter des lettres");
//            return false;
//        }  
//}

    @FXML
    private void envoyer(MouseEvent event) throws IOException, SQLException {
        
         if(tf_msg.getText().isEmpty())
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
        Discussion productselected = Tab_Disc.getSelectionModel().getSelectedItem();
         Message m = new Message(tf_msg.getText());
               MessageService ps = new MessageService();

                   ps.ajouterMessage(m,productselected.getIdD());
                   FXMLLoader loader = new FXMLLoader(getClass().getResource("./DiscussionFXML.fxml"));
                   Parent root;           
                      root = loader.load();
                      btn_envoi.getScene().setRoot(root);
                      
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
    private void retour(MouseEvent event) {

         FXMLLoader loader = new FXMLLoader(getClass().getResource("./AcceuilFXML.fxml"));
                   Parent root;
                   try {
                       root = loader.load();    
                       btn_rtr.getScene().setRoot(root);
                   } catch (IOException ex) {
                       Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void suppM(MouseEvent event) throws SQLException {
        
          MessageService is = new MessageService();
       Message productselected = tab_msg.getSelectionModel().getSelectedItem();
       
       
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
       tab_msg.setItems(obs);
       msg.setCellValueFactory(new PropertyValueFactory<>("Msg"));
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