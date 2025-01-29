package edu.wctc;

public class LootRoom extends Room implements Lootable {
    public LootRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "It looks like there is something in this room.";
    }

    @Override
    public String loot(Player player) {
        player.addToInventory("Gold Coin");
        return "You found a Gold Coin!";
    }
}
