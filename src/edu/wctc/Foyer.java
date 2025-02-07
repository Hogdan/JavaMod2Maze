package edu.wctc;

public class Foyer extends Room implements Lootable, Interactable {
    public Foyer(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return """
                You are in a dark foyer, the kitchen you came from is to the South.
                There is a door with mysterious symbols to the East and the boarded up front door lies to the West.
                """;
    }

    // This didn't feel like the best way to handle the unlocking, ideally I would have the player type use key.
    // I though it was okay to handle them in the room's interact method though, I just pass the current room in.
    @Override
    public String interact(Player player, Room room) {
        if (!room.isInteracted()) {
            if (player.getInventory().contains("key")) {
                player.addToScore(5);
                // Key is one use only to not take up inventory space.
                player.removeFromInventory("key");
                // Hardcoding which adjoining room to unlock when interact is used in the foyer while possessing the key.
                room.getAdjoiningRoom('e').setLocked(false);
                room.setInteracted(true);
                return "You use the key to unlock the door.";
            } else {
                return "The door is locked.";
            }
        } else {
            return "The door is unlocked.";
        }
    }

    // There is no hint that this room has loot, I want the player to have to search.
    @Override
    public String loot(Player player) {
        if (this.isLooted()) {
            return "There is nothing to take.";
        }
        this.setLooted(true);
        player.addToInventory("lantern");
        player.addToScore(5);
        return "You find a lantern hanging next to the front door.";
    }

}
