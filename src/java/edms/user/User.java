/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edms.user;

import edms.controllers.LogInController;
import edms.database.Db;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dzmitry
 */
public class User implements Entity {

    private String table = "user";

    public static boolean isExists(String name, String password) {

        Db db = new Db();

        password = User.md5(password);
        System.out.println(password);
        ResultSet result = db.query(
                "select * from `user` where `login` = \"" + name + "\" and `password` = \"" + password + "\""
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
