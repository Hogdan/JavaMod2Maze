package edu.wctc.rooms;

public abstract class Room {
    protected String name;
    protected Room north, south, east, west, up, down;
    
    // Boolean fields to keep track of various room states.
    private boolean isVisited;
    private boolean isLocked;
    private boolean isInteracted;
    private boolean isLooted;

    public Room(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    public Room getAdjoiningRoom(char direction) {
        return switch (direction) {
            case 'n' -> north;
            case 's' -> south;
            case 'e' -> east;
            case 'w' -> west;
            case 'u' -> up;
            case 'd' -> down;
            default -> null;
        };
    }

    public String getExits() {
        StringBuilder exits = new StringBuilder();
        if (this instanceof LoopRoom) return "in all directions";
        if (north != null) exits.append("north ");
        if (south != null) exits.append("south ");
        if (east != null) exits.append("east ");
        if (west != null) exits.append("west ");
        if (up != null) exits.append("upwards ");
        if (down != null) exits.append("downwards ");
        return exits.toString().trim();
    }

    public String getName() {
        return name;
    }

    public boolean isValidDirection(char direction) {
        return getAdjoiningRoom(direction) != null;
    }
    
    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public boolean isInteracted() {
        return isInteracted;
    }

    public void setInteracted(boolean interacted) {
        isInteracted = interacted;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isLooted() {
        return isLooted;
    }

    public void setLooted(boolean looted) {
        isLooted = looted;
    }

    public void setNorth(Room room) { this.north = room; }
    public void setSouth(Room room) { this.south = room; }
    public void setEast(Room room) { this.east = room; }
    public void setWest(Room room) { this.west = room; }
    public void setUp(Room room) { this.up = room; }
    public void setDown(Room room) { this.down = room; }
}
