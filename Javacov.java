/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacov;
import covbd.entities.Etudiant;
import covbd.entities.Reservation;
import covbd.entities.covoitu;
import covbd.services.ReservationService;
import covbd.services.covservice;
import covbd.utils.covoiturage;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author esprit
 */
public class Javacov {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        covoitu cov = new covoitu();
        covoiturage database = covoiturage.getInstance();
        Connection connexion = covoiturage.getInstance().getConnection();
        covservice covservice = new covservice();
        ReservationService reservationService = new ReservationService();
        //Timestamp t = new Timestamp(System.currentTimeMillis());
        Etudiant e1=new Etudiant(88,"ensaf","Salhi");
        covoitu c3= new covoitu("gafsa", "mahdia", "13", 3, 559863, 8, 20,5);
       covoitu c1 = new covoitu("mahdia", "bardo", "12",1,999999,0,10);
        
      // c2 = new covoitu (10,"tunis","bizerte","14", 5,3333333,5,5);
       Reservation r1= new Reservation(c1,e1);
       Reservation r2= new Reservation(c3,e1);
       
       covservice.ModifierC(c1,13);
       
//      try {
//           reservationService.supprimerRes(23);
//          } catch (SQLException ex) {
//          Logger.getLogger(Javacov.class.getName()).log(Level.SEVERE, null, ex);
//          } 
       try {
           reservationService.ajouterRes2(r2);
          } catch (SQLException ex) {
          Logger.getLogger(Javacov.class.getName()).log(Level.SEVERE, null, ex);
          } 
//        try {
//           reservationService.ajouterRes(r2);
//          } catch (SQLException ex) {
//          Logger.getLogger(Javacov.class.getName()).log(Level.SEVERE, null, ex);
//          } 
//        try {
//            for (covoitu c : covservice.getAllcov())
//                    {
//                       System.out.println(c);
//                    }
//          } catch (SQLException ex) {
//          Logger.getLogger(Javacov.class.getName()).log(Level.SEVERE, null, ex);
//          }
//       
//       
//        try {
//           reservationService.supprimerRes(11);
//          } catch (SQLException ex) {
//          Logger.getLogger(Javacov.class.getName()).log(Level.SEVERE, null, ex);
//          }
//       
               try {
           covservice.getAllcov();
          } catch (SQLException ex) {
          Logger.getLogger(Javacov.class.getName()).log(Level.SEVERE, null, ex);
          }
//       try {
//             covservice.ajoutercovcs(c3);
//               
//            } catch (SQLException ex) {
//          Logger.getLogger(Javacov.class.getName()).log(Level.SEVERE, null, ex);
//           } 

//      try {
//           reservationService.ajouterRes2(r2);
//          } catch (SQLException ex) {
//          Logger.getLogger(Javacov.class.getName()).log(Level.SEVERE, null, ex);
//          } 


//           try {
////               reservationService.retournerIDC(r2);
//               System.out.println(reservationService.retournerIDC(r2));
//            
//            } catch (SQLException ex) {
//               System.out.println("non");
//            }  
//           try {
//            covservice.SupprimerId(13);
//            
//            } catch (SQLException ex) {
//               System.out.println("non supprimé");
//            }  
//           try {
//            for (covoitu c: covservice.getAllcov())
//            {     System.out.println(c.getDepart());
//                   System.out.println(c.getArrive());
//                   System.out.println(c.getTemps());
//                   System.out.println(c.getNumero());
//                   System.out.println(c.getTemps());
//            }
//            
//            } catch (SQLException ex) {
//            Logger.getLogger(Javacov.class.getName()).log(Level.SEVERE, null, ex);
//            }
          // covservice.Modifiernbr(5555526,2);
           
           //string req=""
           
//           try{
//               System.out.println(reservationService.afficherid(r1));
//           }
//           catch (SQLException ex) {
//           Logger.getLogger(Javacov.class.getName()).log(Level.SEVERE, null, ex);
//           }
}
    
} 

