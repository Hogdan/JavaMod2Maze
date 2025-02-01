package edu.wctc;

public class Maze {
    private Room currentRoom;
    private Room previousRoom;
    private final Player player;
    private boolean isFinished;
    private boolean isLocked;

    public Maze() {
        this.player = new Player();
        this.isFinished = false;
        this.isLocked = true;

        Room startRoom = new StartRoom("White Room");
        Room lootRoom = new LootRoom("Pink Room");
        Room interactRoom = new InteractRoom("Indigo Room");
        Room riddleRoom = new RiddleRoom("Prism Room");
        Room loopRoom1 = new LoopRoom("Red Room");
        Room loopRoom2 = new LoopRoom("Orange Room");
        Room loopRoom3 = new LoopRoom("Yellow Room");
        Room loopRoom4 = new LoopRoom("Green Room");
        Room loopRoom5 = new LoopRoom("Blue Room");
        Room exitRoom = new ExitRoom("Gold Room");

        startRoom.setEast(lootRoom);
        lootRoom.setWest(startRoom);
        lootRoom.setEast(riddleRoom);
        riddleRoom.setWest(lootRoom);
        riddleRoom.setUp(loopRoom1);
        loopRoom1.setNorth(loopRoom2);
        loopRoom2.setSouth(loopRoom3);
        loopRoom3.setEast(loopRoom4);
        loopRoom4.setEast(loopRoom5);
        loopRoom5.setNorth(interactRoom);
        interactRoom.setNorth(riddleRoom);
        riddleRoom.setEast(exitRoom);
        exitRoom.setWest(riddleRoom);

        this.currentRoom = startRoom;
    }

    public String interactWithCurrentRoom() {
        if (currentRoom instanceof InteractRoom interactable) {
            isLocked = false;
            return interactable.interact(player);
        }
        if (currentRoom instanceof RiddleRoom riddle) {
            return riddle.interact(player);
        }
        return "There is nothing to interact with.";
    }

    public String exitCurrentRoom() {
        if (currentRoom instanceof Exitable exitable) {
            if (isLocked) return "The exit is locked.";
            isFinished = true;
            return exitable.exit(player);
        }
        return "You cannot escape the maze from this room.";
    }

    public String lootCurrentRoom() {
        if (currentRoom instanceof Lootable lootable) {
            return lootable.loot(player);
        }
        return "There is nothing to loot.";
    }

    public boolean move(char direction) {
        if (currentRoom.isValidDirection(direction)) {
            previousRoom = currentRoom;
            currentRoom = currentRoom.getAdjoiningRoom(direction);
            return true;
        } else if (currentRoom instanceof LoopRoom) {
            currentRoom = previousRoom;
            return true;
        }
        return false;
    }

    public int getPlayerLives() {
        return player.getLives();
    }

    public String getPlayerInventory() {
        return player.getInventory();
    }

    public String getCurrentRoomName() {
        return currentRoom.getName();
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
