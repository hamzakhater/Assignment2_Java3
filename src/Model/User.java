/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hamza
 */
public class User {

    private int id;
    private int Name;
    private int PassWord;
    private int email;
    private int gender;
    private int role;

    public User(int Name, int PassWord, int email, int gender, int role) {
        this.Name = Name;
        this.PassWord = PassWord;
        this.email = email;
        this.gender = gender;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return Name;
    }

    public void setName(int Name) {
        this.Name = Name;
    }

    public int getPassWord() {
        return PassWord;
    }

    public void setPassWord(int PassWord) {
        this.PassWord = PassWord;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int save() throws ClassNotFoundException, SQLException {
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCountre = 0;
        String sql = "INSERT INTO USERS (ID , USERNAME , PASSWIRD , EMAIL ,GENDER ,ROLE ) VALUES (?,?,?,?,?,?)";
        ps.setInt(1, this.getId());
        ps.setInt(2, this.getName());
        ps.setInt(3, this.getPassWord());
        ps.setInt(4, this.getEmail());
        ps.setInt(5, this.getGender());
        ps.setInt(6, this.getRole());
        recordCountre = ps.executeUpdate();
        if (recordCountre > 0) {
            System.out.println(this.getName()
                    + "User wes added Syccessfully!");
        }
        if (ps != null) {
            ps.close();
        }
        c.close();
        return recordCountre;
    }

//    public static ArrayList<User> getAllUser () throws ClassNotFoundException, SQLException{
//        Connection c = DB.getInstance().getConnection();
//        PreparedStatement ps = null;
//        int recordCountre = 0;
//    }
}
