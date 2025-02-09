package edu.wctc;

import edu.wctc.rooms.*;

public class Maze {
    private Room currentRoom;
    private final Room anchorRoom;
    private final Player player;
    private boolean isFinished;

    public Maze() {
        this.player = new Player();
        this.isFinished = false;

        // There ended up not being that many rooms but I had to stop myself or I would never finish the project.
        // These are the rooms around and inside the house
        Room westOfHouse = new WestOfHouse("West of House");
        Room northOfHouse = new NorthOfHouse("North of House");
        Room behindHouse = new BehindHouse("Behind House");
        Room southOfHouse = new SouthOfHouse("South of House");
        Room gardenShed = new GardenShed("Garden Shed");
        Room kitchen = new Kitchen("Kitchen");
        Room foyer = new Foyer("Foyer");
        Room studio = new Studio("Studio");
        Room basement = new Basement("Basement");
        // Apart from the riddle room, maze, and exit here.
        Room riddleRoom = new RiddleRoom("Riddle Room");
        Room riddle1 = new LoopRoom("Dark Room");
        Room riddle2 = new LoopRoom("Dark Room");
        Room riddle3 = new LoopRoom("Dark Room");
        Room riddle4 = new LoopRoom("Dark Room");
        Room riddle5 = new LoopRoom("Dark Room");
        Room exitRoom = new ExitRoom("Exit Room");
        // Misc rooms for the outskirts of the map.
        Room forest = new Forest("Forest");
        Room mountains = new Mountains("Mountains");
        Room glade = new Glade("Glade");
        Room ravine = new Ravine("Ravine");
        Room ravineWall = new RavineWall("Ravine Wall");
        Room ravineCave = new RavineCave("Ravine Cave");
        Room cavePassage = new CavePassage("Cave Passage");
        Room caveTrap = new CaveTrap("Cave Trap");

        // Setting all the connections between rooms.
        westOfHouse.setWest(forest);
        westOfHouse.setNorth(northOfHouse);
        westOfHouse.setSouth(southOfHouse);

        northOfHouse.setNorth(glade);
        northOfHouse.setEast(behindHouse);
        northOfHouse.setWest(westOfHouse);

        behindHouse.setNorth(northOfHouse);
        behindHouse.setEast(gardenShed);
        behindHouse.setSouth(southOfHouse);
        behindHouse.setWest(kitchen);

        gardenShed.setWest(behindHouse);
        gardenShed.setEast(forest);
        gardenShed.setNorth(forest);
        gardenShed.setSouth(forest);

        southOfHouse.setEast(behindHouse);
        southOfHouse.setWest(westOfHouse);
        southOfHouse.setSouth(forest);

        kitchen.setLocked(true);
        kitchen.setEast(behindHouse);
        kitchen.setNorth(foyer);
        kitchen.setDown(basement);

        basement.setUp(kitchen);

        foyer.setNorth(studio);
        foyer.setSouth(kitchen);
        foyer.setEast(riddleRoom);

        studio.setDown(caveTrap);
        studio.setSouth(foyer);
        studio.setLocked(true);

        // The riddle maze logic works by setting a chain of dark rooms with one exit.
        riddleRoom.setLocked(true);
        riddleRoom.setWest(foyer);
        riddleRoom.setUp(riddle1);
        // If the player moves up in the riddle room they have started the maze.
        // These rooms are all duplicates but each points to the next link in the chain.
        riddle1.setNorth(riddle2);
        riddle2.setSouth(riddle3);
        riddle3.setEast(riddle4);
        riddle4.setEast(riddle5);
        riddle5.setNorth(exitRoom);
        // If successful the player will reach the exit room and be able to win the game.

        // The glade branches off to provide an alternate path.
        glade.setSouth(northOfHouse);
        glade.setNorth(mountains);
        glade.setEast(ravine);

        ravine.setWest(glade);
        ravine.setNorth(mountains);
        ravine.setDown(ravineWall);

        ravineWall.setLocked(true);
        ravineWall.setUp(ravine);
        ravineWall.setWest(ravineCave);

        ravineCave.setEast(ravineWall);
        ravineCave.setWest(cavePassage);

        cavePassage.setEast(ravineCave);
        cavePassage.setWest(caveTrap);
        caveTrap.setEast(cavePassage);
        caveTrap.setUp(studio);

        // The forest surrounds the house according to the description.
        // For simplicity it's just one room the player ends up in for moving too far away from the house.
        // It links back to the house when the player moves out a direction other than South.
        forest.setEast(westOfHouse);
        forest.setWest(gardenShed);
        forest.setNorth(southOfHouse);
        forest.setSouth(forest);

        // The mountains don't do anything yet.
        mountains.setSouth(glade);

        this.currentRoom = westOfHouse;
        this.anchorRoom = riddleRoom;
    }

    public String interactWithCurrentRoom() {
        if (currentRoom instanceof Interactable interactable) {
            player.incrementActions();
            return interactable.interact(player, currentRoom);
        }
        return "There is nothing to interact with.";
    }

    public String exitCurrentRoom() {
        if (currentRoom instanceof Exitable exitable) {
            isFinished = true;
            player.incrementActions();
            return exitable.exit(player);
        }
        return "You cannot escape Zerk from here.";
    }

    public String lootCurrentRoom() {
        if (currentRoom instanceof Lootable lootable) {
            player.incrementActions();
            return lootable.loot(player);
        }
        return "There is nothing to loot.";
    }

    // The move method is ugly but it works.
    public String move(char direction) {
        // When the input matches an exit from the current room.
        if (currentRoom.isValidDirection(direction)) {
            if (currentRoom.getAdjoiningRoom(direction) instanceof Bounceable) {
                // Bounceable rooms aren't enterable, they provide text to simulate having to turn back.
                return currentRoom.getAdjoiningRoom(direction).getDescription();
            } else if (currentRoom.getAdjoiningRoom(direction).isLocked()) {
                // This is for locked rooms.
                return "The way is currently impassable.";
            } else if (currentRoom.getAdjoiningRoom(direction) instanceof Tripable
                    && !player.getInventory().contains("lantern")) {
                // Trippable rooms will cause a game over without the lantern.
                isFinished = true;
                return "You trip in the darkness and break your neck.";
            }
            // Otherwise you move to the next room.
            player.incrementActions();
            currentRoom = currentRoom.getAdjoiningRoom(direction);
            return "you move %s.".formatted(direction);
        }
        // For incorrect moves in the loop maze the move is not valid and handled here.
        if (currentRoom instanceof LoopRoom) {
            player.incrementActions();
            currentRoom = anchorRoom;
            return "You get lost for a while.";
        }
        // Default return for invalid moves.
        return "You cannot move in that direction.";
    }

    public String getPlayerScore() {
        return "%s points".formatted(player.getScore());
    }

    public String getPlayerActions() {
        return "%s actions".formatted(player.getActions());
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

    // I left this method in but it is not used due to redundancy.
    // The room descriptions are written to describe which ways the player can go.
    public String getCurrentRoomExits() {
        return currentRoom.getExits();
    }

    // Following Zork, the room description is only show on first visit to a room unless look is used.
    public String isFirstVisit() {
        if (!currentRoom.isVisited()) {
            currentRoom.setVisited(true);
            return currentRoom.getDescription();
        }
        return "";
    }

    public boolean isFinished() {
        return isFinished;
    }

    public String finishGame() {
        isFinished = true;
        return "You have quit the game.";
    }
}
