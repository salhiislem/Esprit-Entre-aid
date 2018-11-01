/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopdbPI.services;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import workshopdbPI.entities.Planning;
import workshopdbPI.utils.Mydb1;

/**
 *
 * @author Hajbi
 */
public class PlanningService {
    
      Connection connexion;

    public PlanningService() {
        connexion = Mydb1.getInstance().getConnection();
    }
    
     public static String valDate(String date)
    {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        try
        {
            f.parse(date);
            System.out.println("date valide");
        }catch(Exception e0){
            System.out.println("date invalide");
        }
        return date;
    }
    
  
     public void ajouterPlanning(Planning p) throws SQLException
    {
        String req=" INSERT INTO `Planning` (`nom`,`sujet`,`enseignant`,`maximum`,`salle`,`date`,`heure`) VALUES ('"+p.getNom()+"','"+p.getSujet()+"','"+p.getEnseignant()+"','"+p.getMaximum()+"','"+p.getSalle()+"','"+p.getDate()+"','"+p.getHeure()+"')";
        
        Statement stm= connexion.createStatement();
        stm.executeUpdate(req);    
    }
    
    public List<Planning> getAllPlannings() throws SQLException
    {
        List<Planning> plannings = new ArrayList <>();
        String req="select * from Planning ";
        Statement stm= connexion.createStatement();
         ResultSet rst = stm.executeQuery(req);
         
         while(rst.next()){
             Planning p =new Planning(rst.getInt("idp"),rst.getString("nom"),rst.getString("sujet"),rst.getString("enseignant"),rst.getInt("maximum"),rst.getString("salle"),rst.getDate("date"),rst.getString("heure"));
             plannings.add(p);
             /*System.out.print(rst.getInt("idP")+"\t");
             System.out.print(rst.getString("nom")+"\t");
             System.out.print(rst.getString("sujet")+"\t");
             System.out.print(rst.getString("prof")+"\t");
             System.out.print(rst.getInt("Maximum")+"\t");
             System.out.print(rst.getString("salle")+"\t");
             System.out.print(rst.getString("date")+"\t");
             System.out.println();*/
         }
         return plannings;
     }
    
     public void modifierPlanning(int i,Planning p) throws SQLException{
        String req=" update planning set enseignant=?,salle=?,date=?,heure=? WHERE idP=?";
        String query=" select * from planning WHERE idP="+i;
        PreparedStatement ps=connexion.prepareStatement(req);
        Statement stm=connexion.createStatement();
        ResultSet res=stm.executeQuery(query);
        if(res.next())
        {
        ps.setString(1,p.getEnseignant());
        //ps.setInt(2,p.getMaximum());
        ps.setString(2,p.getSalle());
        ps.setDate(3,p.getDate());
        ps.setString(4,p.getHeure());
        ps.setInt(5,i);
        ps.executeUpdate();
        System.out.println("update terminé ");
        }
        else
            System.out.println("Planning inexistant");
     }
    
    public void modifierPlanning1(int i, String s1) throws SQLException{
        String req=" update planning set nom=? WHERE idP=? ";
        String query=" select * from planning WHERE idP="+i;
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
            System.out.println("Planning inexistant");
        
    }
    public void modifierPlanning2(int i, String s2) throws SQLException{
        String req=" update planning set sujet=? WHERE idP=? ";
        String query=" select * from planning WHERE idP="+i;
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
            System.out.println("Planning inexistant");
        
    }
    
    public void modifierPlanning3(int i, int m) throws SQLException{
        String req=" update planning set maximum=? WHERE idP=? ";
        String query=" select * from planning WHERE idP="+i;
        PreparedStatement ps=connexion.prepareStatement(req);
        Statement stm=connexion.createStatement();
        ResultSet res=stm.executeQuery(query);
        if(res.next())
        {
        ps.setInt(1,m);
        ps.setInt(2,i);
        ps.executeUpdate();
        System.out.println("maximum modifié");
        }
        else
            System.out.println("Planning inexistant");
        
    }
    
    public void modifierPlanning4(int i, String s3) throws SQLException{
        String req=" update planning set salle=? WHERE idP=? ";
        String query=" select * from planning WHERE idP="+i;
        PreparedStatement ps=connexion.prepareStatement(req);
        Statement stm=connexion.createStatement();
        ResultSet res=stm.executeQuery(query);
        if(res.next())
        {
        ps.setString(1,s3);
        ps.setInt(2,i);
        ps.executeUpdate();
        System.out.println("sujet modifié");
        }
        else
            System.out.println("Planning inexistant");
        
    }
    
    public void supprimerPlanning(int i) throws SQLException{
        String req = "DELETE FROM planning WHERE idP=?";
         PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1,i);
        ps.executeUpdate();
        System.out.println("Planning supprimé !");
        }    
}
