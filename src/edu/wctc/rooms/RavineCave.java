package edu.wctc.rooms;

public class RavineCave extends Room implements Lootable{
    public RavineCave(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return """
                You are standing in the mouth of a rocky cave. The empty void of the ravine is to the east.
                There are signs that this place had been used for shelter in the past.
                The cave is narrow and dark, but you feel a cool current of air flowing from the west.
                """;
    }

    @Override
    public String loot(Player player) {
        if (this.isLooted()) return "There is nothing to loot.";
        player.addToScore(5);
        player.addToInventory("sword");
        this.setLooted(true);
        return "You find an elegent looking sword hidden in the cave.";
    }

}
