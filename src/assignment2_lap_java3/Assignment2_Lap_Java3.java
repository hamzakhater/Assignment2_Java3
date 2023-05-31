/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment2_lap_java3;

import View.ViewManager;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author hamza
 */
public class Assignment2_Lap_Java3 extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        ViewManager.openRegisterPage();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        launch(args);
    }

}
