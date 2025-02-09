package edu.wctc.rooms;

public class Foyer extends Room implements Lootable, Interactable {
    public Foyer(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        // This is a workaround for the stuck window since it is the room itself that is considered locked.
        // If the player reaches the foyer by another route the kitchen unlocks but the window remains stuck.
        if (this.south.isLocked()) {
            this.south.setLocked(false);
            this.south.getAdjoiningRoom('e').setWest(null);
            this.south.setEast(null);
        }

        return """
                You are in a dark foyer, the kitchen is down the Southern hallway.
                A coat rack and umbrella stand are near the barricaded front door to the West.
                On the opposite side of the room there is a sturdy door encircled by mysterious symbols.
                """;
    }

    // Currently the interact command is used to unlock the door in the foyer if the player posses the key.
    // This may change in the future if multi word commands are implemented.
    @Override
    public String interact(Player player, Room room) {
        if (room.isInteracted()) return "There is nothing else to interact with.";
        if (!player.getInventory().contains("key")) return "You can't unlock the door without a key.";
        room.getAdjoiningRoom('e').setLocked(false);
        player.removeFromInventory("key");
        room.setInteracted(true);
        player.addToScore(5);
        return "You use the key to unlock the door.";
        }

    @Override
    public String loot(Player player) {
        if (this.isLooted()) return "There is nothing to take.";
        this.setLooted(true);
        player.addToInventory("lantern");
        player.addToScore(5);
        return "You find a lantern hanging next to the front door.";
    }

}
