package edu.wctc;

import java.util.ArrayList;

public class Player {
    private int score;
    private int actions;
    private final ArrayList<String> inventory;

    public Player() {
        this.score = 0;
        this.actions = 0;
        this.inventory = new ArrayList<>();
    }

    public void addToInventory(String item) {
        inventory.add(item);
    }

    public void removeFromInventory(String item) {
        inventory.remove(item);
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int points) {
        score += points;
    }

    public int getActions() {
        return actions;
    }

    public void incrementActions() {
        actions++;
    }

    public String getInventory() {
        if (inventory.isEmpty()) {
            return "You have: nothing.";
        }
        return "You have: " + String.join(", ", inventory);
    }

}
