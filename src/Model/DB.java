/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author hamza
 */
public class DB {

    private static DB db = null;

    public DB() {

    }
    public static DB getInstance() {
        if (db == null) {
            return new DB();
        } else {
            return db;
        }
    }
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
    }
}
