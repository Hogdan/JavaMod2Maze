package edu.wctc.rooms;

public class RavineWall extends Room {
    public RavineWall(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return """
                Halfway into the ravine you notice an opening in the rock to the west.
                The rope bites into your hands as you hold on for dear life.
                """;
    }

}
