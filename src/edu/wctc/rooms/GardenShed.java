package edu.wctc.rooms;

public class GardenShed extends Room implements Interactable, Lootable {
    public GardenShed(String name) {
        super(name);
    }

    private int useCount;

    @Override
    public String getDescription() {
        return """
                You are standing next to a dilapidated old shed, across the yard to the West sits the house.
                The forest stretches out in the distance to the North, South and East.
                Tall weeds and grass have long overtaken any garden that may have once been here.
                """;
    }

    @Override
    public String loot(Player player) {
        if (!this.isInteracted()) return "There might be something in the shed but the door is locked.";
        if (this.isLooted()) return "There is nothing left to take from the shed.";
        this.setLooted(true);
        player.addToInventory("rope");
        player.addToScore(5);
        return "You find a bundle of rope in the shed.";
    }
    
    // The shed has a special interaction that requires multiple attempts.
    @Override
    public String interact(Player player, Room room) {
        useCount++;
        if (room.isInteracted()) return "Rusty fragments of the shed door, padlock, and your crowbar are strewn about.";
        if (player.getInventory().contains("crowbar")) {
            switch (useCount) {
                case 1 -> {
                    player.addToScore(5);
                    return "You pry at the padlock with your crowbar.\nBits of rust flake off the metal.";
                }
                case 2 -> {
                    player.addToScore(10);
                    return """
                           You pry harder.
                           The metal groans as flecks of rust shoot off at high speeds.
                           But the padlock holds.""";
                }
                case 3 -> {
                    room.setInteracted(true);
                    player.removeFromInventory("crowbar");
                    player.addToScore(15);
                    return """
                           With an ear-splitting crack your crowbar explodes from the tension.
                           Shrapnel peppers your face and arms but the padlock has been defeated.
                           The shattered shed door sags on it's hinges.
                           """;
                }
            }
        }
        return "The shed is latched with an ancient padlock far too rusted for any key to work.";
    }

}
