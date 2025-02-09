package edu.wctc.rooms;

public class SouthOfHouse extends Room implements Lootable{
    public SouthOfHouse(String name) {
        super(name);
    }

    // More verbose descriptions include hints at which directions can be traveled.
    @Override
    public String getDescription() {
        return """
                You are facing the south side of a white house, all of the windows are boarded up.
                There is rubble piled against the wall. Stairs leading down to the cellar have been filled in.
                Forest stretches out past the field to the South. A path runs around the house to the East and West.
                """;
    }

    // Loot text should change once the player has picked up the item.
    @Override
    public String loot(Player player) {
        if (this.isLooted()) {
            return "There is nothing left to take from the rubble.";
        }
        this.setLooted(true);
        player.addToInventory("crowbar");
        player.addToScore(5);
        return "You find a rusty crowbar in the rubble.";
    }
    
}
