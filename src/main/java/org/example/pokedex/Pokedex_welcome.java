package org.example.pokedex;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.Console;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Pokedex_welcome {
    private Stage stage;
    private Scene scene;
    @FXML
    private Label welcomeText;


    public void switchtoPokedexDashboardScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Pokedex_Dashboard.fxml"));
        Parent root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        //stage.setResizable(false);
        stage.show();
    }
    /*public void initialize(ActionEvent event)
    {
        Database_Connection connection_data = new Database_Connection();
        Connection connect = connection_data.getConnection();
        String verify = "Insert Into pokedex.test (idtest,testName) values ('323','ww')";
        try {
            Statement statement = connect.createStatement();
            int queryResult = statement.executeUpdate(verify);
            if (queryResult>0) {
                System.out.println("WELCOME");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    public void exitClicked(ActionEvent event)
    {
        Platform.exit();
    }
}