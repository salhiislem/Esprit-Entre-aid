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
import workshopdbPI.entities.Message;
import workshopdbPI.utils.Mydb1;

/**
 *
 * @author Hajbi
 */
public class MessageService {
      Connection connexion;

    public MessageService() {
        connexion = Mydb1.getInstance().getConnection();
    }
    
    public void ajouterMessage(Message m,int id) throws SQLException
    {
        String req=" INSERT INTO `Message` (`msg`,`idd`,`idE`) VALUES ('"+m.getMsg()+"','"+id+"','"+m.getIdE()+"')";
        
        Statement stm= connexion.createStatement();
        stm.executeUpdate(req);    
    }
    
     public List<Message> getAllMessages() throws SQLException
    {
        List<Message> messages = new ArrayList <>();
        String req="select msg from Message";
        PreparedStatement ps=connexion.prepareStatement(req);
        Statement stm= connexion.createStatement();
         ResultSet rst = stm.executeQuery(req);
         
         while(rst.next()){
             Message m = new Message(rst.getString("msg"));
             messages.add(m);
//             Message m =new Message(rst.getString("msg"));
//             messages.add(m);
//                System.out.print(rst.getInt("idM")+"\t");
               //System.out.print(rst.getString("msg")+"\t");
//             System.out.print(rst.getString("nom_discussion")+"\t");
         }
         return messages;
     }
     
       public List<Message> getAllMessagesById(int id) throws SQLException
    {
        List<Message> messages = new ArrayList <>();
        String req="select * from Message where idd="+id;
        PreparedStatement ps=connexion.prepareStatement(req);
        Statement stm= connexion.createStatement();
         ResultSet rst = stm.executeQuery(req);
         
         while(rst.next()){
             Message m = new Message(rst.getInt("idM"),rst.getString("msg"),rst.getInt("idd"),rst.getInt("idE"));
             messages.add(m);
            
//             System.out.print(rst.getInt("idM")+"\t");
//             System.out.print(rst.getString("msg")+"\t");
//             System.out.print(rst.getInt("idd")+"\t");
//             System.out.print(rst.getInt("idE")+"\t");
         }
         return messages;
     }
     
    
    public void modifierMessage(int i,Message m) throws SQLException{
        String req=" update Message set msg=? WHERE idE=?";
        String query=" select * from message WHERE idE="+i;
        PreparedStatement ps=connexion.prepareStatement(req);
        Statement stm=connexion.createStatement();
        ResultSet res=stm.executeQuery(query);
        if(res.next())
        {
        ps.setString(1,m.getMsg());
        ps.setInt(2,i);
        ps.executeUpdate();
        System.out.println("update terminé ");
        }
        else
            System.out.println("Message inexistant");
     }
     
      public void supprimerMessage(int i,int j) throws SQLException{
        String req = "DELETE FROM Message WHERE idE=? and idM=?";
         PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1,i);
        ps.setInt(2,j);
        ps.executeUpdate();
        System.out.println("Message supprimé !");
        }
    
}
