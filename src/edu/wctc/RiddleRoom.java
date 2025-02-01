package edu.wctc;

public class RiddleRoom extends Room implements Interactable {
    public RiddleRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "There is something scrawled on the wall.";
    }

    @Override
    public String interact(Player player) {
        return "Here and the exit,\nSix rooms in between,\nCan't trust your eyes,\nThe route is _______.\n";
    }
}
