package edu.wctc.rooms;

// This is the first room of the game.
public class WestOfHouse extends Room implements Interactable, Lootable {
    public WestOfHouse(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return """
                You are standing in an open field, west of a white house with a boarded front door.
                There is a small mailbox here. Past the end of the field trees stretch in all directions.
                A dirt path leads around the house to the south.
                """;
    }

    // Interact nets the player points but only the first time.
    @Override
    public String interact(Player player, Room room) {
        if (!room.isInteracted()) {
            room.setInteracted(true);
            player.addToScore(5);
        }
        return """
                You open the mailbox and find a leaflet, it reads:
                Welcome to Zerk, the text-based adventure game.
                Not to be confused with Zork, the origial text-based adventure game.
                CoPilot might have stolen some text, but this game is my own work.
                Dan Hogan | 2025
                """;
    }

    // Some lootable rooms only have flavor text.
    @Override
    public String loot(Player player) {
        return "You don't want to take the leaflet.";
    }

}
