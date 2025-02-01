package edu.wctc;

public class StartRoom extends Room {
    public StartRoom(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return "Painfully bright lights illumitate the empty metal room.";
    }
}
