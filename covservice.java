/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import connectionBase.Basecovoiturage;
import entities.Etudiant;
import entities.covoitu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esprit
 */
public class covservice {
     Connection connexion;
    public covservice(){
        connexion=Basecovoiturage.getInstance().getConnection();
    }
    
                          /*AJOUTER UN COVOITURAGE*/
    public void ajoutercovcs(covoitu c) throws SQLException{
        String req="INSERT INTO cov (`depart`,`arrive`,`temps`,`nbr`,`numero`,`type`,`prix`,`idetu`) values( ?, ?,?,?,?,?,?,?);";
        PreparedStatement ps=connexion.prepareStatement(req);
        ps.setString(1,c.getDepart());
        ps.setString(2,c.getArrive());
        ps.setDate(3,c.getTemps());
        ps.setInt(4,c.getNbr());
        ps.setInt(5,c.getNumero());
        ps.setString(6,c.getType());
        ps.setInt(7,c.getPrix());
        ps.setInt(8,c.getIdetu());
        
        ps.executeUpdate();
    }
    
    /*POUR L AFFICHAGE*/
    
    public List<covoitu> getAllcov() throws SQLException
    {   
        List <covoitu> covoi= new ArrayList<>();
        String req="SELECT * FROM cov";
        Statement stm=connexion.createStatement();
        ResultSet rst=stm.executeQuery(req);
        while (rst.next()){
            covoitu p;
            p = new covoitu(rst.getString("depart"),rst.getString("arrive"),rst.getDate("temps"),rst.getInt("nbr"),rst.getInt("numero"),rst.getString("type"),rst.getInt("prix"),rst.getInt("id"),rst.getInt("idetu"));
            covoi.add(p);
        }
        return covoi; }
    
     public List<covoitu> getAllcovID(int x) throws SQLException
    {   
        List <covoitu> covoi= new ArrayList<>();
        String req="SELECT * FROM cov ";
        Statement stm=connexion.createStatement();
        ResultSet rst=stm.executeQuery(req);
        
        while (rst.next()){           
            covoitu p;                 
            p = new covoitu(rst.getString("depart"),rst.getString("arrive"),rst.getDate("temps"),rst.getInt("nbr"),rst.getInt("numero"),rst.getString("type"),rst.getInt("prix"),rst.getInt("id"),rst.getInt("idetu"));
           if(rst.getInt("idetu")==x){
            covoi.add(p);
        } }
        return covoi; }
    
           /* SUPPRESSION PAR ID*/
    
    public void SupprimerId(int x) throws SQLException{
        String req="delete from cov where id=?" ;
       PreparedStatement ps=connexion.prepareStatement(req);
       ps.setInt(1, x);
       ps.executeUpdate();
    } 
     
        /*MODIFICATION*/    

    public void ModifierC(covoitu p,int d) throws SQLException{
String query="SELECT * FROM cov WHERE id="+d;
       String req="UPDATE `cov` SET `depart`=?,`arrive`=?,`temps`=?,`nbr`=?,`numero`=?,`type`=?,`prix`=? WHERE id=?;" ;
       PreparedStatement ps=connexion.prepareStatement(req);
    Statement stm= connexion.createStatement();
               ResultSet rs= stm.executeQuery(query);
             
               if (rs.next())
               { 
        ps.setString(1,p.getDepart());
        ps.setString(2,p.getArrive());
        ps.setDate(3,p.getTemps());
        ps.setInt(4,p.getNbr());
        ps.setInt(5,p.getNumero());
        ps.setString(6,p.getType());
        ps.setInt(7,p.getPrix());
        ps.setInt(8,d);
        ps.executeUpdate();
        System.out.println("Covoiturage modifié");
               }
               else{System.out.println("produit introuvable");}

}
    
    
  public List<covoitu> rechercher_by_type(String type) throws SQLException {

        String req = "SELECT * FROM cov WHERE type = "+"'"+type+"';";
        List<covoitu> liste = new ArrayList<>();

        Statement stm=connexion.createStatement();
        ResultSet rst=stm.executeQuery(req);
        
        try {
            

            
            while (rst.next()) {
               
              covoitu p = new covoitu(rst.getString("depart"),rst.getString("arrive"),rst.getDate("temps"),rst.getInt("nbr"),rst.getInt("numero"),rst.getString("type"),rst.getInt("prix")); 
               
                liste.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return liste;

    }  
    
    public List<covoitu> getAllcovR() throws SQLException
    {   
        List <covoitu> covoi= new ArrayList<>();
        String req="SELECT * FROM cov c inner join reservation i on (i.idc=c.id)";
        Statement stm=connexion.createStatement();
        ResultSet rst=stm.executeQuery(req);
        while (rst.next()){
            covoitu p;
            p = new covoitu(rst.getString("depart"),rst.getString("arrive"),rst.getDate("temps"),rst.getInt("nbr"),rst.getInt("numero"),rst.getString("type"),rst.getInt("prix"),rst.getInt("id"),rst.getInt("idetu"));
            covoi.add(p);
        }
        return covoi; }
    
//    public int best_user() throws SQLException
//    {   
//        List <Etudiant> et= new ArrayList<>();
//        String req="SELECT idetu FROM cov GROUP BY idet ORDER BY COUNT(*) DESC LIMIT    1;";
//        Statement stm=connexion.createStatement();
//        ResultSet rst=stm.executeQuery(req);
//        //while (rst.next()){
//            
//            int p;
//           p=rst.getInt(req);
//           
//        return p;}
    
         
    }
    
    

