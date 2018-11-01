/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picovoiturage;

import Services.ReservationService;
import Services.covservice;
import connectionBase.Basecovoiturage;
import entities.covoitu;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.objects.Global;

/**
 *
 * @author esprit
 */
public class PIcovoiturage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Basecovoiturage database = Basecovoiturage.getInstance();
        Connection connexion = Basecovoiturage.getInstance().getConnection();
        ReservationService covservice = new ReservationService();
        ReservationService reservationService = new ReservationService();
        List<covoitu> r = new ArrayList<>();
//                   try {
//         r=   covservice.getAllCovoiturageReservation(12);
//         int i= r.size();
//           while(i>0){
//               System.out.println(r.);
//               i--;
//           }
//            } catch (SQLException ex) {
//               System.out.println("non supprimé");
//            }  
        
//        try {
//            for (covoitu c : covservice.getAllCovoiturageReservation(12))
//                    {
//                       System.out.println(c);
//                    }
//          } catch (SQLException ex) {
//          Logger.getLogger(PIcovoiturage.class.getName()).log(Level.SEVERE, null, ex);
//          }
     try {
           ReservationService ps =new ReservationService();
           Date t = null;
           covoitu c = new covoitu("sousse", "sousse",t, 1, 2, "simple", 8, 12, 0);
           ps.supprimerRes3(c.getId(), c.getIdetu());
          } catch (SQLException ex) {
          Logger.getLogger(PIcovoiturage.class.getName()).log(Level.SEVERE, null, ex);
          }       
//        try {
//           covservice ps =new covservice();
//           
//           ps.best_user();
//          } catch (SQLException ex) {
//          Logger.getLogger(PIcovoiturage.class.getName()).log(Level.SEVERE, null, ex);
//          }
//        
    }
    
}
