/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edms.database;

/**
 *
 * @author dzmitry
 */
public interface Query {
    
    public boolean create();
    public boolean update();
    public boolean delete();
    public boolean query();
    
}
