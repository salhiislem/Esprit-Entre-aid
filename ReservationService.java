/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import connectionBase.Basecovoiturage;
import entities.Etudiant;
import entities.Reservation;
import entities.covoitu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import picovoiturage.PIcovoiturage;

/**
 *
 * @author esprit
 */
public class ReservationService {

    Connection connexion;
    Statement st;
    ResultSet result;
    static ReservationService instance;

    public static ReservationService getInstance() {
        if (instance == null) {
            instance = new ReservationService();
        }
        return instance;

    }

    public ReservationService() {
        connexion = Basecovoiturage.getInstance().getConnection();
    }

    public void ajouterRes2(Reservation i) throws SQLException {

        boolean aj = false;

        try {
            String req = "INSERT INTO reservation(id_user,idC) values(?,?)";

            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setInt(2, i.getC().getId());
            ps.setInt(1, i.getE().getId());

            ps.executeUpdate();

            aj = true;

        } catch (SQLException ex) {
            Logger.getLogger(PIcovoiturage.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (aj = true) {
            try {
                String req2 = "UPDATE `cov` SET `nbr`=(nbr-1) WHERE id=" + (i.getC().getId());
                PreparedStatement ps1 = connexion.prepareStatement(req2);
                ps1.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(PIcovoiturage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /*ANNULER UNE RESERVATION*/
    public void supprimerRes(int d) throws SQLException {
        String query = "SELECT * FROM reservation WHERE id=" + "'" + d + "';";
        String req = "DELETE FROM reservation WHERE id=?;";

        PreparedStatement ps = connexion.prepareStatement(req);
        Statement stm = connexion.createStatement();
        ResultSet rs = stm.executeQuery(query);

        if (rs.next()) {
            ps.setInt(1, d);
            ps.executeUpdate();
            System.out.println("reservation annulée");

        } else {
            System.out.println("reservation introuvable");
        }
    }

    public void supprimerRes2(Reservation i) throws SQLException {
        String query = "SELECT * FROM reservation WHERE id=" + "'" + i.getId() + "';";
        String req = "DELETE FROM reservation WHERE id=?;";
        String req2 = "UPDATE `cov` SET `nbr`=(nbr+1) WHERE id=?";
        PreparedStatement ps = connexion.prepareStatement(req);
        Statement stm = connexion.createStatement();
        PreparedStatement ps2 = connexion.prepareStatement(req2);
        Statement stm2 = connexion.createStatement();
        ResultSet rs = stm.executeQuery(query);

        if (rs.next()) {
            ps.setInt(1, i.getId());
            ps.executeUpdate();
            ps2.setInt(1, i.getIdC());
            ps2.executeUpdate();
            System.out.println("reservation annulée");

        } else {
            System.out.println("reservation introuvable");
        }
    }
    
    public void supprimerRes3(int idCov,int idEt) throws SQLException {
        String query = "SELECT * FROM reservation WHERE idC=" + "'" + idCov + "' and id_user=" + "'" + idEt + "';";
        String req = "DELETE FROM reservation WHERE idC=? and id_user=?;";
        
        String req2 = "UPDATE `cov` SET `nbr`=(nbr+1) WHERE id=?";
        PreparedStatement ps = connexion.prepareStatement(req);
        Statement stm = connexion.createStatement();
        PreparedStatement ps2 = connexion.prepareStatement(req2);
        Statement stm2 = connexion.createStatement();
        ResultSet rs = stm.executeQuery(query);

        if (rs.next()) {
            ps.setInt(1,idCov);
             ps.setInt(2,idEt);
            ps.executeUpdate();
            ps2.setInt(1,idCov);
            ps2.executeUpdate();
            System.out.println("reservation annulée");

        } else {
            System.out.println("reservation introuvable");
        }
    }

    public List<Reservation> getAllReservations(int x) throws SQLException {
        List<Reservation> r = new ArrayList<>();
        //String req="SELECT * FROM etudiant e  inner join reservation i on (i.id_user=e.id) inner join covoitu c on (i.idC=c.id) WHERE i.idC=?";
        String req1 = "SELECT * FROM covoiturage c  inner join reservation i on (i.id_user=c.idC) inner join etudiant e on (c.idetu=e.id) WHERE e.id=?";
        PreparedStatement ps = connexion.prepareStatement(req1);
        ps.setInt(1, x);
        ResultSet rst = ps.executeQuery(req1);
        while (rst.next()) {
            Reservation p;
            p = new Reservation();
            r.add(p);
        }
        return r;
    }

    /*GET ALL*/
    public List<Reservation> getAllReservation(int id_c) throws SQLException {
        List<Reservation> inscri = new ArrayList<>();
        String req = "SELECT *FROM resevation i inner join etudiant e on (i.id_user=e.id) inner join cov c on(c.id=i.idC) WHERE i.idC=?";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1, id_c);
        ResultSet rst = ps.executeQuery(req);
        while (rst.next()) {
            Reservation p;
            Etudiant e;
            covoitu c;
            e = new Etudiant(rst.getInt("id"), rst.getString("nom"), rst.getString("prenom"));
            c = new covoitu(rst.getString("depart"), rst.getString("arrive"), rst.getDate("temps"), rst.getInt("numero"), rst.getInt("nbr"), rst.getString("type"), rst.getInt("prix"));
            p = new Reservation(rst.getInt("id"), c, e);
            inscri.add(p);
        }
        return inscri;

    }

    public List<Reservation> getAllReservationsID(int x) throws SQLException {
        List<Reservation> r = new ArrayList<>();
        String req = "SELECT * FROM reservation ";

        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Reservation p;
            Etudiant e;
            covoitu c;
            // e = new Etudiant(rst1.getInt("id"),rst1.getString("nom"),rst1.getString("prenom"));
            //c=new covoitu (rst2.getString("depart"),rst2.getString("arrive"),rst2.getDate("temps"),rst2.getInt("numero"),rst2.getInt("nbr"),rst2.getString("type"),rst2.getInt("prix"));
            //p = new Reservation(rst.getInt("id"),c,e);
            if (rst.getInt("id_user") == x) {
                p = new Reservation(rst.getInt("id"), rst.getInt("id_user"), rst.getInt("idC"));
                r.add(p);
            }
        }
        return r;
    }

    public List<covoitu> getAllCovoiturageReservation(int id) throws SQLException {
        
        List<Reservation> listRes = new ArrayList<>();
        listRes = getAllReservationsID(id);
        List<covoitu> r = new ArrayList<>();
        
       
              for (Reservation c : listRes)
                    {
                      String req = "SELECT * FROM cov where id="+c.getIdC();
               Statement stm = connexion.createStatement();           
            ResultSet rs = stm.executeQuery(req);
                if(rs.next())
                {
                   covoitu co = new covoitu(rs.getString("depart"), rs.getString("arrive"), rs.getDate("temps"), rs.getInt("numero"), rs.getInt("nbr"), rs.getString("type"), rs.getInt("prix"),c.getIdC(),id);
                   r.add(co);
                }
            
            
                    }
          
            
        

        return r;

    }
    
    
   // select * from `etudiant` where id in (select id_user from `reservation` where idC=?)
  public List<Etudiant> getAllEtudiants(int id) throws SQLException {
        
        List<Reservation> listRes = new ArrayList<>();
        listRes = getAllReservationsIDCov(id);
        List<Etudiant> r = new ArrayList<>();
        
       
              for (Reservation c : listRes)
                    {
                      String req = "select * from `etudiant` where id in (select id_user from `reservation` where idC="+id+")";
               Statement stm = connexion.createStatement();           
            ResultSet rs = stm.executeQuery(req);
                if(rs.next())
                {
                   Etudiant et = new Etudiant(rs.getString("nom"), rs.getString("prenom"));
                   r.add(et);
                }
            
            
                    }
          
            
        

        return r;

    }
  public List<Reservation> getAllReservationsIDCov(int x) throws SQLException {
        List<Reservation> r = new ArrayList<>();
        String req = "SELECT * FROM reservation ";

        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Reservation p;
            Etudiant e;
            covoitu c;
            // e = new Etudiant(rst1.getInt("id"),rst1.getString("nom"),rst1.getString("prenom"));
            //c=new covoitu (rst2.getString("depart"),rst2.getString("arrive"),rst2.getDate("temps"),rst2.getInt("numero"),rst2.getInt("nbr"),rst2.getString("type"),rst2.getInt("prix"));
            //p = new Reservation(rst.getInt("id"),c,e);
            if (rst.getInt("idC") == x) {
                p = new Reservation(rst.getInt("id"), rst.getInt("id_user"), rst.getInt("idC"));
                r.add(p);
            }
        }
        return r;
    }  
       
}
