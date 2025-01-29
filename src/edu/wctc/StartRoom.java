package edu.wctc;

public class StartRoom extends Room {
    public StartRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "This is the room you woke up in.";
    }
}
