package edu.wctc;

import java.util.ArrayList;

public class Player {
    private int lives;
    private final ArrayList<String> inventory;

    public Player() {
        this.lives = 3;
        this.inventory = new ArrayList<>();
    }

    public void addToInventory(String item) {
        inventory.add(item);
    }

    public void addToLives(int points) {
        lives += points;
    }

    public String getInventory() {
        if (inventory.isEmpty()) {
            return "You have nothing.";
        }
        return String.join(", ", inventory);
    }

    public int getLives() {
        return lives;
    }
}
