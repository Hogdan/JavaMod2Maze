package edu.wctc;

public class InteractRoom extends Room implements Interactable {
    public InteractRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "You can interact with this room.";
    }

    @Override
    public String interact(Player player) {
        player.addToScore(10);
        return "You gained 10 points!";
    }
}
