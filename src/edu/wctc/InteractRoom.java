package edu.wctc;

public class InteractRoom extends Room implements Interactable {
    public InteractRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "There is a switch in this room.";
    }

    @Override
    public String interact(Player player) {
        return "You hear machines grinding in the distance.";
    }
}
