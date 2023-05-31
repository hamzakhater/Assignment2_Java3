/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.Account;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Yahya
 */
public class AccountsManagmentController implements Initializable {

    @FXML
    private TextField accontSearchTF;
    public Statement statement;
    @FXML
    private TableView<Account> table_view;
    @FXML
    private TableColumn<Account, Integer> id;
    @FXML
    private TableColumn<Account, Integer> account_number;
    @FXML
    private TableColumn<Account, String> user_name;
    @FXML
    private TableColumn<Account, String> currency;
    @FXML
    private TableColumn<Account, Integer> balance;
    @FXML
    private TableColumn<Account, String> creation_data;

    static int index;

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

        id.setCellValueFactory(new PropertyValueFactory("id"));
        account_number.setCellValueFactory(new PropertyValueFactory("account_number"));
        user_name.setCellValueFactory(new PropertyValueFactory("username"));
        currency.setCellValueFactory(new PropertyValueFactory("currency"));
        balance.setCellValueFactory(new PropertyValueFactory("balance"));
        creation_data.setCellValueFactory(new PropertyValueFactory("creation_date"));
    }

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToUsersManagment();
    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
    }

    @FXML
    private void showAllAccounts(ActionEvent event) {
        try {
            allAccount();
        } catch (SQLException ex) {
            Logger.getLogger(AccountsManagmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updateSelectedAccount(ActionEvent event) {
        Account account = table_view.getSelectionModel().getSelectedItem();
        index = account.getId();
        ViewManager.adminPage.changeSceneToUpdataAccountsManagment();

    }

    @FXML
    private void deleteSelectedAccount(ActionEvent event) throws SQLException {
        Account account = table_view.getSelectionModel().getSelectedItem();
        String sel = "DELETE FROM accounts WHERE `accounts`.`id` =" + account.getId() + "";
        this.statement.executeUpdate(sel);
        allAccount();
    }

    @FXML
    private void searchForAnAccount(ActionEvent event) {

    }

    @FXML
    private void CreataNewAccount(ActionEvent event) {
        ViewManager.adminPage.changeSceneToCreateAccount();
    }

    void allAccount() throws SQLException {
        ResultSet resultSet = this.statement.executeQuery("SELECT * FROM `accounts`");
        Account account;
        table_view.getItems().clear();
        while (resultSet.next()) {
            account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setAccount_number(resultSet.getString("account_number"));
            account.setBalance(resultSet.getString("balance"));
            account.setCreation_date(resultSet.getString("creation_date"));
            account.setUsername(resultSet.getString("username"));
            account.setCurrency(resultSet.getString("currency"));
            System.out.println(account.toString());
            table_view.getItems().addAll(account);
        }
    }

}
