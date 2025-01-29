package edu.wctc;

public class Maze {
    private Room currentRoom;
    private final Player player;
    private boolean isFinished;

    public Maze() {
        this.player = new Player();
        this.isFinished = false;

        Room startRoom = new StartRoom("Start Room");
        Room lootRoom = new LootRoom("Loot Room");
        Room interactRoom = new InteractRoom("Interact Room");
        Room exitRoom = new ExitRoom("Exit Room");

        startRoom.setEast(lootRoom);
        lootRoom.setWest(startRoom);
        lootRoom.setEast(interactRoom);
        interactRoom.setWest(lootRoom);
        interactRoom.setEast(exitRoom);
        exitRoom.setWest(interactRoom);

        this.currentRoom = startRoom;
    }

    public String exitCurrentRoom() {
        if (currentRoom instanceof Exitable exitable) {
            isFinished = true;
            return exitable.exit(player);
        }
        return "The current room is not exitable.";
    }

    public String interactWithCurrentRoom() {
        if (currentRoom instanceof Interactable interactable) {
            return interactable.interact(player);
        }
        return "No interactions are possible.";
    }

    public String lootCurrentRoom() {
        if (currentRoom instanceof Lootable lootable) {
            return lootable.loot(player);
        }
        return "The current room is not lootable.";
    }

    public boolean move(char direction) {
        if (currentRoom.isValidDirection(direction)) {
            currentRoom = currentRoom.getAdjoiningRoom(direction);
            return true;
        }
        return false;
    }

    public int getPlayerScore() {
        return player.getScore();
    }

    public String getPlayerInventory() {
        return player.getInventory();
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

    public String getCurrentRoomExits() {
        return currentRoom.getExits();
    }

    public boolean isFinished() {
        return isFinished;
    }
}
