/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edms.entity;

import edms.controllers.LogInController;
import edms.database.Db;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dzmitry
 */
public class User implements Entity {

    private static String table = "user";

    public int id = 0;
    
    public String firstname = "";
    
    public String lastname = "";
    
    public String login = "";
    
    public int roleId = 0;

    public String getName() {
        return this.firstname + " " + this.lastname;
    }
    
    public User(int userId) {
        
        ResultSet user = User.getUser(userId);
        
        try {
            while(user.next()) {
                this.id = user.getInt("id");
                this.firstname = user.getString("firstname");
                this.lastname = user.getString("lastname");
                this.login = user.getString("login");
                this.roleId = user.getInt("role_id");
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getFirstname() {
        return this.firstname;
    }
    
    public String getLastname() {
        return this.lastname;
    }
    
    public static boolean isExists(String name, String password) {

        Db db = new Db();
        password = User.md5(password);
        ResultSet result = db.query(
            "select * from `" + User.table + "` where `login` = \"" + name + "\" and `password` = \"" + password + "\""
        );
        
        try {
            if (result.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public List<Document> getDocuments() {
        List<Document> documents = new ArrayList<>();
        
        documents = Document.getDocumentsByUserId(this.id);
        
        return documents;
    }
    
    public static User getUser(String login, String password) {
        Db db = new Db();
        password = User.md5(password);
        ResultSet result = db.query(
            "select * from `" + User.table + "` where `login` = \"" + login + "\" and `password` = \"" + password + "\""
        );
        
        int userId = 0;
        
        try {
            while(result.next()) {
                userId = result.getInt("id");
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        User user = new User(userId);
        return user;
    }
    
    public static ResultSet getUser(int userId) {
        
        Db db = new Db();
        ResultSet result = db.query(
            "select * from `" + User.table + "` where `id` = \"" + userId + "\""
        );
        
        return result;
    }
    
    public static ResultSet getUsers() {
        
        Db db = new Db();
        ResultSet result = db.query(
            "select * from `" + User.table + "` where 1"
        );
        
        return result;
    }
    
    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<User>();
        Db db = new Db();
        ResultSet result = db.query(
            "select * from " + User.table + " where 1"
        );
        
        try {
            
            while(result.next()) {
                users.add(
                    new User(Integer.parseInt(result.getString("id")))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return users;
    }

    public static String md5(String md5) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            result = sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return result;
    }

    @Override
    public boolean create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
