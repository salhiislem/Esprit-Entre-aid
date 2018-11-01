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
import workshopdbPI.entities.Discussion;
import workshopdbPI.utils.Mydb1;

/**
 *
 * @author Hajbi
 */
public class DiscussionService {
     Connection connexion;

    public DiscussionService() {
        connexion = Mydb1.getInstance().getConnection();
    }
    
     public void ajouterDiscussion(Discussion d) throws SQLException
    {
        String req=" INSERT INTO `Discussion` (`nom`,`sujet`) VALUES ('"+d.getNom()+"','"+d.getSujet()+"')";
        
        Statement stm= connexion.createStatement();
        stm.executeUpdate(req);    
    }
    
    public List<Discussion> getAllDiscussions() throws SQLException
    {
        List<Discussion> discussions = new ArrayList <>();
        String req="select * from Discussion";
        Statement stm= connexion.createStatement();
         ResultSet rst = stm.executeQuery(req);
         
         while(rst.next()){
             Discussion d =new Discussion(rst.getInt("idD"),rst.getString("nom"),rst.getString("sujet"));
             discussions.add(d);  
         }
         return discussions;
     }
    
     public void modifierDiscussion(int i,Discussion d) throws SQLException{
        String req=" update discussion set nom=? ,sujet=? WHERE idD=?";
        String query=" select * from discussion WHERE idD="+i;
        PreparedStatement ps=connexion.prepareStatement(req);
        Statement stm=connexion.createStatement();
        ResultSet res=stm.executeQuery(query);
        if(res.next())
        {
        ps.setString(1,d.getNom());
        ps.setString(2,d.getSujet());
        ps.setInt(3,i);
        ps.executeUpdate();
        System.out.println("update terminé ");
        }
        else
            System.out.println("discussion inexistante");
     }
    
    public void modifierDiscussion1(int i, String s1) throws SQLException{
        String req=" update discussion set nom=? WHERE idD=? ";
        String query=" select * from discussion WHERE idD="+i;
        PreparedStatement ps=connexion.prepareStatement(req);
        Statement stm=connexion.createStatement();
        ResultSet res=stm.executeQuery(query);
        if(res.next())
        {
        ps.setString(1,s1);
        ps.setInt(2,i);
        ps.executeUpdate();
        System.out.println("nom modifié");
        }
        else
            System.out.println("discussion inexistante");
        
    }
    public void modifierDiscussion2(int i, String s2) throws SQLException{
        String req=" update discussion set sujet=? WHERE idD=? ";
        String query=" select * from discussion WHERE idD="+i;
        PreparedStatement ps=connexion.prepareStatement(req);
        Statement stm=connexion.createStatement();
        ResultSet res=stm.executeQuery(query);
        if(res.next())
        {
        ps.setString(1,s2);
        ps.setInt(2,i);
        ps.executeUpdate();
        System.out.println("sujet modifié");
        }
        else
            System.out.println("discussion inexistante");
        
    }
    
    public void supprimerDiscussion(int i) throws SQLException{
        String req = "DELETE FROM discussion WHERE idD=?";
         PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1,i);
        ps.executeUpdate();
        System.out.println("Discussion supprimée !");
        }
    
}
