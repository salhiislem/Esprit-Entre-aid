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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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
public class PlanningFXMLController implements Initializable {

    @FXML
    private TableView<Planning> tab_plan;
    @FXML
    private TableColumn<Planning, String> nom;
    @FXML
    private TableColumn<Planning, String> sujet;
    @FXML
    private TableColumn<Planning, String> enseignant;
    @FXML
    private TableColumn<Planning, Integer> maximum;
    @FXML
    private TableColumn<Planning, Date> date;
    @FXML
    private Button btn_ajouP;
    @FXML
    private Button btn_suppP;
    @FXML
    private TableColumn<Planning, String> salle;
    @FXML
    private TableColumn<Planning, String> heure;
    @FXML
    private TextField tf_salle;
    @FXML
    private TextField tf_enseignant;
    @FXML
    private TextField tf_sujet;
    @FXML
    private TextField tf_heure;
    @FXML
    private TextField tf_maximum;
    @FXML
    private TableView<Inscription> tab_inscription;
    @FXML
    private TableColumn<Inscription, String> nomE;
    @FXML
    private TableColumn<Inscription, String> prenomE;
    @FXML
    private TextField tf_nomE;
    @FXML
    private TextField tf_prenomE;
    @FXML
    private Button btn_inscrit;
    @FXML
    private Button btn_desinscrire;
    @FXML
    private TextField tf_nom;
    @FXML
    private Button btn_inscrire;
    @FXML
    private Button btn_retour;
    @FXML
    private Button btn_quitter;
    @FXML
    private DatePicker id_date;
    /**
     * Initializes the controller class.
     * @param edditedCell
     * @throws java.sql.SQLException
     */
    
//    @FXML
//       public void changeNomCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException{
//        Inscription productselected = tab_inscription.getSelectionModel().getSelectedItem();
//        InscriptionService is= new InscriptionService();
//        productselected.setNom_etudiant(edditedCell.getNewValue().toString());
//        is.modifierInscription(productselected.getIdE(), productselected);
//       }
//    
//    @FXML
//       public void changePrenomCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException{
//        Inscription productselected = tab_inscription.getSelectionModel().getSelectedItem();
//        InscriptionService is= new InscriptionService();
//        productselected.setPrenom_etudiant(edditedCell.getNewValue().toString());
//        is.modifierInscription(productselected.getIdE(), productselected);
//       }
    
    @FXML
     public void changeEnseignantCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException{
        Planning productselected = tab_plan.getSelectionModel().getSelectedItem();
        PlanningService ps= new PlanningService();
        productselected.setEnseignant(edditedCell.getNewValue().toString());
        ps.modifierPlanning(productselected.getIdP(), productselected);
     }
     
    /**
     * @param edditedCell
     * @throws java.sql.SQLException * @FXML
      public void changeMaximumCellEven(TableColumn.CellEditEvent edditedCell) throws SQLException{
        Planning productselected = tab_plan.getSelectionModel().getSelectedItem();
        PlanningService ds= new PlanningService();
        productselected.setMaximum(edditedCell.getNewValue().(toString()));
        ds.modifierPlanning(productselected.getIdP(), productselected);
      }*/
      
