package edu.wctc;

public class LootRoom extends Room implements Lootable {
    public LootRoom(String name) {
        super(name);
    }
    
    @Override
    public String getDescription() {
        return "The lights are dim and flicker, it is hard to see in this room.";
    }
    
    private boolean isLooted;

    @Override
    public String loot(Player player) {
        if (isLooted) {
            return "There is nothing left to loot.";
        } else {
            isLooted = true;
            player.addToInventory("Shoe");
            return "You found a Shoe!";
        }
    }
}
