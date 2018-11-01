/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopPI.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import workshopdbPI.entities.Inscription;
import workshopdbPI.entities.Planning;
import workshopdbPI.services.InscriptionService;
import workshopdbPI.services.PlanningService;

/**
 * FXML Controller class
 *
 * @author Hajbi
 */
public class Planning1FXMLController implements Initializable {

    @FXML
    private TableView<Planning> tab_plan1;
    @FXML
    private TableColumn<Planning, String> nom1;
    @FXML
    private TableColumn<Planning, String> sujet1;
    @FXML
    private TableColumn<Planning, String> enseignant1;
    @FXML
    private TableColumn<Planning, String> maximum1;
    @FXML
    private TableColumn<Planning, String> salle1;
    @FXML
    private TableColumn<Planning, Date> date1;
    @FXML
    private TableColumn<Planning, String> heure1;
    @FXML
    private Button btn_inscrit1;
    @FXML
    private TableView<Inscription> tab_inscription1;
    @FXML
    private Button btn_inscrire1;
    @FXML
    private TextField tf_nomE1;
    @FXML
    private TextField tf_prenomE1;
    @FXML
    private Button btn_desinscrire1;
    @FXML
    private TableColumn<Inscription, String> nomE1;
    @FXML
    private TableColumn<Inscription, String> prenomE1;
    @FXML
    private Button btn_rtr;
    @FXML
    private Button btn_quitter;

    /**
     * Initializes the controller class.
     */
     @FXML
       public void changeNomCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException{
        Inscription productselected = (Inscription) tab_inscription1.getSelectionModel().getSelectedItem();
        InscriptionService is= new InscriptionService();
        productselected.setNom_etudiant(edditedCell.getNewValue().toString());
        is.modifierInscription(productselected.getIdI(), productselected);  
       }
    
       @FXML
       public void changePrenomCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException{
        Inscription productselected = (Inscription) tab_inscription1.getSelectionModel().getSelectedItem();
        InscriptionService is= new InscriptionService();
        productselected.setPrenom_etudiant(edditedCell.getNewValue().toString());
        is.modifierInscription(productselected.getIdI(), productselected);
       }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         PlanningService ps = new PlanningService();
        try {
            ArrayList<Planning> plannings = (ArrayList<Planning>) ps.getAllPlannings();
            ObservableList obs= FXCollections.observableArrayList(plannings);
            tab_plan1.setItems(obs);
            nom1.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            sujet1.setCellValueFactory(new PropertyValueFactory<>("Sujet"));
            enseignant1.setCellValueFactory(new PropertyValueFactory<>("Enseignant"));
            maximum1.setCellValueFactory(new PropertyValueFactory<>("Maximum"));
            salle1.setCellValueFactory(new PropertyValueFactory<>("Salle"));
            date1.setCellValueFactory(new PropertyValueFactory<>("Date"));
            heure1.setCellValueFactory(new PropertyValueFactory<>("Heure"));
                  
        } catch (SQLException ex) {
            Logger.getLogger(PlanningFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void inscrivez1(MouseEvent event) throws SQLException {
         Planning productselected = tab_plan1.getSelectionModel().getSelectedItem();
           InscriptionService is = new InscriptionService();
     
          ArrayList<Inscription> inscriptions = (ArrayList<Inscription>) is.getAllInscriptionsById(productselected.getIdP());
          ObservableList obs= FXCollections.observableArrayList(inscriptions);
          tab_inscription1.setItems(obs);
          nomE1.setCellValueFactory(new PropertyValueFactory<>("Nom_etudiant"));
          prenomE1.setCellValueFactory(new PropertyValueFactory<>("Prenom_etudiant"));
//          tab_inscription1.setEditable(true);
//          nomE1.setCellFactory(TextFieldTableCell.forTableColumn());
//          prenomE1.setCellFactory(TextFieldTableCell.forTableColumn());
      }
    


    @FXML
    private void inscrire1(MouseEvent event) throws SQLException, IOException {
        Planning productselected = tab_plan1.getSelectionModel().getSelectedItem();
     Inscription i = new Inscription(tf_nomE1.getText(),tf_prenomE1.getText());
               InscriptionService is = new InscriptionService();
                 if(productselected==null)
                    {
                            Notifications notificationBuilder2 = Notifications.create()
                                    .title("échec  d'ajout")
                                    .text("veuillez selecter un planning")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                                notificationBuilder2.show();
                     }
                     else
                 {
                     
                     if(tf_nomE1.getText().isEmpty()||tf_prenomE1.getText().isEmpty())
                         {
              Notifications notificationBuilder2 = Notifications.create()
                                    .title("échec  d'ajout")
                                    .text("veulliez remplir tous les champs")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                             notificationBuilder2.show();
                             }
                      else if (tf_nomE1.getText().matches("[a-zA-Z]+")&&tf_prenomE1.getText().matches("[a-zA-Z]+"))
                     {    
                   is.ajouterInscription(i,productselected.getIdP(),productselected.getMaximum());
                   FXMLLoader loader = new FXMLLoader(getClass().getResource("./Planning1FXML.fxml"));
                   Parent root;
                       root = loader.load();
                       btn_inscrire1.getScene().setRoot(root);
               Notifications notificationBuilder2 = Notifications.create()
                                    .title("succés d'ajout")
                                    .text("vous êtes inscrit")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                             notificationBuilder2.show();
                              }
         else
        {
        Notifications notificationBuilder2 = Notifications.create()
                                    .title("échec  d'ajout")
                                    .text("verifier vos champs")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                             notificationBuilder2.show();
        } 

    }
    }

    @FXML
    private void desinscrire1(MouseEvent event) throws SQLException {
              
        Inscription productselected = tab_inscription1.getSelectionModel().getSelectedItem();
        InscriptionService is = new InscriptionService();
        
        if(productselected==null)
        {
              Notifications notificationBuilder2 = Notifications.create()
                                    .title("échec  de suppression")
                                    .text("veuillez selecter un etudiant")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                                notificationBuilder2.show();
        }
        else
        {
       is.supprimerInscription(productselected.getIdE(),productselected.getIdp());
       ArrayList<Inscription> inscriptions = (ArrayList<Inscription>) is.getAllInscriptionsById(productselected.getIdI());
       ObservableList obs = FXCollections.observableArrayList(inscriptions);
       tab_inscription1.setItems(obs);
       nomE1.setCellValueFactory(new PropertyValueFactory<>("Nom_etudiant"));
       prenomE1.setCellValueFactory(new PropertyValueFactory<>("Prenom_etudiant"));
       
       Notifications notificationBuilder2 = Notifications.create()
                                    .title("succés de désinscription")
                                    .text("vous êtes désinscrit")
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
                       
                       btn_quitter.getScene().setRoot(root);
                         
                   } catch (IOException ex) {
                       Logger.getLogger(DiscussionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    }


