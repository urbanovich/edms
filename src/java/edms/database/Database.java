/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edms.database;

import edms.controllers.LogInController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dzmitry
 */
public class Database {

    protected Db db;
    
    public Database(Db db) {
        this.db = db;
    }
    
    public void createTables() {
        try {
            this.createUserTable(db);
            this.createUserRoleTable(db);

        } catch (SQLException ex) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void createUserTable(Db db) throws SQLException {
        db.statement.execute(
                "create table if not exists user( "
                    + "id int(10) primary key auto_increment, "
                    + "firstname varchar(100), "
                    + "lastname varchar(100), "
                    + "login varchar(100), "
                    + "password varchar(100), "
                    + "role_id int(10) "
                + ") engine=myisam character set=utf8;"
        );
    }
    
    protected void createUserRoleTable(Db db) throws SQLException {
        db.statement.execute(
                "create table if not exists user_role( "
                    + "id int(10) primary key auto_increment, "
                    + "title varchar(100) "
                + ") engine=myisam character set=utf8;"
        );
    }
}
