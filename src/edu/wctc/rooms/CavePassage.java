package edu.wctc.rooms;

public class CavePassage extends Room {
    public CavePassage(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        return """
                You are in a narrow passage that runs east and west.
                """;
    }

}
