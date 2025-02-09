package edu.wctc.rooms;

public class Kitchen extends Room implements Lootable {
    public Kitchen(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return """
                Dust motes swirl in the ribbons of sunlight that filter through the boarded up windows.
                The kitchen has not been disturbed in some time, a brown sack sits on the table.
                There is a passage to the foyer to the North and a boarded window you to the East.
                In the corner of the room, a narrow set of stairs descends into total darkness.
                You wouldn't survive going Down there without a light.
                """;
    }

    // I was thinking of having a wolf attack the player if they were carrying the sandwich in the woods.
    // Or keeping track of how many moves had been made and starving the player if they took too long without sustinance.
    @Override
    public String loot(Player player) {
        if (this.isLooted()) {
            return "You have already searched the sack.";
        }
        this.setLooted(true);
        player.addToScore(10);
        player.addToInventory("tunafish sandwich");
        player.addToInventory("bottle of water");
        return """
                You open the sack.
                Inside is a tunafish sandwich and a bottle of water.
                You take them both.
                """;
    }
}
