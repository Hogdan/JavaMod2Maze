package edu.wctc;

public class ExitRoom extends Room implements Exitable {
    public ExitRoom(String name) {
        super(name);
    }

    // I'm not sure what the exit is, a portal I suppose.
    @Override
    public String getDescription() {
        return "The exit stands in the middle of this room.";
    }

    @Override
    public String exit(Player player) {
        player.addToScore(10);
        return "You have escaped Zerk.";
    }
}