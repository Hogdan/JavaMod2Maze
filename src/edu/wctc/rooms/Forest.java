package edu.wctc.rooms;

public class Forest extends Room {
    public Forest(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "You have become lost in a dense forest. The trees are so thick that you can't see the sky.";
    }
}
