/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covbd.entities;

import static java.awt.SystemColor.text;
import java.sql.Timestamp;
import javafx.scene.control.Button;

/**
 *
 * @author esprit
 */
public class covoitu {
    private String depart;
    private String arrive;
    private String temps;
    private int numero;
    private int id;
    private int nbr;
    private int type;
    private int prix;
//  private Button button =new Button() ;

//    public covoitu(String text, String text0, String text1, String text2, String text3, String text4) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    
     @Override
    public String toString() {
        return "covoiturage: " + "depart  " + depart + "arrive "+ arrive + "temps  " +"nombre de places"+nbr + temps +"id"+id+"type"+type+"prix"+prix ;
    }    

    public covoitu(String depart, String arrive, String temps, int numero,  int nbr,int id, int type, int prix) {
        this.depart = depart;
        this.arrive = arrive;
        this.temps = temps;
        this.numero = numero;
        this.nbr = nbr;
        this.id = id;
        this.type = type;
        this.prix = prix;
    }

    public covoitu (String depart, String arrive, String temps,int nbr,int numero,int type,int prix) {
        this.depart = depart;
        this.arrive = arrive;
        this.temps = temps;
        this.numero=numero;
        this.nbr=nbr;
        this.type=type;
        this.prix=prix;
    }
public covoitu (int id,String depart, String arrive, String temps,int nbr,int numero,int type,int prix){}
    public covoitu() {
    }
    

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getPrix() {
        return prix;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public int getId() {
        return id;
    }

    public int getNbr() {
        return nbr;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDepart() {
        return depart;
    }

    public String getArrive() {
        return arrive;
    }

    public String getTemps() {
        return temps;
    }

//    public void setTemps(Timestamp temps) {
//        this.temps = temps;
//    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    
    public int getNumero() {
        return numero;
    }

   /* public covoitu(String depart, String arrive, String temps, int numero, int nbr, int type, int prix, Button button) {
        this.depart = depart;
        this.arrive = arrive;
        this.temps = temps;
        this.numero = numero;
        this.nbr = nbr;
        this.type = type;
        this.prix = prix;
        this.button = button;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }*/

    
    
}
