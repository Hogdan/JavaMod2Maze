package edu.wctc.rooms;

public class LoopRoom extends Room {
    public LoopRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "You feel dizzy and can't remember which direction you came from.";
    }
    
}
