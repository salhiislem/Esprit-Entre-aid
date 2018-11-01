/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopdbPI.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import workshopdbPI.entities.Inscription;
import workshopdbPI.entities.Planning;
import workshopdbPI.utils.Mydb1;

/**
 *
 * @author Hajbi
 */
public class InscriptionService {
     Connection connexion;
     public InscriptionService() {
        connexion = Mydb1.getInstance().getConnection();
    }
    
     public void ajouterInscription(Inscription i,int id,int m) throws SQLException
    {
        Planning p = null;
        String req=" INSERT INTO `inscription`(`nom_etudiant`,`prenom_etudiant`,`idp`,`idE`) VALUES ('"+i.getNom_etudiant()+"','"+i.getPrenom_etudiant()+"','"+id+"','"+i.getIdE()+"') where count(idp)<m "+m;
        Statement stm= connexion.createStatement();
        stm.executeUpdate(req);    
    }
     
     public List<Inscription> getAllInscriptions() throws SQLException
    {
        List<Inscription> inscriptions = new ArrayList <>();
        String req="SELECT * from inscription ";
        PreparedStatement ps=connexion.prepareStatement(req);
        Statement stm= connexion.createStatement();
         ResultSet rst = stm.executeQuery(req);
          
         while(rst.next()){
            
             Inscription i =new Inscription(rst.getString("nom_etudiant"),rst.getString("prenom_etudiant"),rst.getInt("idp"),rst.getInt("idE"));
             inscriptions.add(i);
//             System.out.print(rst.getString("nom_etudiant")+"\t");
//             System.out.print(rst.getString("prenom_etudiant")+"\t");
//             System.out.println();
         }
         return inscriptions;
     }
     public List<Inscription> getAllInscriptionsById(int id) throws SQLException
    {
        List<Inscription> inscriptions = new ArrayList <>();
        String req="SELECT * from inscription where idp="+id;
        PreparedStatement ps=connexion.prepareStatement(req);
        Statement stm= connexion.createStatement();
         ResultSet rst = stm.executeQuery(req);
          
         while(rst.next()){
            
             Inscription i =new Inscription(rst.getInt("idI"),rst.getString("nom_etudiant"),rst.getString("prenom_etudiant"),rst.getInt("idp"),rst.getInt("idE"));
             inscriptions.add(i);
//             System.out.print(rst.getString("nom_etudiant")+"\t");
//             System.out.print(rst.getString("prenom_etudiant")+"\t");
//             System.out.println();
         }
         return inscriptions;
     }
     public void modifierInscription(int n,Inscription i) throws SQLException{
        String req=" update inscription set nom_etudiant=? ,prenom_etudiant=? WHERE idE=?";
        String query=" select * from inscription WHERE idE="+n;
        PreparedStatement ps=connexion.prepareStatement(req);
        Statement stm=connexion.createStatement();
        ResultSet res=stm.executeQuery(query);
        if(res.next())
        {
        ps.setString(1,i.getNom_etudiant());
        ps.setString(2,i.getPrenom_etudiant());
        ps.setInt(3,n);
        ps.executeUpdate();
        System.out.println("update terminé ");
        }
        else
            System.out.println("discussion inexistante");
     }
     
     
      public void supprimerInscription(int i,int j) throws SQLException{
        String req = "DELETE FROM Inscription WHERE idE=? and idp=?";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1,i);
        ps.setInt(2,j);
        ps.executeUpdate();
        System.out.println("Inscription supprimée !");
        }
     
     
}
