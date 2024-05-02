package org.example.pokedex;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.controlsfx.control.PropertySheet;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.IdentityHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pokedex_Database_Controller {

    private Stage stage;
    private Scene scene;

    int ID_number_creature;

    @FXML
    TextField keywordTextField;

    public void switchtoPokedexDashboardScene(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pokedex_Dashboard.fxml"));
        Parent root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCreatureScene(ActionEvent event, int creatureID) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pokedex_creature.fxml")); // Ensure path is correct
        Parent root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private TableView<Pokedex_Database> pokedexDatabaseTableView;
    @FXML
    private TableColumn<Pokedex_Database,Integer> pokedexDatabaseIDTableColumn;
    @FXML
    private TableColumn<Pokedex_Database,String>pokedexDatabaseNameTableColumn;
    @FXML
    private TableColumn<Pokedex_Database,String>pokedexDatabaseTypeTableColumn;

    ObservableList<Pokedex_Database> pokedexDatabaseObservableList = FXCollections.observableArrayList();

    public void initialize() {
        Database_Connection connectNow = new Database_Connection();
        Connection connectDB = connectNow.getConnection();

        String adminproviderTableViewquery = "Select id, creature_name,creature_type from pokedex.creatures";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery (adminproviderTableViewquery);
            while (queryOutput.next()) {
                Integer queryID = queryOutput.getInt("id");
                String queryname = queryOutput.getString( "creature_name");
                String queryType = queryOutput.getString("creature_type");

                pokedexDatabaseObservableList.add(new Pokedex_Database(queryID, queryname, queryType));
            }

            pokedexDatabaseIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
            pokedexDatabaseNameTableColumn.setCellValueFactory (new PropertyValueFactory<>("Name"));
            if (pokedexDatabaseTypeTableColumn != null) {
                pokedexDatabaseTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("Type"));
            }

            pokedexDatabaseTableView.setItems(pokedexDatabaseObservableList);

            //Initial filtered list
            FilteredList<Pokedex_Database> filteredData = new FilteredList<>(pokedexDatabaseObservableList, b -> true);
            keywordTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate (Pokedex_Database -> {
                    // If no search value then display all records or whatever records it current have. no changes.
                    if (newValue.isEmpty() || newValue.isBlank () || newValue == null) {
                        return true;
                    }
                    String search_Keyword = newValue.toLowerCase();
                    if (Pokedex_Database.getName().toLowerCase().indexOf(search_Keyword) > -1) {
                        return true; // Means we found a match in ProductName
                    }
                    else if (Pokedex_Database.getType().toLowerCase().indexOf(search_Keyword) > -1) {
                        return true;
                    } else
                    return false;
                });
            });

            SortedList<Pokedex_Database> sortedData = new SortedList<>(filteredData);
            // Bind sorted result with Table View
            sortedData.comparatorProperty().bind(pokedexDatabaseTableView.comparatorProperty());
            // Apply filtered and sorted data to the Table View
            pokedexDatabaseTableView.setItems(sortedData);
            //show just one selected rov
        }
        catch(SQLException e) {
            Logger.getLogger (Pokedex_Database_Controller.class.getName()).log (Level. SEVERE,null, e);
            e.printStackTrace();
        }
    }

/*
public void insertImage() throws SQLException, FileNotFoundException {
        Database_Connection connectNow = new Database_Connection();
        Connection connectDB = connectNow.getConnection();
        PreparedStatement pstmt = connectDB.prepareStatement("INSERT INTO `pokedex`.`creatures` " +
                "(`id`, `creature_name`, `creature_description`, `creature_evolution`, `creature_image`,`creature_type`,`height`,`weight`)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

        pstmt.setInt(1, 1);
        pstmt.setString(2, "Bulbasaur");
        pstmt.setString(3, "Bulbasaur is a Grass/Poison type Pokémon introduced in Generation 1.\n" +
                    "\n" +
                    "Bulbasaur is a small, mainly turquoise amphibian Pokémon with red eyes and a green bulb on its back. It is based on a frog/toad, with the bulb resembling a plant bulb that grows into a flower as it evolves.\n" +
                    "\n" +
                    "Bulbasaur is notable for being the very first Pokémon in the National Pokédex. It is one of the three choices for a starter Pokémon in the original Game Boy games, Pokémon Red & Blue (Red & Green in Japan), along with Charmander and Squirtle");
        pstmt.setString(4, "Bulbasaur\nGrass · Poison,Ivysaur Grass · Poison,Venusaur Grass · Poison");

            // Inserting Blob type
        //InputStream in = new FileInputStream("D:/IUT SEMESTER 4/CSE 4402/Pokedex/src/main/resources/org/example/pokedex/bulbasaur.jpg");
        pstmt.setString(5, "D:/IUT SEMESTER 4/CSE 4402/Pokedex/src/main/resources/org/example/pokedex/bulbasaur.jpg");
        pstmt.setString(6,"Grass");
        pstmt.setString(7,"0.7 m ");
        pstmt.setString(8,"6.9 kg");
            // Executing the statement
        pstmt.executeUpdate();
        System.out.println("Record inserted successfully");
    }
*/

    public void Selection(ActionEvent event) throws IOException {
        /*TablePosition pos = pokedexDatabaseTableView.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        //System.out.println(pos);
        System.out.println(row);*/

        ObservableList<Pokedex_Database> pokedexlist;
        pokedexlist=pokedexDatabaseTableView.getSelectionModel().getSelectedItems();
        System.out.println("ID = ");
        System.out.println (pokedexlist.get(0).getID());


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pokedex_creature.fxml"));
        Parent root = fxmlLoader.load();
        Pokedex_Creature po_cr = fxmlLoader.getController();
        po_cr.initialize(pokedexlist.get(0).getID());
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void click(ActionEvent event)
    {
        TablePosition pos1 = pokedexDatabaseTableView.getSelectionModel().getSelectedCells().get(0);
        int row1 = pos1.getRow();
        // Item here is the table view type:
        PropertySheet.Item item = (PropertySheet.Item) pokedexDatabaseTableView.getItems().get(row1);
        TableColumn col = pos1.getTableColumn();
        // this gives the value in the selected cell:
        String data = (String) col.getCellObservableValue(item).getValue();
        System.out.println("DATA ==== "+ data);
    }
}