    @FXML
       public void changeSalleCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException{
        Planning productselected = tab_plan.getSelectionModel().getSelectedItem();
        PlanningService ps= new PlanningService();
        productselected.setSalle(edditedCell.getNewValue().toString());
        ps.modifierPlanning(productselected.getIdP(), productselected);
        
       }
       
//    @FXML
//       public void changeDateCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException{
//        Planning productselected = tab_plan.getSelectionModel().getSelectedItem();
//        PlanningService ps= new PlanningService();
//        productselected.setDate(edditedCell.getNewValue().toString());
//        ps.modifierPlanning(productselected.getIdP(), productselected);
//        
//       }
//    
       @FXML
       public void changeHeureCellEvent(TableColumn.CellEditEvent edditedCell) throws SQLException{
        Planning productselected = tab_plan.getSelectionModel().getSelectedItem();
        PlanningService ps= new PlanningService();
        productselected.setHeure(edditedCell.getNewValue().toString());
        ps.modifierPlanning(productselected.getIdP(), productselected);
        
       }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         PlanningService ps = new PlanningService();
        try {
            ArrayList<Planning> plannings = (ArrayList<Planning>) ps.getAllPlannings();
            ObservableList obs= FXCollections.observableArrayList(plannings);
            tab_plan.setItems(obs);
            nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            sujet.setCellValueFactory(new PropertyValueFactory<>("Sujet"));
            enseignant.setCellValueFactory(new PropertyValueFactory<>("Enseignant"));
            maximum.setCellValueFactory(new PropertyValueFactory<>("Maximum"));
            salle.setCellValueFactory(new PropertyValueFactory<>("Salle"));
            date.setCellValueFactory(new PropertyValueFactory<>("Date"));
            heure.setCellValueFactory(new PropertyValueFactory<>("Heure"));
            tab_plan.setEditable(true);
            enseignant.setCellFactory(TextFieldTableCell.forTableColumn());
            salle.setCellFactory(TextFieldTableCell.forTableColumn());
           // date.setCellFactory(TextFieldTableCell.forTableColumn());
            heure.setCellFactory(TextFieldTableCell.forTableColumn());
            
        } catch (SQLException ex) {
            Logger.getLogger(PlanningFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    @FXML
    private void inscrivez(MouseEvent event) {
           Inscription i = null ;
           Planning productselected = tab_plan.getSelectionModel().getSelectedItem();
           InscriptionService is = new InscriptionService();
        try {
          ArrayList<Inscription> inscriptions = (ArrayList<Inscription>) is.getAllInscriptionsById(productselected.getIdP());
          ObservableList obs= FXCollections.observableArrayList(inscriptions);
        tab_inscription.setItems(obs);
          nomE.setCellValueFactory(new PropertyValueFactory<>("Nom_etudiant"));
          prenomE.setCellValueFactory(new PropertyValueFactory<>("Prenom_etudiant"));
//          tab_inscription.setEditable(true);
//          nomE.setCellFactory(TextFieldTableCell.forTableColumn());
//          prenomE.setCellFactory(TextFieldTableCell.forTableColumn());
//          
        } catch (SQLException ex) {
            Logger.getLogger(PlanningFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void inscrire(MouseEvent event) throws IOException, SQLException {

        if(tf_nomE.getText().isEmpty()||tf_prenomE.getText().isEmpty())
        {
              Notifications notificationBuilder2 = Notifications.create()
                                    .title("échec  d'ajout")
                                    .text("veulliez remplir tous les champs")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                             notificationBuilder2.show();
        }
        else if (tf_nomE.getText().matches("[a-zA-Z]+")&&tf_prenomE.getText().matches("[a-zA-Z]+"))
        { 
            
        Planning productselected = tab_plan.getSelectionModel().getSelectedItem();
        Inscription i = new Inscription(tf_nomE.getText(),tf_prenomE.getText());
               InscriptionService is = new InscriptionService();
      
                   is.ajouterInscription(i,productselected.getIdP());
                   FXMLLoader loader = new FXMLLoader(getClass().getResource("./PlanningFXML.fxml"));
                   Parent root;
                       root = loader.load();
                       btn_inscrire.getScene().setRoot(root);
                       
                       Notifications notificationBuilder2 = Notifications.create()
                                    .title("succés  d'ajout")
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
    @FXML
    private void desinscrire(MouseEvent event) throws SQLException {
       InscriptionService is = new InscriptionService();
       Inscription productselected = tab_inscription.getSelectionModel().getSelectedItem();
       
       
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
       tab_inscription.setItems(obs);
       nomE.setCellValueFactory(new PropertyValueFactory<>("Nom_etudiant"));
       prenomE.setCellValueFactory(new PropertyValueFactory<>("Prenom_etudiant"));
           Notifications notificationBuilder2 = Notifications.create()
                                    .title("succés  de désinscription")
                                    .text("etudiant désinscrit")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                                notificationBuilder2.show();
       
    }  
       
    }
    @FXML
    private void ajouter(MouseEvent event) throws SQLException, IOException
    {         
       if(tf_nom.getText().isEmpty()||tf_sujet.getText().isEmpty()||tf_enseignant.getText().isEmpty()||tf_maximum.getText().isEmpty()||tf_salle.getText().isEmpty()||tf_heure.getText().isEmpty())
       {
           Notifications notificationBuilder2 = Notifications.create()
                                    .title("échec  d'ajout")
                                    .text("verifiez vos champs")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                            notificationBuilder2.show();
       }
      
       else if (tf_nom.getText().matches("[a-zA-Z]+")&&tf_sujet.getText().matches("[a-zA-Z]+")&&tf_enseignant.getText().matches("[a-zA-Z]+")&&tf_salle.getText().matches("[a-zA-Z]+")){
               Planning p = new Planning(tf_nom.getText(),tf_sujet.getText(),tf_enseignant.getText(),Integer.parseInt(tf_maximum.getText()),tf_salle.getText(),java.sql.Date.valueOf(id_date.getValue()),tf_heure.getText());
               PlanningService ps = new PlanningService();              
      
                   ps.ajouterPlanning(p);
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("./PlanningFXML.fxml"));
                   Parent root;
                  
                       root = loader.load();
                       btn_ajouP.getScene().setRoot(root);   
                      Notifications notificationBuilder2 = Notifications.create()
                                    .title("succés  d'ajout")
                                    .text("session ajouté")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                            notificationBuilder2.show();  
               }
       else
       {     
           Notifications notificationBuilder2 = Notifications.create()
                                    .title("échec  d'ajout")
                                    .text("verifiez vos champs")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                            notificationBuilder2.show();           
               }           
    }

    @FXML
    private void supprimer(MouseEvent event) throws SQLException {
        
        PlanningService ps = new PlanningService();
        Planning productselected = tab_plan.getSelectionModel().getSelectedItem();
        
         if(productselected==null)
        {
              Notifications notificationBuilder2 = Notifications.create()
                                    .title("échec  de suppression")
                                    .text("veuillez selecter un planning")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                                notificationBuilder2.show();
        }
        else
        {
        
        ps.supprimerPlanning(productselected.getIdP());
        ArrayList<Planning> plannings = (ArrayList<Planning>) ps.getAllPlannings();
            ObservableList obs= FXCollections.observableArrayList(plannings);
            tab_plan.setItems(obs);
            nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
            sujet.setCellValueFactory(new PropertyValueFactory<>("Sujet"));
            enseignant.setCellValueFactory(new PropertyValueFactory<>("Enseignant"));
            maximum.setCellValueFactory(new PropertyValueFactory<>("Maximum"));
            salle.setCellValueFactory(new PropertyValueFactory<>("Salle"));
            date.setCellValueFactory(new PropertyValueFactory<>("Date"));

       Notifications notificationBuilder2 = Notifications.create()
                                    .title("succés  de suppression")
                                    .text("planning supprimé")
                                    //.graphic(table)
                                    .hideAfter(Duration.seconds(3))
                                    .position(Pos.TOP_RIGHT);
                                notificationBuilder2.show();
        }
    }
    @FXML
    private void retour(MouseEvent event) {
        
               
         FXMLLoader loader = new FXMLLoader(getClass().getResource("./AcceuilFXML.fxml"));
                   Parent root;
                   try {
                       root = loader.load();    
                       btn_retour.getScene().setRoot(root);
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