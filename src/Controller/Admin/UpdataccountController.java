/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Admin;

import static Controller.Admin.AccountsManagmentController.index;
import Model.Account;
import Model.User;
import View.ViewManager;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class UpdataccountController implements Initializable {

    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private Button saveUpdata;
    @FXML
    private Button cancelBtn;
    @FXML
    private Label UserName;
    @FXML
    private TextField username;
    @FXML
    private TextField AccountNumber;
    @FXML
    private TextField Currency;
    @FXML
    private TextField Balance;
    @FXML
    private TextField CreationDate;

    public Statement statement;

    int indexs = index;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connetion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
            this.statement = connetion.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
    }

    @FXML
    private void saveUpdata(ActionEvent event) throws SQLException {
        String sel = "UPDATE `accounts` SET `account_number` = " + AccountNumber.getText() + " , `username` = '" + UserName.getText()
                + "', `currency` = '" + Currency.getText() + "' , `balance` = '" + Balance.getText() + "' , `creation_date` = '" + CreationDate.getText() + "'  WHERE `accounts`.`id` =" + index + ";";
        System.out.println(sel);
        this.statement.executeUpdate(sel);
        UserName.setText("");
        AccountNumber.setText("");
        Currency.setText("");
        Balance.setText("");
        CreationDate.setText("");
        index = 0;
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

    @FXML
    private void cancel(ActionEvent event) throws SQLException {
        ResultSet resultSet = this.statement.executeQuery("SELECT * FROM `accounts` WHERE `accounts`.`id` = " + index + "");
        Account account = null;
        while (resultSet.next()) {
            account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setAccount_number(resultSet.getString("account_number"));
            account.setUsername(resultSet.getString("username"));
            account.setBalance(resultSet.getString("balance"));
            account.setCurrency(resultSet.getString("currency"));
            account.setCreation_date(resultSet.getString("creation_date"));
            System.out.println(account.toString());
        }
        username.setText(account.getUsername());
        AccountNumber.setText(account.getAccount_number());
        Currency.setText(account.getCurrency());
        Balance.setText(account.getBalance());
        CreationDate.setText(account.getCreation_date());
    }

}
