/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edms.entity;

import edms.controllers.LogInController;
import edms.database.Db;
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
public class Document implements Entity {

    private static String table = "document";
    
    protected int id;
    
    protected int userId;
    
    protected User user;
    
    protected String title;
    
    protected String content;
    
    protected String dateAdd;
    
    protected String dateUpd;
    
    public Document(
            int id, 
            String title, 
            String content, 
            int userId, 
            String dateAdd, 
            String dateUpd
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }
    
    public Document(
            int id, 
            String title, 
            String content, 
            User user, 
            String dateAdd, 
            String dateUpd
    ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getContent() {
        return this.content;
    }
    
    public String getDateAdd() {
        return this.dateAdd;
    }
    
    public String getDateUpd() {
        return this.dateUpd;
    }
    
    public User getUser() {
        return this.user;
    }
    
    public static List<Document> getDocumentsByUserId(int id) {
        List<Document> documents = new ArrayList<>();
        Db db = new Db();
        ResultSet result = db.query(
                "select * from " + Document.table + " where id = " + id
        );
        
        try {
            
            while(result.next()) {
                documents.add(
                        new Document(
                                Integer.parseInt(result.getString("id")),
                                result.getString("title"), 
                                result.getString("content"), 
                                new User(Integer.parseInt(result.getString("user_id"))),
                                result.getString("date_add"), 
                                result.getString("date_upd")
                        )
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return documents;
    }
    
    @Override
    public boolean create() {
        boolean result = false;
        Db db = new Db();
        result = db.execute(
            "insert into " + Document.table + " (title, content, user_id) "
                    + "values("
                    + "\"" + this.title + "\","
                    + "\"" + this.content + "\","
                    + "\"" + this.userId + "\""
                    + ")"
        );
        
        return result;
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
