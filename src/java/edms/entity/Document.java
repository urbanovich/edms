/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edms.entity;

import edms.database.Db;
import java.sql.ResultSet;

/**
 *
 * @author dzmitry
 */
public class Document implements Entity {

    private static String table = "document";
    
    protected int id;
    
    protected int userId;
    
    protected String title;
    
    protected String content;
    
    public Document(String title, String content, int userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
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
