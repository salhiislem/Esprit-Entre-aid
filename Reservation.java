/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covbd.entities;

/**
 *
 * @author esprit
 */
public class Reservation {
    
    private int id;
   private covoitu c;
    private Etudiant e;
   // private int nbre_place;
    
    public Reservation(covoitu c, Etudiant e) {
        this.e = e;
        this.c = c;
        System.out.println(c);
       // this.nbre_place = nbre_place;
    }
   
 public Reservation() {
    }
 public Reservation(int ide,int idc) {
        e.setId(id);
        c.setId(id);
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setC(covoitu c) {
        this.c = c;
    }

    public void setE(Etudiant e) {
        this.e = e;
    }

//    public void setNbre_place(int nbre_place) {
//        this.nbre_place = nbre_place;
//    }

    public int getId() {
        return id;
    }
    public int getIDC() {
        return (c.getId());
    }
    public covoitu getC() {
        return c;
    }

    public Etudiant getE() {
        return e;
    }

//    public int getNbre_place() {
//        return nbre_place;
//    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", c=" + c + ", e=" + e + ", nbre_place=" + '}';
    }

   
   
    
    
}
