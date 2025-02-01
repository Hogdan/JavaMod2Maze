package edu.wctc;

public class ExitRoom extends Room implements Exitable {
    public ExitRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "The exit stands in the middle of this room.";
    }

    @Override
    public String exit(Player player) {
        return "You have exited the maze.";
    }
}