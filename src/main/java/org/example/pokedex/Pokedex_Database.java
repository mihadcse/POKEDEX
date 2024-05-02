package org.example.pokedex;


import javafx.scene.control.Button;

public class Pokedex_Database {
    Integer ID;
    String Name, Type;

    public Pokedex_Database(Integer ID, String name, String type) {
        this.ID = ID;
        Name = name;
        Type = type;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}

