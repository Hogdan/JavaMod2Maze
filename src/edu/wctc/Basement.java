package edu.wctc;

public class Basement extends Room implements Lootable, Tripable {
    public Basement(String name) {
        super(name);
    }
    
    @Override
    public String getDescription() {
        return """
            With the lantern in hand you survive the descent into the cellar. You can hear the sound of water dripping.
            Some shelves have been knocked over and their contents lay strewn about the damp stone floor.
            An door to the south has been caved in with rubble. The stairs leading up to the kitchen are behind you.
            """;

    }

    @Override
    public String loot(Player player) {
        if (this.getLooted()) {
            return "You have already looted this room.";
        }
        this.setLooted(true);
        player.addToScore(5);
        player.addToInventory("key");
        return "You found a key!";
    }

    // The basement is the only kill screen currently implemented but this could be applied to any number of rooms.
    @Override
    public String trip(Player player) {
        player.addToScore(-10);
        return "You trip on the stairs in the darkness and break your neck.";
    }

}
