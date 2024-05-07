package org.example.pokedex;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pokedex_ADD {

    private Stage stage;
    private Scene scene;

    @FXML
    private Label success_label;
    @FXML
    private TextField name_text, type_text, height_text,weight_text,prev_text,next_text,image_path_text,fav_text;
    @FXML
    private TextArea description_text;


    public void switchtoPokedexDashboardScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pokedex_Dashboard.fxml"));
        Parent root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addPokemon() throws SQLException {
        Database_Connection connectNow = new Database_Connection();
        Connection connectDB = connectNow.getConnection();

        PreparedStatement pstmt = connectDB.prepareStatement("INSERT INTO `pokedex`.`creatures` " +
                "(`creature_name`, `creature_description`, `creature_image`,`creature_type`,`height`,`weight`, `prev_gen`, `next_gen`,`favourite`)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)");

        pstmt.setString(1,name_text.getText());
        pstmt.setString(2,description_text.getText());
        pstmt.setString(3,image_path_text.getText());
        pstmt.setString(4,type_text.getText());
        pstmt.setString(5,height_text.getText());
        pstmt.setString(6,weight_text.getText());
        pstmt.setString(7,prev_text.getText());
        pstmt.setString(8,next_text.getText());
        pstmt.setString(9,fav_text.getText());
        // Executing the statement
        pstmt.executeUpdate();
        System.out.println("Record inserted successfully");
        success_label.setText("Successfully Added");
    }

}
