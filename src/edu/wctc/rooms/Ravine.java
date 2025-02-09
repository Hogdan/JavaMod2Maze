package edu.wctc.rooms;

public class Ravine extends Room implements Interactable {
    public Ravine(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return """
            You stand at the edge of a deep ravine which runs north to south, from the mountains to the forest.
            It is much too wide and steep to traverse. A path through the trees leads east.
            """;
    }

    @Override
    public String interact(Player player, Room room) {
        if (this.isInteracted()) return "The rope hangs over the edge of the ravine.";
        if (!player.getInventory().contains("rope")) return "You aren't carrying anything that could help you here.";
        this.setInteracted(true);
        room.getAdjoiningRoom('d').setLocked(false);
        player.removeFromInventory("rope");
        player.addToScore(5);
        return "You tie the rope around a tree near the edge allowing descent into the ravine.";
    }
    
}
