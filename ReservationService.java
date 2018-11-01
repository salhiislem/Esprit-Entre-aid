/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covbd.services;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

import covbd.entities.Reservation;
import covbd.entities.covoitu;
import covbd.utils.covoiturage;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javacov.Javacov;
//import covbd.entities.covoitu;


/**
 *
 * @author esprit
 */
public class ReservationService {
    Connection connexion;
    Statement st;
    ResultSet result;
    static ReservationService instance;
 public static ReservationService getInstance()
    {
    if(instance==null)
    {
    instance = new ReservationService();}
    return instance;
    
    }
 
    public ReservationService(){
        connexion=covoiturage.getInstance().getConnection();
    }
    
    public void ajouterRes(Reservation i) throws SQLException{
//        covoitu c = new covoitu();
        try{
        String req="INSERT INTO reservation(id_user,idC) values( ?,?)";
        
        PreparedStatement ps=connexion.prepareStatement(req);
        ps.setInt(1,i.getE().getId());
        ps.setInt(2,i.getC().getId());
       // ps.setInt(2,i.getNbre_place());       
        ps.executeUpdate();
       // i.getC().setNbr(i.getC().getNbr()-1);
        
        }
        catch (SQLException ex) {
          Logger.getLogger(Javacov.class.getName()).log(Level.SEVERE, null, ex);
          } 
     }
       public void ajouterRes2(Reservation i) throws SQLException{
//        covoitu c = new covoitu();
         boolean aj=false;
         int x;
        try{
        String req="INSERT INTO reservation(id,id_user,idC) values(?,?,?)";
        x=i.getIDC();
        PreparedStatement ps=connexion.prepareStatement(req);
        ps.setInt(1,i.getId());
        ps.setInt(2,i.getE().getId());
        ps.setInt(3,x);
       // ps.setInt(2,i.getNbre_place());       
        ps.executeUpdate();
       // i.getC().setNbr(i.getC().getNbr()-1);
       aj=true;
        
        }
        catch (SQLException ex) {
          Logger.getLogger(Javacov.class.getName()).log(Level.SEVERE, null, ex);
          } 
        if (aj=true){
            try {
                String req2="UPDATE `cov` SET `nbr`=(nbr-1) WHERE id="+(i.getC().getId());
                PreparedStatement ps1=connexion.prepareStatement(req2);
                ps1.executeUpdate();
                
                
            }
            catch(SQLException ex) {
          Logger.getLogger(Javacov.class.getName()).log(Level.SEVERE, null, ex);
          } 
        
                
     }
        
       }
    public List <Reservation> getAllReservations(int id_c) throws SQLException
    {   
        List <Reservation> r= new ArrayList<>();
       String req="SELECT * FROM etudiant e  inner join reservation i on (i.id_etudiant=e.id) WHERE i.id=?";
        
        PreparedStatement ps=connexion.prepareStatement(req);
        ps.setInt(1,id_c);
        ResultSet rst=ps.executeQuery(req);
        while (rst.next()){
            Reservation p;
            p = new Reservation();
            r.add(p);
        }
        return r; }
    
    
    public void supprimerRes(int d) throws SQLException {
       String query="SELECT * FROM reservation WHERE id="+"'"+d+"';";
       String req="DELETE FROM reservation WHERE id=?;";
       PreparedStatement ps=connexion.prepareStatement(req);
    Statement stm= connexion.createStatement();
               ResultSet rs= stm.executeQuery(query);
             
               if (rs.next())
               {
                    ps.setInt(1,d);
                    ps.executeUpdate();
                    System.out.println("reservation annulée");
                    
               }
               else {System.out.println("reservation introuvable");}         
    }
      public void ajouterResC(Reservation i) throws SQLException{
//        covoitu c = new covoitu();
        try{
        String req="INSERT INTO reservation(id_user,idC) values( ?,?)";
        
        PreparedStatement ps=connexion.prepareStatement(req);
        ps.setInt(1,i.getE().getId());
        ps.setInt(2,i.getC().getId());
       // ps.setInt(2,i.getNbre_place());       
        ps.executeUpdate();
       // i.getC().setNbr(i.getC().getNbr()-1);
        
        }
        catch (SQLException ex) {
          Logger.getLogger(Javacov.class.getName()).log(Level.SEVERE, null, ex);
          } 
     }
        
//rst.getString("nom"),rst.getString("prenom"),rst.getString("date_inscri"),rst.getString("type_membre")
    
    
//    public Reservation getReservationbyId(int id) {
//     Reservation p = null ; 
//    String req = "select * from Reservations where id="+id ; 
//    try{
//        result = st.executeQuery(req) ; 
//        result.next() ; 
//        p = new Reservation(result.getInt(1),result.getInt(2),result.getInt(3),result.getInt(4)); 
//    }   catch (SQLException ex) {
//            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    return p ; 
//     }
////INSERT INTO `reservation`(`id`, `id_user`, `nbre_place`, `idC`) VALUES ([value-1],[value-2],[value-3],[value-4])
//    public static void insert(Reservation p) {
//        Statement ste = null;
//        String req = "insert into `reservation` (`id_user`, `nbre_place`) VALUES ('" + p.getId_user()+ "','" + p.getNbre_place()+ "')";
//        System.out.println(req);
//        try {
//            ste.executeUpdate(req);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
       
//    public void insert1(Reservation p,int v) {
//        String req = "insert into Reservations (id_user,nbre_place,idC) values ('" + p.getId_user()+ "','" + p.getNbre_place()+"','"+v+"')";
//        System.out.println(req);
//        try {
//            st.executeUpdate(req);
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//    
//    public Reservation search(int id) {
//                  Reservation p = null ; 
//    String req = "select * from Reservations where idC="+id ; 
//    try{
//        result = st.executeQuery(req) ; 
//        result.next() ; 
//       p = new Reservation(result.getInt(1), result.getInt(2), result.getInt(3),result.getInt(4));
//        }   catch (SQLException ex) {
//            Logger.getLogger(covservice.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    return p ;
//    }
//       public  Reservation search2(int id) {
//                   Reservation p = null ; 
//    String req = "select * from Reservations where id="+id ; 
//    try{
//        result = st.executeQuery(req) ; 
//        result.next() ; 
//        p = new Reservation(result.getInt(1), result.getInt(2), result.getInt(3),result.getInt(4));
//        }   catch (SQLException ex) {
//            Logger.getLogger(covservice.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    return p ;
//    }
//
//
//    public boolean delete(int id) {
//        Reservation p1=search(id);
//      
//   if(p1!=null)
//   {
//       try {
//           st.executeUpdate("delete from Reservations where idC="+id);
//            return true;
//           }catch (SQLException ex) {    
//                Logger.getLogger(covservice.class.getName()).log(Level.SEVERE, null, ex);
//            }    
//  
//   }return false;
//     
//    }
//
//
//    public boolean update1(Reservation p,int v) {
//         Reservation p1= search2(p.getId()); 
//    if(p1!=null){
//        try{
//            st.executeUpdate("update Reservations set id_user='"+p.getId_user()+"',nbre_place='"+p.getNbre_place()+"',idC='"+v+"'where id_reservation="+p1) ; 
//        } catch (SQLException ex) {
//            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return true ; 
//    }
//    return false ; 
//    }
    
     public int afficherid(Reservation i) throws SQLException{
         return (i.getC().getId());
     }
     public int retournerIDC(Reservation i) throws SQLException{
//        covoitu c = new covoitu();
        try{
        String req="SELECT id from cov WHERE id="+i.getC().getId();
        
        Statement ps=connexion.createStatement();
             ResultSet rst=ps.executeQuery(req);
     int val =  ((Number) rst.getObject(1)).intValue();
     return (val);
       // i.getC().setNbr(i.getC().getNbr()-1);
        
        }
        catch (SQLException ex) {
          Logger.getLogger(Javacov.class.getName()).log(Level.SEVERE, null, ex);
          } 
        return 0;
     }
     }
    
    




