package edu.wctc.rooms;

public class ExitRoom extends Room implements Exitable {
    public ExitRoom(String name) {
        super(name);
    }

    // I'm not sure what the exit is, a portal I suppose.
    @Override
    public String getDescription() {
        return """
                A shimmering portal stands before you. The air around it crackles with energy.
                """;
    }

    @Override
    public String exit(Player player) {
        player.addToScore(25);
        return "Congratulations! You have escaped Zerk!";
    }
}