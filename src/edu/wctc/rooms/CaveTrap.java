package edu.wctc.rooms;

public class CaveTrap extends Room {
    public CaveTrap(String name) {
        super(name);
    }

    @Override
    public String getDescription() {
        // This unlocks the studio when the player reaches this point automatically.
        if (this.getAdjoiningRoom('u').isLocked()) {
            this.getAdjoiningRoom('u').setLocked(false);
        }
        return """
                You reach the end of the passage and see a ladder leading up to a trap door.
                """;
    }
  
}
