package edu.wctc;

public class SouthOfHouse extends Room implements Lootable{
    public SouthOfHouse(String name) {
        super(name);
    }

    // More verbose descriptions include hints at which directions can be traveled.
    @Override
    public String getDescription() {
        return """
                You are facing the south side of a white house, all of the windows are boarded up.
                There is some debris leaning against the wall near a heavily reinforced cellar door.
                Across the field to the South lies a forest.""";
    }

    // Loot text should change once the player has picked up the item.
    @Override
    public String loot(Player player) {
        if (this.isLooted()) {
            return "You have already searched the rubble.";
        }
        this.setLooted(true);
        player.addToInventory("crowbar");
        player.addToScore(5);
        return "You find a crowbar in the rubble.";
    }
    
}
