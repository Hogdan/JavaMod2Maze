package edu.wctc;

public abstract class Room {
    protected String name;
    protected Room north, south, east, west, up, down;

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
        if (north != null) exits.append("n ");
        if (south != null) exits.append("s ");
        if (east != null) exits.append("e ");
        if (west != null) exits.append("w ");
        if (up != null) exits.append("u ");
        if (down != null) exits.append("d ");
        return exits.toString().trim();
    }

    public String getName() {
        return name;
    }

    public boolean isValidDirection(char direction) {
        return getAdjoiningRoom(direction) != null;
    }

    public void setNorth(Room room) { this.north = room; }
    public void setSouth(Room room) { this.south = room; }
    public void setEast(Room room) { this.east = room; }
    public void setWest(Room room) { this.west = room; }
    public void setUp(Room room) { this.up = room; }
    public void setDown(Room room) { this.down = room; }
}
