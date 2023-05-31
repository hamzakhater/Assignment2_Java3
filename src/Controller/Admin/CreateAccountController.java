/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Admin;

import View.ViewManager;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
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
public class CreateAccountController implements Initializable {

    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private Button saveNewUserBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Label UserName;
    @FXML
    private TextField AccountNumber;
    @FXML
    private TextField Currency;
    @FXML
    private TextField Balance;
    @FXML
    private TextField CreationDate;

    public Statement statement;
    @FXML
    private TextField username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connetion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
            this.statement = connetion.createStatement();
        } catch (Exception e) {
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
    private void saveNewUser(ActionEvent event) throws SQLException {
        String userName = UserName.getText();
        String accountNumber = AccountNumber.getText();
        String currency = Currency.getText();
        String balance = Balance.getText();
        String creationDate = CreationDate.getText();
        String sql = "INSERT INTO `accounts` "
                + "(`id`, `account_number`, `username`, `currency`, `balance`, `creation_date`)"
                + "  VALUES (" + null + " ," + accountNumber + ",'" + userName + "','"
                + currency + "', '" + balance + "', '" + creationDate + "');";
        this.statement.executeUpdate(sql);
        UserName.setText("");
        AccountNumber.setText("");
        Currency.setText("");
        Balance.setText("");
        cancelUserCreation(event);

    }

    @FXML
    private void cancelUserCreation(ActionEvent event) {
        ViewManager.adminPage.changeSceneToAccountsManagment();
    }

}
