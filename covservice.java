/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covbd.services;
import covbd.entities.covoitu;
import covbd.utils.covoiturage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esprit
 */
public class covservice {
    Connection connexion;
    public covservice(){
        connexion=covoiturage.getInstance().getConnection();
    }
    public void ajoutercov(covoitu c)throws SQLException{
        String req="INSERT INTO `cov` (`depart`, `arrive`,`temps`,`nbr`,`numero`,`type`) VALUES ('"+c.getDepart()+"', '"+c.getArrive()+"', '"+c.getTemps()+"', '"+c.getNbr()+"','"+c.getNumero()+"','"+c.getType()+"')";
        //String req1="INSERT INTO 'Product' ('libelle' ,'nom')" +" values (p.getLib(),p.getDesc();";
                
                Statement stm= connexion.createStatement();
                stm.executeUpdate(req);
    }
    
    public void ajoutercovcs(covoitu c) throws SQLException{
        String req="INSERT INTO cov (`depart`,`arrive`,`temps`,`nbr`,`numero`,`type`,`prix`) values( ?, ?,?,?,?,?,?);";
        PreparedStatement ps=connexion.prepareStatement(req);
        ps.setString(1,c.getDepart());
        ps.setString(2,c.getArrive());
        ps.setString(3,c.getTemps());
        ps.setInt(4,c.getNbr());
        ps.setInt(5,c.getNumero());
        ps.setInt(6,c.getType());
        ps.setInt(7,c.getPrix());
        
        ps.executeUpdate();
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<covoitu> getAllcov() throws SQLException
    {   
        List <covoitu> covoi= new ArrayList<>();
        String req="SELECT * FROM cov";
        Statement stm=connexion.createStatement();
        ResultSet rst=stm.executeQuery(req);
        while (rst.next()){
            covoitu p;
            p = new covoitu(rst.getString("depart"),rst.getString("arrive"),rst.getString("temps"),rst.getInt("nbr"),rst.getInt("numero"),rst.getInt("id"),rst.getInt("type"),rst.getInt("prix"));
            covoi.add(p);
        }
        return covoi;
    }    
   public void Supprimer(int x) throws SQLException{
        String req="delete from cov where numero="+x ;
       PreparedStatement ps=connexion.prepareStatement(req);
       
       ps.executeUpdate();
    }

   
   
public void Modifier(covoitu c) throws SQLException{
//String req= "UPDATE `cov` SET `depart`=l,`arrive`=d,`temps`=t,`nbr`=n,`numero`=a,`type`=x,`prix`=y WHERE 'id'="+z;
String req= "UPDATE `cov` SET `depart`=?,`arrive`=?,`temps`=?,`nbr`=?,`numero`=?,`type`=?,`prix`=? WHERE `id`=?" ;   
//String req="UPDATE 'cov' SET depart='"+l +"', arrive ='"+d +"', temps ='"+t+"', nbr ='"+n +"', type ='"+x +"', prix ='"+"'where id="+a;
      PreparedStatement ps=connexion.prepareStatement(req);
      ps.setString(1,c.getDepart());
        ps.setString(2,c.getArrive());
        ps.setString(3,c.getTemps());
        ps.setInt(4,c.getNbr());
        ps.setInt(5,c.getNumero());
        ps.setInt(6,c.getType());
        ps.setInt(7,c.getPrix());
        ps.setInt(8,c.getId());
        
        ps.executeUpdate();
  }
//   public void Modifier(String d, String l, String t, int np,int n,int ty, int p, int i) throws SQLException
//   {
//       String req= "UPDATE `cov` SET `depart`=l,`arrive`=d,`temps`=t,`nbr`=np,`numero`=n,`type`=ty,`prix`=p WHERE 'id'="+i;
//       Statement s;       
////        s = connexion.CreateStatement(req);
//PreparedStatement ps = null;
//        try {
//            ps = connexion.prepareStatement(req);
//        } catch (SQLException ex) {
//            Logger.getLogger(covservice.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        ps.executeUpdate();
//   }
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
        ps.setString(3,p.getTemps());
        ps.setInt(4,p.getNbr());
        ps.setInt(5,p.getNumero());
        ps.setInt(6,p.getType());
        ps.setInt(7,p.getPrix());
        ps.setInt(8,d);
        ps.executeUpdate();
        System.out.println("Covoiturage modifié");
               }
               else{System.out.println("produit introuvable");}

}
public void SupprimerId(int x) throws SQLException{
        String req="delete from cov where id=?" ;
       PreparedStatement ps=connexion.prepareStatement(req);
       ps.setInt(1, x);
       ps.executeUpdate();
    } 
public void Supprimernum(int x) throws SQLException{
        String req="delete from cov where numero="+x ;
       PreparedStatement ps=connexion.prepareStatement(req);
       
       ps.executeUpdate();
    }
//public void Supprimerch(int d) throws SQLException{
//String query="SELECT * FROM cov WHERE id="+d;
//       String req="DELETE FROM cov WHERE id=?;";
//       PreparedStatement ps=connexion.prepareStatement(req);
//    Statement stm= connexion.createStatement();
//               ResultSet rs= stm.executeQuery(query);
//             
//               if (rs.next())
//               {
//                    ps.setInt(1,d);
//                    ps.executeUpdate();
//                    System.out.println("covoiturage supprimé");
//               }
//               else {System.out.println("covoiturage introuvable");}


//public void Modifierch(int d) throws SQLException{
//String query="SELECT * FROM cov WHERE id="+d;
//       String req="UPDATE cov SET depart=?,arrive=?,temps=?,nbr=?,numero=? ,prix=?,type=? WHERE id=?;" ;
//       PreparedStatement ps=connexion.prepareStatement(req);
//    Statement stm= connexion.createStatement();
//               ResultSet rs= stm.executeQuery(query);
//             covoitu c = new covoitu();
//               if (rs.next())
//               { 
//        ps.setString(1,c.getDepart());
//        ps.setString(2,c.getArrive());
//        ps.setTimestamp(3,c.getTemps());
//        ps.setInt(4,c.getNbr());
//        ps.setInt(5,c.getNumero());
//         ps.setInt(5,c.getPrix());
//          ps.setInt(5,c.getType());
//        ps.executeUpdate();
//        System.out.println("produit modifié");
//               }
//               else{System.out.println("produit introuvable");}

//    public void Modifiernbr(int a,int b) throws SQLException{
//       String req="UPDATE cov SET nbr='"+b +"' where numero="+a;
//       
//      Statement s=connexion.createStatement() ;
//      s.executeUpdate(req);
  }
    
    
